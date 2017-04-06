package com.example.search;


import com.example.model.Girl;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created with IntelliJ IDEA
 * Created By maxiaoyao
 * Date: 2017/4/6
 * Time: 下午9:34
 */
public interface GirlSearchRepository extends ElasticsearchRepository<Girl,Integer> {

}
