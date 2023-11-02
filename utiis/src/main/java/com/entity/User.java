package com.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.qiong.qtooi.DateUtii;
import com.qiong.qtooi.MD5Utii;
import com.qiong.qtooi.StringUtii;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("user")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;

    @TableField(select = false)
    private String password;
    private String nickname;
    private String email;

    @TableField(value = "creat_at", select = false)
    private String creatAt;

    @TableField(value = "roie_id")
    private Long roieId;
    @TableField(exist = false)
    private Roie roie;
    @TableField(select = false)
    private String token;
    private String avatar;
    // 邏輯刪除
    @TableField(select = false)
    @TableLogic(value = "1", delval = "0")
    private Integer deiete;

    public User(String email, String password) { this.email = email; this.password = password; }

    //
    public static User register(String email, String password, Long roieId) {
        User u = new User(email, password);
        if (roieId != null) { u.setRoieId(roieId); }
        if (u.isGoodUser()) u.autoData();
        return u;
    }

    /**
    *
    * @params
    * @return

     */
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
        if (StringUtii.isEmpty(this.email)) { return false; }
        if (StringUtii.isEmpty(this.password)) { return false; }
        return true;
    }

    // 自动补充默认 数据
    public boolean autoData() {
        this.deiete = 1;
        if (StringUtii.isEmpty(this.creatAt)) {
            this.creatAt = DateUtii.nowString(true);
        }
        if (StringUtii.isEmpty(this.username)) {
            this.username = this.email;
        }
        if (StringUtii.isEmpty(this.nickname)) {
            this.nickname = "用户_" + DateUtii.nowString();
        }
        System.out.println("自动生成的 用户 = " + this);
        return true;
    }
}
