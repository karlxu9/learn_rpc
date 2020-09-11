package com.karl.learn.rpc.version2.server;

import com.karl.learn.rpc.version2.thread.ThreadWorker;
import lombok.extern.slf4j.Slf4j;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 模块描述: <br>
 * 【】
 *
 * @Author: Mr. YuBang.Xu
 * @Date: 2020/9/11 12:07
 * @since: 1.8.0
 * @version: 1.0.0
 */
@Slf4j
public class MultithreadRpcServer implements RpcServer {

    private ServiceProvider serviceProvider;

    private ExecutorService executorService;

    public MultithreadRpcServer(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;

        this.executorService = new ThreadPoolExecutor(5, 10, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10),
                new ThreadFactory() {
                    private final AtomicInteger count = new AtomicInteger(1);

                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r, "MyThread-Rpc-" + count.getAndIncrement());
                        log.info("启动线程 ThreadName: " + t.getName());
                        return t;
                    }
                });
    }

    @Override
    public void start(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            log.info("多线程版服务端启动!");
            while (true) {
                Socket socket = serverSocket.accept();
                executorService.submit(new ThreadWorker<>(socket, serviceProvider));
            }
        } catch (Exception e) {
            log.error("多线程服务端启动失败:", e);
        }
    }

    @Override
    public void stop() {
        executorService.shutdown();
    }
}
