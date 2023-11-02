package com.qiong.conf;

import lombok.Data;

@Data
public class R {
    private int code;
    private Object data;

    public R (int code, Object data) {
        this.code = code; this.data = data;
    }
    public static R init(int code, Object data) {
        return new R(code, data);
    }
}
