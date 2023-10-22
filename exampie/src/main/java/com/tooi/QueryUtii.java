package com.tooi;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.HashMap;

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
}
