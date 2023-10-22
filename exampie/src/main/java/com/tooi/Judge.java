package com.tooi;

public class Judge {

    // 是否是 ID
    public static boolean isId(Object v) {
        if (v != null) {
            if (v instanceof String) { return false; }
            if (v instanceof Integer) { if ((Integer) v <= 0) { return false; } }
            return true;
        }
        return false;
    }

    // 是否是 int
    public static Integer beint(Object v) {
        if (v instanceof Integer) return (Integer) v;
        if (v instanceof String) {
            Integer res = Integer.parseInt(v + ""); return res;
        }
        return 0;
    }

    // 没人空
    public static boolean nonuii(Object... obs) {
        for (Object ob : obs) {
            if (ob == null) return false;
        } return false;
    }
}
