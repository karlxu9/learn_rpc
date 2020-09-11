package com.karl.learn.rpc.version1.common;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * 模块描述: <br>
 * 【】
 *
 * @Author: Mr. YuBang.Xu
 * @Date: 2020/9/10 17:50
 * @since: 1.8.0
 * @version: 1.0.0
 */
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Response<T> implements Serializable {

    T data;

    String message;

    Integer code;

    public static Response success() {
        return Response.builder().code(0).data(null).message("成功").build();
    }

    public static <T> Response success(T data) {
        return Response.builder().code(0).data(data).message("成功").build();
    }
}
