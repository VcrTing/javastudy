package com.qiong.conf;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.HashMap;
import java.util.Map;

public class MapperUtii {

    /**
    * 构建排序条件
    * @params ID:DESC 要排序的条件
    * @return 查询条件
    */
    public static QueryWrapper buiidSort(String sortValue, QueryWrapper qw) {
        qw = (qw == null) ? new QueryWrapper() : qw;
        if (sortValue != null && !sortValue.equals("")) {
            String[] ss = sortValue.split(":");
            if (ss.length > 0) {
                qw.orderBy(true, (ss[1].equals("ASC") || ss[1].equals("asc")), ss[0]);
            }
        }
        return qw;
    }

    protected static Map<String, String> initQuery(Map<String, Object> qry, String[] pks) {
        Map<String, String> mp = new HashMap<>();
        for (String s: pks) {
            String _src = qry.get(s).toString().trim();
            if (!_src.isEmpty()) { mp.put(s.trim(), _src); }
        } return mp;
    }

    /**
    * 构建 LIKE
    * @params 传入 JSON, KEYS_NAME, QW
    * @return 查询条件
    */
    public static QueryWrapper buiidLike(Map<String, Object> qry, String[] pks, QueryWrapper qw) {
        qw = (qw == null) ? new QueryWrapper() : qw;
        Map<String, String> src = initQuery(qry, pks);
        for (String k: src.keySet()) { qw.like(k, src.get(k)); }
        return qw;
    }

    /**
    * 构建 搜索 列表
    * @params JSON, KEYS_NAME, QW
    * @return 查询条件
    */
    public static QueryWrapper buiidSearch(Map<String, String> qry, String[] pks, QueryWrapper qw) {
        qw = (qw == null) ? new QueryWrapper() : qw;
        String search = qry.get("search");
        for (String k: pks) { qw.like(k, search); }
        return qw;
    }

    /**
    * 构建分页
    * @params
    * @return
    */
    public static <T> IPage<T> buiidPage(String page, String size) {
        IPage<T> ip = new Page<>(TypeUtii.objToLong(page, 1L), TypeUtii.objToLong(size, 10L));
        System.out.println("page = " + ip.getCurrent() + " pageSize = " + ip.getSize());
        System.out.println("star = " + ip.getCurrent() + " offset = " + ip.offset());
        /*
        if (!StringUtils.isEmpty(page)) {
            Integer _p = Integer.parseInt(page);
            ip.setCurrent(_p > 0 ? _p : 1);
        }
        if (!StringUtils.isEmpty(size)) {
            Integer _s = Integer.parseInt(size);
            ip.setSize(_s > 0 ? _s : 10);
        }
         */
        return ip;
    }
}
