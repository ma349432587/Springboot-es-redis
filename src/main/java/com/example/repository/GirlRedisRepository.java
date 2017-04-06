package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA
 * Created By maxiaoyao
 * Date: 2017/4/6
 * Time: 下午11:58
 */
@Component
public class GirlRedisRepository  {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

}
