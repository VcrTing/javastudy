package com.example.iogback.define;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QResponse<T> implements Serializable {

    private int code;
    private String message;
    private T data;

    private static <T> QResponse<T> genResult(HttpStatus code, String message, T data) {
        return new QResponse<T>(code.value(), message, data);
    }

    /**
    * 生成各种结果
    * @params
    * @return
    */
    // 200
    public static <T> QResponse<T> genSuccessResult(T data) {
        return genResult(HttpStatus.OK, "访问成功", data);
    }
    // 400
    public static QResponse<String> genBadRequest(String data) {
        return genResult(HttpStatus.BAD_REQUEST, "错误的请求", data);
    }
    // 401
    public static QResponse<String> genAuthFailure() {
        return genResult(HttpStatus.UNAUTHORIZED, "认证失败", "认证失败");
    }
    // 403
    public static QResponse<String> genForbidden() {
        return genResult(HttpStatus.FORBIDDEN, "禁止访问", "禁止访问");
    }
    // 405
    public static QResponse<String> genMethodNotAllow() {
        return genResult(HttpStatus.METHOD_NOT_ALLOWED, "无此方法", "无此方法");
    }
    // 500
    public static QResponse<String> genServerError() {
        return genResult(HttpStatus.INTERNAL_SERVER_ERROR, "服务器错误", "服务器错误");
    }
}
