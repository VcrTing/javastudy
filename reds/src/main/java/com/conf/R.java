package com.conf;

import lombok.Data;

public class R {
    private HTTP_CODE code;
    private Object data;

    public R() {
    }

    public static R init(HTTP_CODE code, Object data) {
        return new R(code, data);
    }

    public R(HTTP_CODE code, Object data) {
        this.code = code;
        this.data = data;
    }

    /**
     * 获取
     * @return code
     */
    public HTTP_CODE getCode() {
        return code;
    }

    /**
     * 设置
     * @param code
     */
    public void setCode(HTTP_CODE code) {
        this.code = code;
    }

    /**
     * 获取
     * @return data
     */
    public Object getData() {
        return data;
    }

    /**
     * 设置
     * @param data
     */
    public void setData(Object data) {
        this.data = data;
    }

    public String toString() {
        return "R{code = " + code + ", data = " + data + "}";
    }
}
