package com.karl.learn.rpc.version0.service;

import com.karl.learn.rpc.version0.model.User;

/**
 * 模块描述: <br>
 * 【】
 *
 * @Author: Mr. YuBang.Xu
 * @Date: 2020/9/10 17:38
 * @since: 1.8.0
 * @version: 1.0.0
 */
public interface UserService {

    User getUserById(Integer id);

    String insert(User user);

}
