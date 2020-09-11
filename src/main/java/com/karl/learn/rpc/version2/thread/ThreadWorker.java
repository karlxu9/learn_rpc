package com.karl.learn.rpc.version2.thread;

import com.karl.learn.rpc.version1.common.Request;
import com.karl.learn.rpc.version1.common.Response;
import com.karl.learn.rpc.version2.server.ServiceProvider;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * 模块描述: <br>
 * 【】
 *
 * @Author: Mr. YuBang.Xu
 * @Date: 2020/9/11 10:45
 * @since: 1.8.0
 * @version: 1.0.0
 */
@Slf4j
@AllArgsConstructor
public class ThreadWorker<T> implements Runnable {

    private Socket socket;
    private ServiceProvider serverProvider;

    @Override
    public void run() {

        try {
            log.info("当前执行线程为：{}", Thread.currentThread().getName());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Request request = (Request) ois.readObject();
            Response<T> response = getResponse(request);
            oos.writeObject(response);
            oos.flush();

        } catch (Exception e) {
            log.error("rpc请求失败 ", e);
        }

    }

    private Response<T> getResponse(Request request) {
        String interfaceName = request.getInterfaceName();
        Object service = serverProvider.get(interfaceName);

        try {
            Method declaredMethod = service.getClass().getMethod(request.getMethodName(), request.getParamType());
            Object invoke = declaredMethod.invoke(service, request.getParams());
            return Response.success(invoke);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            log.error("rpc请求失败", e);
        }
        return null;
    }
}
