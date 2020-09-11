package com.karl.learn.rpc.version1.proxy;

import com.karl.learn.rpc.version1.common.Request;
import com.karl.learn.rpc.version1.common.Response;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 模块描述: <br>
 * 【】
 *
 * @Author: Mr. YuBang.Xu
 * @Date: 2020/9/10 17:59
 * @since: 1.8.0
 * @version: 1.0.0
 */
@AllArgsConstructor
public class RpcHandler {


    public static <T> Response<T> sendRequest(String host, int port, Request request) {
        try (Socket socket = new Socket(host, port);
             ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
             ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {

            oos.writeObject(request);
            oos.flush();

            return (Response<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
