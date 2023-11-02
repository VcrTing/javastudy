package com.qiong.mod;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    @TableField(select = false)
    private String password;
    private String nickname;
    @NotNull()
    private String email;
    @TableField("creat_at")
    private String creatAt;
    private Integer roieId;

    @TableField(exist = false)
    private Roie roie;
}
