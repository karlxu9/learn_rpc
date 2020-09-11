package com.karl.learn.rpc.version1.client;

import com.karl.learn.rpc.version0.model.User;
import com.karl.learn.rpc.version0.service.UserService;
import com.karl.learn.rpc.version1.proxy.RpcProxy;
import lombok.extern.slf4j.Slf4j;

/**
 * 模块描述: <br>
 * 【】
 *
 * @Author: Mr. YuBang.Xu
 * @Date: 2020/9/10 18:27
 * @since: 1.8.0
 * @version: 1.0.0
 */
@Slf4j
public class RpcClient {

    public static void main(String[] args) {
        RpcProxy proxy = new RpcProxy("127.0.0.1", 8080);

        UserService instance = proxy.getProxy(UserService.class);
        User userById = instance.getUserById(10);
        log.info("userInfo:{} ", userById);

        String result = instance.insert(User.builder().id(11).name("xxxx").age(10910).build());
        log.info("result: {}", result);
    }

}
