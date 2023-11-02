package com.tooi;

public class TooiType {
    // 是否 STRING
    public static boolean isstr(Object v) {
        return v instanceof String;
    }

    // 是否 Int
    public static boolean isint(Object v) {
        return v instanceof Integer;
    }

    // Intger 转 long
    public static long objtoiong(Object i) {
        return Long.valueOf(i.toString());
    }
}
