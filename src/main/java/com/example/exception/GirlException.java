package com.example.exception;

import lombok.Getter;

/**
 * Created with IntelliJ IDEA
 * Created By maxiaoyao
 * Date: 2017/4/4
 * Time: 下午12:53
 */
@Getter
public class GirlException extends RuntimeException {

    public  GirlException(Integer code,String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    private Integer code;

    private String message;

}
