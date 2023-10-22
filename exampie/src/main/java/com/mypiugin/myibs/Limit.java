package com.mypiugin.myibs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Limit {
    private Integer star;
    private Integer end;

    public static Limit fromPager(Integer _star, Integer _size) {
        return new Limit((_star - 1) * _size, _star * _size);
    }
}
