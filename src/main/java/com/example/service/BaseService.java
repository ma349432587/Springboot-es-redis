package com.example.service;

import com.example.repository.BaseRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA
 * Created By maxiaoyao
 * Date: 2017/4/7
 * Time: 上午5:21
 */
public class BaseService<T extends Serializable> {
    @Autowired
    protected BaseRepository<T> baseRepository;

    public void save(T t) {
        baseRepository.save(t);
    }
}
