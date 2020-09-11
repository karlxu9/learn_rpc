package com.karl.learn.rpc.version0.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * 模块描述: <br>
 * 【】
 *
 * @Author: Mr. YuBang.Xu
 * @Date: 2020/9/10 17:39
 * @since: 1.8.0
 * @version: 1.0.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class User implements Serializable {

    private Integer id;

    private String name;

    private Integer age;
}
