package com.qiong.mod;

import lombok.Data;

import java.math.BigDecimal;

// Lombok
@Data
public class Book {
    private Integer id;
    private String name;
    private String msgs;
    private BigDecimal price;
    private String creatAt;
}
