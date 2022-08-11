package com.sky.coffee.msg;

/**
 *
 */
public enum ResultCodeMsg {
    OK(200,"成功",1),
    ERROR(-1,"失败",1),
    SAVE_ERR(-2,"保存失败",1),
    DELETE_ERR(-3,"删除失败",1),
    REG_ERR(300,"注册失败",1),
    /**
     * 用户名已被注册过.
     */
    HAS_USER_REGISTER(301,"用户名已被注册过",1),
    REG_CODE_ERR(302,"验证码无效，注册失败",1),
    REG_EMAIL_ERR(303,"注册邮箱错误，请使用正确的邮箱注册",1),

    NO_USER(501,"用户不存在",1),
    LOGIN_PWD_ERR(301,"密码错误",1),
    PARAM_IS_BLANK(400,"参数为空",1),
    PARAM_ERR(402,"参数错误",1),
    NO_SUCH_FILE(-333,"文件不存在",1),
    DISABLED(998,"禁用",1),
    NO_AUTH(999,"正在尝试修改非当前数据，已通知系统管理员进行处理",1),
    NO_LOGIN(100,"未登录",1)
    ;
    private Integer code=200;
    private String msg;
    /**
     *消息类型，默认1 web端
     */
    private Integer type;

    ResultCodeMsg() {
    }

    ResultCodeMsg(int code, String msg, int type) {
        this.code = code;
        this.msg = msg;
        this.type = type;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public static void main(String[] args) {
        System.out.println(ResultCodeMsg.OK.getMsg());
    }
}
