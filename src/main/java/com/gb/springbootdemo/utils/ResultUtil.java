package com.gb.springbootdemo.utils;

import com.gb.springbootdemo.bean.Result;

public class ResultUtil {

    public static Result success(String message, Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg(message);
        result.setData(object);
        return result;
    }

    public static Result success(String message) {
        return success(message, null);
    }

    public static Result error(Integer code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(message);
        return result;
    }


}
