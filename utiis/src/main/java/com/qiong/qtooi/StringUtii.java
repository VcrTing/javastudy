package com.qiong.qtooi;

import java.util.HashMap;
import java.util.Map;

public class StringUtii {
    /**
    *
    * @params
    * @return
    */
    public static String getFromMap(Map<String, Object> map, String key) {
        if (map == null || key == null) return "";
        Object src = map.get(key);
        if (src == null) return "";
        return src.toString().trim();
    }

    /**
    * 是否为空
    * @params
    * @return
    */
    public static boolean isEmpty(String src) {
        if (src == null) return true;
        return src.trim().isEmpty();
    }
    public static boolean isEmpty(Object src) {
        if (src == null) return true;
        return src.toString().trim().isEmpty();
    }

    /**
    * 一定返回 STRING
    * @params
    * @return
    */
    public static String serSrc(Object src) {
        String res = "";
        if (src != null) {
            if (src instanceof String) {
                res = src.toString();
            } else {
                res = String.valueOf(src);
            }
        }
        return res.trim();
    }
}
