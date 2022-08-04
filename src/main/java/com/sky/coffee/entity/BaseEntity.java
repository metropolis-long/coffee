package com.sky.coffee.entity;

import com.sky.coffee.tool.sensitivity.SensitiveData;
import com.sky.coffee.tool.sensitivity.SensitiveField;

@SensitiveData
public class BaseEntity {
    @SensitiveField
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
