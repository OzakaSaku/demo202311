package com.example.common;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class R<T> {

    private Integer code; //编码：0成功，1和其它数字为失败

    private String msg; //错误信息

    private T data; //数据

    private Map map = new HashMap(); //动态数据

    public static <T> R<T> ok() {
        R<T> r = new R<T>();
        r.code = 0;
        return r;
    }
    
    public static <T> R<T> success(T object) {
        R<T> r = new R<T>();
        r.data = object;
        r.code = 0;
        return r;
    }

    public static <T> R<T> error(String msg) {
        R r = new R();
        r.msg = msg;
        r.code = 1;
        return r;
    }

    public R<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }
}
