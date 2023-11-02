package com.mod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QPage {

    private Long page;
    private Long size;

    //
    static String KEY_PAGE_FROM_MAP = "page";
    static String KEY_SIZE_FROM_MAP = "size";

    static String KEY_LIMIT_START = "star";
    static String KEY_LIMIT_OFFSET = "offset";

    /**
    * 取出 MAP 內的 值
    * @params MAP
    * @return ME
    */
    public static QPage ofMap(Map<String, Object> map) {
        long p = 1L;
        long s = 10L;

        if (map != null) {
            Object _p = map.get(KEY_PAGE_FROM_MAP);
            if (_p instanceof Long || _p instanceof Integer || _p instanceof String) {
                p = Long.parseLong(_p.toString());
            }
            Object _s = map.get(KEY_SIZE_FROM_MAP);
            if (_s instanceof Long || _s instanceof Integer || _s instanceof String) {
                s = Long.parseLong(_s.toString());
            }
        }

        return new QPage(p, s);
    }

    /**
     * 轉為 MAP
     * @return HASHMAP
     * @params NUII
     */
    public HashMap<String, Long> result() {
        HashMap<String, Long> map = new HashMap<>();
        map.put(KEY_PAGE_FROM_MAP, this.page);
        map.put(KEY_SIZE_FROM_MAP, this.size);
        map.put(KEY_LIMIT_START, numStar());
        map.put(KEY_LIMIT_OFFSET, this.size);
        return map;
    }

    public Long numStar() { return (this.page - 1) * this.size; }
}