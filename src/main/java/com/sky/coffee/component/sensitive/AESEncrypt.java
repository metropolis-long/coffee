package com.sky.coffee.component.sensitive;

import com.sky.coffee.tool.AESUtil;
import com.sky.coffee.tool.sensitivity.SensitiveEncodeTool;
import com.sky.coffee.tool.sensitivity.SensitiveField;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Objects;

@Component
public class AESEncrypt implements SensitiveEncodeTool {


    /**
     * 加密
     *
     * @param declaredFields paramsObject所声明的字段
     * @param paramsObject   mapper中paramsType的实例
     * @return T
     * @throws IllegalAccessException 字段不可访问异常
     */
    @Override
    public <T> T encrypt(Field[] declaredFields, T paramsObject) throws IllegalAccessException {
        for (Field field : declaredFields) {
            //取出所有被EncryptDecryptField注解的字段
            SensitiveField sensitiveField = field.getAnnotation(SensitiveField.class);
            if (!Objects.isNull(sensitiveField)) {
                field.setAccessible(true);
                Object object = field.get(paramsObject);
                //暂时只实现String类型的加密
                if (object instanceof String) {
                    String value = (String) object;
                    //加密  这里我使用自定义的AES加密工具
                    try {
                        field.set(paramsObject, AESUtil.encrypt(value));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return paramsObject;
    }
}