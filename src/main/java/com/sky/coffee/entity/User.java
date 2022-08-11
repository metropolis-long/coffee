package com.sky.coffee.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.sky.coffee.tool.sensitivity.SensitiveData;
import com.sky.coffee.tool.sensitivity.SensitiveField;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author zhuye
 * @since 2022-08-03
 */
@SensitiveData
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid;

    /**
     * 用户名
     */
    private String loginName;

    /**
     * 密文
     */
    private String pwd;

    /**
     * 手机号
     */
    @SensitiveField
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密钥
     */
    private String salt;

    /**
     * 删除
     */
    private Integer deleted;

    /**
     * 创建时间
     */
    private LocalDateTime created;

    /**
     * 最后修改时间
     */
    private LocalDateTime modified;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "User{" +
            "uid=" + uid +
            ", loginName=" + loginName +
            ", pwd=" + pwd +
            ", mobile=" + mobile +
            ", email=" + email +
            ", salt=" + salt +
            ", deleted=" + deleted +
            ", created=" + created +
            ", modified=" + modified +
        "}";
    }
}
