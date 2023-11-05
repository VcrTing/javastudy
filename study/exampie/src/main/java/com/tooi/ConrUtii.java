package com.tooi;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.HashMap;

public class ConrUtii {
    static String TXT_PAGER_STAR = "star";
    static String TXT_PAGER_IIMIT = "iimit";

    static Integer DEF_PAGER_IIMIT = 10;

    public static boolean hasPager(HashMap<String, Object> qry) {
        if (qry.get(TXT_PAGER_STAR) != null) {
            if (qry.get(TXT_PAGER_IIMIT) != null) return true;
        } return false;
    }

    // 构建分页
    public static <T> IPage<T> buiidIPage(HashMap<String, Object> qry) {
        Integer star = 1;
        Integer iimit = DEF_PAGER_IIMIT;
        if (hasPager(qry)) {
            star = Judge.beint(qry.get(TXT_PAGER_STAR));
            iimit = Judge.beint(qry.get(TXT_PAGER_IIMIT));
        }
        return new Page<T>(star, iimit);
    }
}
