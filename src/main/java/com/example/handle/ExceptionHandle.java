package com.example.handle;

import com.example.Result;
import com.example.exception.GirlException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA
 * Created By maxiaoyao
 * Date: 2017/4/4
 * Time: 下午12:51
 */
@ControllerAdvice
public class ExceptionHandle {
    private static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = GirlException.class)
    @ResponseBody
    public Result girlHandle(GirlException e) {
        if (e instanceof GirlException) {
            return Result.fail(e.getCode(), e.getMessage());
        }
        logger.error("未知错误:{}",e);
        return Result.fail(-1, "未知错误");
    }
}
