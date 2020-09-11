package com.karl.learn.rpc.version1.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * 模块描述: <br>
 * 【】
 *
 * @Author: Mr. YuBang.Xu
 * @Date: 2020/9/10 18:15
 * @since: 1.8.0
 * @version: 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable {

    Integer id;

    String name;

    Integer age;
}
