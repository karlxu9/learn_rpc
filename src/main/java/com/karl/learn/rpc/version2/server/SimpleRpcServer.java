package com.karl.learn.rpc.version2.server;

import com.karl.learn.rpc.version2.thread.ThreadWorker;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模块描述: <br>
 * 【】
 *
 * @Author: Mr. YuBang.Xu
 * @Date: 2020/9/11 10:58
 * @since: 1.8.0
 * @version: 1.0.0
 */
@Slf4j
public class SimpleRpcServer implements RpcServer {

    private ServiceProvider serverProvider;

    public SimpleRpcServer(ServiceProvider serverProvider) {
        this.serverProvider = serverProvider;
    }

    @Override
    public void start(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            log.info("单线程服务端启动!");
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new ThreadWorker<>(socket, serverProvider)).start();
            }
        } catch (IOException e) {
            log.error("服务启动失败");
        }
    }

    @Override
    public void stop() {

    }
}
