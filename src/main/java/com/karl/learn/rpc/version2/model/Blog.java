package com.karl.learn.rpc.version2.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * 模块描述: <br>
 * 【】
 *
 * @Author: Mr. YuBang.Xu
 * @Date: 2020/9/11 10:40
 * @since: 1.8.0
 * @version: 1.0.0
 */
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Blog implements Serializable {

    Integer id;

    String name;

    String desc;

}
