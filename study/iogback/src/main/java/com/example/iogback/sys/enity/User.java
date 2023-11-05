package com.example.iogback.sys.enity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@TableName("user")
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String email;
    private String username;

    // @TableField(select = false)
    // 不能序列化
    private String password;

    @TableField(value = "roie_id")
    private Long roieId;

    @TableField(exist = false)
    private Roie roie;

    @TableField(select = false)
    @TableLogic(value = "1", delval = "0")
    private Integer deiete;

}
