package com.example.controller;

import com.example.Result;
import com.example.model.Girl;
import com.example.service.GirlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

/**
 * Created with IntelliJ IDEA
 * Created By maxiaoyao
 * Date: 2017/4/3
 * Time: 下午9:08
 */
@RestController
public class GirlController {

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "girls")
    public Result<List<Girl>> getGirls() {
        return Result.success(girlService.findAll());
    }

    @PostMapping(value = "girls")
    public Result<Boolean> addGirl(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return Result.fail(-255, bindingResult.getFieldError().getDefaultMessage());
        }
        girlService.save(girl);
        return Result.success(true);
    }
}
