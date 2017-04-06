package com.example.controller;

import com.example.properties.GirlProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA
 * Created By maxiaoyao
 * Date: 2017/4/2
 * Time: 下午10:01
 */
@RestController
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "cupSize", method = RequestMethod.GET)
    public String cupSize() {
        return girlProperties.getCupSize() + ":" + girlProperties.getAge();
    }

    @GetMapping(value = "getCupSize")
    public String getCupSize(@RequestParam(name = "id", required = false, defaultValue = "0") Integer id) {
        return girlProperties.getCupSize() + ":" + girlProperties.getAge();
    }

    @PostMapping(value = "cupSize/{id}")
    public String post(@PathVariable("id") Integer id) {
        return girlProperties.getCupSize() + ":" + girlProperties.getAge();
    }
}
