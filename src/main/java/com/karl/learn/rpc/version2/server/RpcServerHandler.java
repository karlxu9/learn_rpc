package com.karl.learn.rpc.version2.server;

import com.karl.learn.rpc.version0.service.*;

/**
 * 模块描述: <br>
 * 【】
 *
 * @Author: Mr. YuBang.Xu
 * @Date: 2020/9/11 11:16
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class RpcServerHandler {

    public static void main(String[] args) {
        BlogService blogService = new BlogServiceImpl();
        UserService userService = new UserServiceImpl();
        BlogService blogService2 = new BlogService2Impl();
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.providerServiceInterface(blogService);
        serviceProvider.providerServiceInterface(userService);
        serviceProvider.providerServiceInterface(blogService2);

        RpcServer rpcServer = new MultithreadRpcServer(serviceProvider);
        rpcServer.start(11111);

    }

}
