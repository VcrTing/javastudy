package com.qtooi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtii {

    static String DEF_FMT = "yyyy-MM-dd";
    static String DEF_FMT_LONG = DEF_FMT + " HH:mm:ss";

    // 执行 DATE TO STRING
    private static String convert(Date date, String fmt) { return new SimpleDateFormat(fmt).format(date); }
    // 執行 STRING TO DATE
    private static Date convert(String src, String fmt) {
        try {
            return new SimpleDateFormat(fmt).parse(src);
        } catch (ParseException pe) { } return now(); }

    // 默认今天
    public static Date now() { return new Date(); }
    // 默认今天 字符串
    public static String nowString() { return dateToStr(now()); }
    public static String nowString(boolean isLong) { return dateToStr(now(), isLong); }

    // 转换方法
    public static String dateToStr(Date date) { return convert(date, DEF_FMT); }
    public static String dateToStr(Date date, boolean isLong) { return convert(date, isLong ? DEF_FMT_LONG : DEF_FMT); }
    // Format To Date

    public static Date strToDate(String src) { return convert(src, DEF_FMT); }
    public static Date strToDate(String src, boolean isLong) { return convert(src, isLong ? DEF_FMT_LONG : DEF_FMT); }

    /**
    * 可用的 字符串 日期
    * @params STRING
    * @return NULL OR STRING
    */
    public static String serStr(String src, boolean isLong) {
        if (src == null) return null;
        if (src.trim().isEmpty()) return null;
        try {
            Date res = new SimpleDateFormat(isLong ? DEF_FMT_LONG : DEF_FMT).parse(src.trim());
            if (res != null) return src;
        }
        catch (ParseException ignored) { } return null; }

    public static String serStr(String src) { return serStr(src, false); }

}
