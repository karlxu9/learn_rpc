package com.karl.learn.rpc.version0.service;

import com.karl.learn.rpc.version0.model.User;
import lombok.extern.slf4j.Slf4j;

/**
 * 模块描述: <br>
 * 【】
 *
 * @Author: Mr. YuBang.Xu
 * @Date: 2020/9/10 17:41
 * @since: 1.8.0
 * @version: 1.0.0
 */
@Slf4j
public class UserServiceImpl implements UserService {
    @Override
    public User getUserById(Integer id) {
        User xyub = User.builder().age(10).name("xyub").id(id).build();
        return xyub;
    }

    @Override
    public String insert(User user) {
        log.info("插入数据user ：{}", user);
        return "插入数据" + user;
    }
}
