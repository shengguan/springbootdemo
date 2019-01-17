package com.gb.springbootdemo.bean;

import org.springframework.context.annotation.Primary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class UserBean {
    @Id
    @GeneratedValue
    private Integer id;

    private String userName;

    private String password;

    @Min(value = 0, message = "年龄必须大于0")
    @Max(value = 200, message = "年龄超出")
    private Integer age;


}
