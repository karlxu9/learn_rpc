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
 * @Date: 2020/9/10 17:49
 * @since: 1.8.0
 * @version: 1.0.0
 */
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Request implements Serializable {

    String interfaceName;

    String methodName;

    Object[] params;

    Class<?>[] paramType;

}
