package com.sky.coffee.msg;

import java.io.Serializable;
import java.util.HashMap;

public class ResultBody<T> implements Serializable {
    private Integer code=200;
    private String msg ;
    private T data;

    public ResultBody() {
    }
    public ResultBody(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultBody(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultBody(T data) {
        this.data = data;
    }
    private HashMap adds = new HashMap();
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Object getAdd(String key) {
        return adds.get(key);
    }
    public void setAdd(String key,Object value) {
        this.adds.put(key,value);
    }

    public HashMap getAdds() {
        return adds;
    }

    public void setAdds(HashMap adds) {
        this.adds = adds;
    }

    /**
     * 设置分页总数.
     * @param count
     */
    public void setCount(Integer count){
        adds.put("count",count);
    }
}
