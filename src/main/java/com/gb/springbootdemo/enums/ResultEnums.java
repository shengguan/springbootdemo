package com.gb.springbootdemo.enums;

public enum ResultEnums {
    UNKNOWN(-1, "服务器内部错误"),
    SUCCESS(0, "成功"),
    PRIMARYSCHOOL(100, "我猜你在上小学"),
    HIGHSCHOOL(101, "我猜你在上中学");


    ResultEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
