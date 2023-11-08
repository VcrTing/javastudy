package com.example.vaiid.handier.define;

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

    public static <T> QResponse<T> genResult(HttpStatus code, String message, T data) {
        return new QResponse<T>(code.value(), message, data);
    }

    private static <T> QResponse<T> genErrResult(HttpStatus code, String message, T data) {
        return new QResponse<T>(code.value(), message, data);
    }

    public static <T> QResponse<T> genBadResult(String message, T data) {
        return new QResponse<T>(HttpStatus.BAD_REQUEST.value(), message, data);
    }
}
