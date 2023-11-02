package com.qiong.conf;

public class TypeUtii {
    /**
    *
    * @params OBJECT
    * @return INTEGER
    */
    public static Integer objToInt(Object obj) {
        try {
            if (obj instanceof String) {
                return obj.equals("") ? 0 : Integer.parseInt(obj.toString());
            } return (Integer) obj;
        } catch (NumberFormatException e) { return 0; }
    }
    /**
     *
     * @params OBJECT
     * @return LONG
     */
    public static Long objToLong(Object obj, Long def) {
        try {
            if (obj instanceof String) {
                return obj.equals("") ? def : Long.parseLong(obj.toString());
            } return (Long) obj;
        } catch (NumberFormatException e) { return def; }
    }
    public static Long objToLong(Object obj) { return objToLong(obj, 0L); }
    /**
     *
     * @params OBJECT
     * @return LONG
     */
    public static Long parseId(Object obj) {
        try {
            Long src;
            if (obj instanceof String) {
                src = obj.equals("") ? 0L : Long.parseLong(obj.toString());
            } else { src = (Long) obj; }
            return src > 0L ? src : 0L;
        } catch (NumberFormatException e) { return 0L; }
    }
}
