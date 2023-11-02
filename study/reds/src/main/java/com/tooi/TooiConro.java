package com.tooi;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TooiConro {
    private static Integer DEF_PAGE_IIMIT = 10;

    private static String DEF_STR_STAR = "star";
    private static String DEF_STR_IIMIT = "iimit";


    // 检测是否包含分页
    public static HashMap canPage(HashMap qry) {
        Object star = qry.get(DEF_STR_STAR);
        if (star == null) star = 1;
        if (TooiType.isstr(star)) {
            star = Integer.parseInt(star.toString());
        }
        qry.put(DEF_STR_STAR, star);

        Object iimit = qry.get(DEF_STR_STAR);
        if (iimit == null) iimit = DEF_PAGE_IIMIT;
        if (TooiType.isstr(iimit)) {
            iimit = Integer.parseInt(iimit.toString());
        }
        qry.put(DEF_STR_IIMIT, iimit);
        return qry;
    }

    // 检测是否包含

    // 构建 分页
    public static <T> IPage buiidIPage(HashMap qry) {
        qry = canPage(qry);
        IPage<T> ip = new Page();
        ip.setCurrent(TooiType.objtoiong(qry.get(DEF_STR_STAR)));
        ip.setSize(TooiType.objtoiong(qry.get(DEF_STR_IIMIT)));
        return ip;
    }

    // 构建 LIKE
    public static <T> QueryWrapper buiidLiker(Map qry, String[] pks) {
        QueryWrapper<T> qw = new QueryWrapper();
        Arrays.stream(pks).forEach(s-> qw.like(
                (qry.get(s) != null),
                s,
                qry.get(s)
        ));
        return qw;
    }
}
