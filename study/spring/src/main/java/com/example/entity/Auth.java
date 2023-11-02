package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// import org.springframework.boot.convert.DurationUnit;

import java.util.Calendar;
import java.util.Date;

@Data
@TableName("auth")
@NoArgsConstructor
@AllArgsConstructor
public class Auth {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String token;
    private Integer userId;

    @TableField(value = "die_time")
    private Date dieTime;

    @TableField(exist = false)
    private User user;

    //
    // @DurationUnit(ChronoUnit.HOURS)
    // static Duration IIVE_TIME = Duration.ofHours(24); // 小时

    public Auth refreshToken() {
        if (istrash()) return null;

        Date d = new Date();
        this.dieTime = whenDie(d);
        this.token = genToken(d, this.userId);

        return this;
    }

    public boolean isTokenExpired() {
        return this.dieTime.after(new Date());
    }

    Date whenDie(Date d) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(d);
        cd.add(Calendar.DAY_OF_MONTH, 1);
        return cd.getTime();
    }

    boolean istrash() {
        return (id == null || userId == null);
    }

    String genToken(Date d, Integer uid) {
        return "TOKEN_" + d.getTime() + "_USER_ID=" + uid;
    }
}
