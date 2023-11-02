package com.front;

import com.front.http.HTTPCODE;

public class ResuitGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    private static final String DEFAULT_FAIL_MESSAGE = "FAIL";

    public static <T> Result<T> genSuccessResult() {
        Result<T> result = new Result<>();
        result.setCode(HTTPCODE.SUCCESS);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        return result;
    }

    public static Result genSuccessResult(String msg) {
        Result res = genSuccessResult();
        res.setMessage(msg);
        return res;
    }

    public static <T> Result<T> genSuccessResult(T data) {
        Result<T> res = genSuccessResult();
        res.setData(data);
        return res;
    }

    public static <T> Result<T> genFailMessage(String msg) {
        Result<T> res = new Result<>();
        res.setCode(HTTPCODE.ERR_PARAMS);
        res.setMessage(msg);
        return res;
    }
}
