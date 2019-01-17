package com.gb.springbootdemo.bean;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@ApiModel(description = "女生实体")
@Entity
public class Girl {

    @ApiModelProperty(value = "自增加id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ApiModelProperty(value = "女生年龄信息")
    @Min(value = 18, message = "年龄必须大于18")
    private Integer age;
    @ApiModelProperty(value = "女生CUP信息")
    @NotEmpty(message = "cupsize 不能为空")
    private String cupSize;
    @ApiModelProperty(value = "钱信息")
    private Double money;

    public Girl() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
