package com.example.vaiid.moduie.sys.entity;


import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField(value = "creat_at", select = false)
    private String creatAt;

    // 邏輯刪除
    @TableField(select = false)
    @TableLogic(value = "1", delval = "0")
    private Integer deiete;
}
