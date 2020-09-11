package com.karl.learn.rpc.version1.proxy;

import com.karl.learn.rpc.version1.common.Request;
import com.karl.learn.rpc.version1.common.Response;
import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模块描述: <br>
 * 【】
 *
 * @Author: Mr. YuBang.Xu
 * @Date: 2020/9/10 17:54
 * @since: 1.8.0
 * @version: 1.0.0
 */
@AllArgsConstructor
public class RpcProxy implements InvocationHandler {

    private final String host;
    private final int port;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Request request = Request.builder().interfaceName(method.getDeclaringClass().getName()).methodName(method.getName())
                .params(args).paramType(method.getParameterTypes()).build();
        Response<Object> response = RpcHandler.sendRequest(host, port, request);
        if (response != null) {
            return response.getData();
        }
        return null;
    }

    public <T> T getProxy(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, this);
    }
}
