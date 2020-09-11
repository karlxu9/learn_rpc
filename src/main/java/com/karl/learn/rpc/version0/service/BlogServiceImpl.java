package com.karl.learn.rpc.version0.service;

import com.karl.learn.rpc.version2.model.Blog;

/**
 * 模块描述: <br>
 * 【】
 *
 * @Author: Mr. YuBang.Xu
 * @Date: 2020/9/11 10:44
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class BlogServiceImpl implements BlogService {
    @Override
    public Blog getById(Integer id) {
        return Blog.builder().id(10).name("书本").desc("哈哈哈呵呵呵").build();
    }
}
