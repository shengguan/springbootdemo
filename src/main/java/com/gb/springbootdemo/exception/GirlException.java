package com.gb.springbootdemo.exception;

import com.gb.springbootdemo.enums.ResultEnums;

/**
 *  spring只会抛出RunTimeException  所以需要继承RunTimeException
 */
public class GirlException extends RuntimeException {

    private  Integer code;

    public GirlException(ResultEnums resultEnums){
        super(resultEnums.getMsg());
        this.code = resultEnums.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
