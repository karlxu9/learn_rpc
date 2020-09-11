package com.karl.learn.rpc.version1.server;

import com.karl.learn.rpc.version0.service.UserServiceImpl;
import com.karl.learn.rpc.version1.common.Request;
import com.karl.learn.rpc.version1.common.Response;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模块描述: <br>
 * 【】
 *
 * @Author: Mr. YuBang.Xu
 * @Date: 2020/9/10 18:16
 * @since: 1.8.0
 * @version: 1.0.0
 */
@Slf4j
public class RpcServer {


    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        try (ServerSocket socket = new ServerSocket(8080)) {
            while (true) {
                Socket accept = socket.accept();
                new Thread(() -> {
                    try (ObjectOutputStream oos = new ObjectOutputStream(accept.getOutputStream());
                         ObjectInputStream ois = new ObjectInputStream(accept.getInputStream())) {

                        Request request = (Request) ois.readObject();
                        Method declaredMethod = userService.getClass().getMethod(request.getMethodName(), request.getParamType());

                        Object invoke = declaredMethod.invoke(userService, request.getParams());

                        oos.writeObject(Response.success(invoke));
                        oos.flush();
                    } catch (IOException | ClassNotFoundException | NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
