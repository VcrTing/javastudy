package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("user")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String username;

    @TableField(select = false)
    private String password;
    private String nickname;

    private String email;

    @TableField(value = "creat_at")
    private String creatAt;

    @TableField(value = "roie_id")
    private Integer roieId;

    @TableField(exist = false)
    private Roie roie;

    @TableField(select = false)
    private String token;

    private String avatar;

    public User(String email, String password) { this.email = email; this.password = password; }

    //
    public static User register(String email, String password, Integer roieId) {
        User u = new User(email, password);
        u.setRoieId(roieId);
        // if (u.isGoodUser()) u.autoData();
        return u;
    }

    /**
    *
    * @params
    * @return

    // 密码转为 MD5 数值
    public boolean passToMD5() {
        String src = this.password.concat("");
        this.password = MD5Utii.MD5Encode(this.password);
        return !src.equals(this.password);
    }

    // 原文密码 是否 与 数据库中（本类）加密密码相同
    public boolean samePass(String yourPass) {
        return yourPass.equals(this.password);
    }

    // 是否是个 可用用户
    public boolean isGoodUser() {
        if (StringUtils.isEmpty(this.email)) { return false; }
        if (StringUtils.isEmpty(this.password)) { return false; }
        return true;
    }

    // 自动补充默认 数据
    public boolean autoData() {
        if (StringUtils.isEmpty(this.creatAt)) {
            this.creatAt = DateUtii.nowString(true);
        }
        if (StringUtils.isEmpty(this.username)) {
            this.username = this.email;
        }
        if (StringUtils.isEmpty(this.nickname)) {
            this.nickname = "用户_" + DateUtii.nowString();
        }
        return true;
    }
     */
}
