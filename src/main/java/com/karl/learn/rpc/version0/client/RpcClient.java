package com.karl.learn.rpc.version0.client;

import com.karl.learn.rpc.version0.model.User;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 模块描述: <br>
 * 【】
 *
 * @Author: Mr. YuBang.Xu
 * @Date: 2020/9/10 17:43
 * @since: 1.8.0
 * @version: 1.0.0
 */
@Slf4j
public class RpcClient {


    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8080);
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeInt(1);
            oos.flush();

            User user = (User) ois.readObject();
            log.info("user: {}", user);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
