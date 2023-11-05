package com.mypiugin.myibs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QPager {
    private Integer page;
    private Integer size;

    static Integer DEF_SIZE = 10;
    public static QPager initPager(Integer _size) {
        return new QPager(1, _size == null ? DEF_SIZE : _size);
    }

    public QPager nextPager(Integer _page) {
        page = (_page != null && _page > 0) ? _page : page;
        page += 1;
        return this;
    }
}
