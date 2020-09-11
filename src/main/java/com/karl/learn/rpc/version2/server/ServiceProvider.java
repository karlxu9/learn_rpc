package com.karl.learn.rpc.version2.server;

import java.util.HashMap;
import java.util.Map;

/**
 * 模块描述: <br>
 * 【】
 *
 * @Author: Mr. YuBang.Xu
 * @Date: 2020/9/11 11:07
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class ServiceProvider {

    private Map<String, Object> serverProvider;

    public ServiceProvider() {
        serverProvider = new HashMap<>();
    }

    public void providerServiceInterface(Object service) {
        Class<?>[] interfaces = service.getClass().getInterfaces();
        for (Class<?> clazz : interfaces) {
            serverProvider.put(clazz.getName(), service);
        }
    }

    public Object get(String key) {
        return serverProvider.get(key);
    }

}
