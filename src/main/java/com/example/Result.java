package com.example;

import java.io.Serializable;

import lombok.Data;

/**
 * Created with IntelliJ IDEA
 * Created By maxiaoyao
 * Date: 2017/4/4
 * Time: 下午12:25
 */
@Data
public class Result<T> implements Serializable{

    private Integer code;
    private String message;
    private T data;

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(0);
        result.setMessage("成功");
        result.setData(data);
        return result;
    }
    public static Result fail(Integer code,String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setData(null);
        return result;
    }
}
