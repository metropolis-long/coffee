package com.sky.coffee.tool.sensitivity;

import java.lang.reflect.Field;

public interface SensitiveDecodeTool {


    /**
     * 解密
     *
     * @param result resultType的实例
     * @return T
     * @throws IllegalAccessException 字段不可访问异常
     */
    <T> T decrypt(T result) throws IllegalAccessException;
}
