package com.karl.learn.rpc.version0.server;

import com.karl.learn.rpc.version0.model.User;
import com.karl.learn.rpc.version0.service.UserService;
import com.karl.learn.rpc.version0.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模块描述: <br>
 * 【】
 *
 * @Author: Mr. YuBang.Xu
 * @Date: 2020/9/10 17:32
 * @since: 1.8.0
 * @version: 1.0.0
 */
@Slf4j
public class RpcServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("服务端启动");
            while (true) {
                Socket accept = serverSocket.accept();

                new Thread(() -> {
                    try {
                        ObjectOutputStream oos = new ObjectOutputStream(accept.getOutputStream());
                        ObjectInputStream ois = new ObjectInputStream(accept.getInputStream());
                        int id = ois.readInt();
                        UserService userService = new UserServiceImpl();
                        User user = userService.getUserById(id);
                        oos.writeObject(user);
                        oos.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                        log.error("处理rpc请求失败");
                    }

                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error("服务器启动失败");
        }
    }

}
