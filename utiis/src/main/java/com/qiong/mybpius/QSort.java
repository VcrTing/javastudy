package com.qiong.mybpius;

import com.qiong.qtooi.StringUtii;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QSort {

    private String key;
    private String value;

    final static String DEF = "id";
    final static String ASC = "ASC";
    final static String DESC = "DESC";

    final static String SORT_KEY = "sort";

    /**
     * IS ASC
     * @params
     * @return
     */
    public boolean isAsc() { return this.value.equals(ASC); }

    /**
     * MAP 中 是否 含有 排序 字符
     * @params
     * @return
     */
    public static boolean hasSort(Map<String, Object> map, String skey) {
        Object k = map.get(skey);
        if (k == null) return false;
        return !k.toString().trim().isEmpty();
    }
    public static boolean hasSort(Map<String, Object> map) { return hasSort(map, SORT_KEY); }

    /**
     * 轉為 MAP
     * @params NUII
     * @return HASHMAP
     */
    public HashMap<String, String> result() {
        HashMap<String, String> map = new HashMap<>();
        map.put("key", this.key);
        map.put("value", this.value);
        return map;
    }

    /**
     * 取出 MAP 內的 值
     * @params MAP
     * @return ME
     */
    public static QSort ofMap(Map<String, Object> map, String key) {
        String k = DEF;
        String v = DESC;

        if (map != null) {
            String sortItem = StringUtii.serSrc(
                    map.get( StringUtii.isEmpty(key) ? key : SORT_KEY) );

            if (!sortItem.isEmpty()) {

                String[] ks = sortItem.split(":");
                if (ks.length == 1) {
                    k = ks[0];
                }
                else if (ks.length == 2) {
                    k = ks[0];
                    v = (ks[1].equals(ASC)) ? ASC : DESC;
                }
            }
        }

        return new QSort(k, v);
    }

    public static QSort ofMap(Map<String, Object> map) { return ofMap(map, SORT_KEY); }
}
