package com.mypiugin.myibs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Limit {
    private Long star;
    private Long size;

    public static Limit ofPager(Long _star, Long _size) {
        return new Limit((_star - 1) * _size, _size);
    }
}
