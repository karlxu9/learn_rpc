package com.karl.learn.rpc.version2.client;

import com.karl.learn.rpc.version0.model.User;
import com.karl.learn.rpc.version0.service.UserService;
import com.karl.learn.rpc.version1.proxy.RpcProxy;

/**
 * 模块描述: <br>
 * 【】
 *
 * @Author: Mr. YuBang.Xu
 * @Date: 2020/9/11 11:14
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class RpcClient {

    public static void main(String[] args) {
        RpcProxy rpcProxy = new RpcProxy("127.0.0.1", 11111);
        UserService proxy = rpcProxy.getProxy(UserService.class);
        User userById = proxy.getUserById(100);
        System.out.println(userById);

        String xxx = proxy.insert(User.builder().id(10).name("xxx").age(199).build());
        System.out.println(xxx);
    }

}
