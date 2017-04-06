package com.example.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * Created with IntelliJ IDEA
 * Created By maxiaoyao
 * Date: 2017/4/2
 * Time: 下午10:30
 */
@ConfigurationProperties(prefix = "girl")
@Data
@Component
public class GirlProperties {
    private Integer age;
    private String cupSize;

    public static void main(String[] args) {
        String b= new String("as");
        String a= "as";
        System.out.println(a == b);

    }

}
