package com.example.enums;

import lombok.Getter;

/**
 * Created with IntelliJ IDEA
 * Created By maxiaoyao
 * Date: 2017/4/4
 * Time: 下午9:42
 */
@Getter
public enum  ResultEnum {
    UNKNOWN_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    PRIMARY_SCHOOL(100, "还在上小学"),
    MIDDLE_SCHOOL(101,"还在上初中")
    ;
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
