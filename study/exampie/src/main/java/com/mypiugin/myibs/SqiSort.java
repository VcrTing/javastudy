package com.mypiugin.myibs;

import com.conf.SQL_SORT;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SqiSort {
    private String k;
    private SQL_SORT way;

    public static SqiSort def() {
        return new SqiSort("id", SQL_SORT.DESC);
    }
}
