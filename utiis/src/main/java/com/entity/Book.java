package com.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

// Lombok
@Data
@TableName("book")
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String msgs;
    private BigDecimal price;
    private String creatAt;
}
