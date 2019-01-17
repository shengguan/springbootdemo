package com.gb.springbootdemo.propertites;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取application.yml 的配置文件
 */
@Component
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {


    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    private String cupSize;


}
