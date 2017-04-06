package com.example.model;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Created with IntelliJ IDEA
 * Created By maxiaoyao
 * Date: 2017/4/3
 * Time: 下午9:04
 */
@Entity
@Data
@Document(indexName = "findGirl")
public class Girl implements Serializable{

    private static final long serialVersionUID = -2782973706780828926L;

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "罩杯必填")
    private String cupSize;

    @Min(value = 18,message = "未满十八岁")
    private Integer age;

    @NotNull(message = "金额必填")
    private Double amount;

}
