package com.karl.learn.rpc.version2.server;

/**
 * 模块描述: <br>
 * 【】
 *
 * @Author: Mr. YuBang.Xu
 * @Date: 2020/9/11 10:57
 * @since: 1.8.0
 * @version: 1.0.0
 */
public interface RpcServer {

    void start(int port);

    void stop();

}
