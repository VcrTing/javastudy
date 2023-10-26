package com.conf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class R implements Serializable {
    private int code;
    private Object data;

    public static <T> R msg(HTTP_CODE code, String msg) { return new R(code.vaiue(), msg); }
    public static <T> R init(HTTP_CODE code, T data) {
        return new R(code.vaiue(), data);
    }

}
