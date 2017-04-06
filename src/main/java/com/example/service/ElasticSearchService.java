package com.example.service;

import com.example.model.Girl;
import com.example.repository.GirlDBRepository;
import com.example.search.GirlSearchRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA
 * Created By maxiaoyao
 * Date: 2017/4/6
 * Time: 下午9:37
 */
@Service
public class ElasticSearchService {

    @Autowired
    private GirlSearchRepository elasticSearchRepository;
    @Autowired
    private GirlDBRepository girlDBRepository;


    public void save(Girl girl) {

        elasticSearchRepository.save(girl);

        girlDBRepository.save(girl);

    }
}
