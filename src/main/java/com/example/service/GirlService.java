package com.example.service;

import com.alibaba.fastjson.JSON;
import com.example.RedisKey;
import com.example.model.Girl;
import com.example.repository.GirlDBRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By maxiaoyao
 * Date: 2017/4/4
 * Time: 下午9:49
 */
@Service
public class GirlService {
    private static final Logger logger = LoggerFactory.getLogger(GirlService.class);
    @Autowired
    private GirlDBRepository girlDBRepository;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public List<Girl> findAll() {
        return girlDBRepository.findAll();
    }

    public void save(Girl girl) {
        girlDBRepository.save(girl);
    }

    public Girl findOne(Integer id) {
        String key = String.format(RedisKey.GIRL, id);
        Girl girl = findInRedis(key);
        if (girl == null) {
            girl = findInDB(id);
            stringRedisTemplate.opsForValue().set(key, JSON.toJSONString(girl));
        }
        return girl;
    }

    private Girl findInDB(Integer id) {
        Girl girl = girlDBRepository.findOne(id);
        return girl;
    }

    private Girl findInRedis(String key) {
        if (stringRedisTemplate.hasKey(key)) {
            String girlStr = stringRedisTemplate.opsForValue().get(key);
            Girl girl = JSON.parseObject(girlStr, Girl.class);
            logger.info("girl{}", girl.toString());
            return girl;
        }
        return null;
    }
}
