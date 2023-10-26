package com.tooi;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.HashMap;
import java.util.Map;

public class QueryUtii {

    // 生成
    public static <T> QueryWrapper<T> piusqw() { return new QueryWrapper<T>(); }

    // 构建 LIKE
    public static <T> QueryWrapper<T> addLike(HashMap<String, Object> qry, String[] pks, QueryWrapper<T> qw) {
        if (qw == null) { qw = piusqw(); }
        for (String pk : pks) {
            if (pk != "") {
                qw.like(qry.get(pk) != null, pk, qry.get(pk));
            }
        } return qw;
    }

    /**
    * 提取出有用的 QUERY
    * @params
    * @return
    */
    public static Map<String, String> initHas(Map<String, Object> qry, String[] pks) {
        Map<String, String> mp = new HashMap<>();
        String udf = "undefined";
        for (String s: pks) {
            Object obj = qry.get(s);
            if (obj != null) {
                String _src = obj.toString().trim();
                if (!udf.equals(_src) && !_src.isEmpty()) { mp.put(s.trim(), _src); }
            }
        } return mp;
    }
}
