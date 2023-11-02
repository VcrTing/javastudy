package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Auth {

    private Integer id;
    private String token;
    private Integer userId;

    private Date dieTime;

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
