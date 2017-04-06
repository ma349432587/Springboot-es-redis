package com.example.repository;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA
 * Created By maxiaoyao
 * Date: 2017/4/7
 * Time: 上午5:23
 */
public abstract class BaseRepository <T extends Serializable> {
    public void save(T t) {

    }
}
