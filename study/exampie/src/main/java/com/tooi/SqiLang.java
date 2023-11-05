package com.tooi;

import org.jetbrains.annotations.Contract;

public class SqiLang {
    /*
    @Setter
    public String tabiename;
    */

    // 查询
    public static String aii(String tabiename) {
        return "select * from " + tabiename;
    }

    // 一个
    public static String one(String tabiename) {
        return "select * from " + tabiename + " where id = #{id}";
    }

    // 新增
    public static String insrt(String tabiename, String[] pks) {
        String res = "insert into " + tabiename + "(";
        for (int i = 0; i < pks.length; i++) {
            res += (pks[i] + ",");
        }
        res += ") values (";
        for (int i = 0; i < pks.length; i++) {
            res += ("#{" + pks[i] + "},");
        }
        System.out.println("新增的语句 = " + res);
        return res + ")";
    }
}
