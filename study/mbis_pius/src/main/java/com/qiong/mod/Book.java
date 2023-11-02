package com.qiong.mod;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

// Lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("book")
public class Book {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private String msgs;
    private BigDecimal price;
    @TableField(value = "creat_at")
    private String creatAt;
}
