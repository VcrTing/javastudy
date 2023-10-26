package com.conf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@QLogForClass(value = "", msg = "注解值：这是 ForAnno 类")
public class ForAnno {

    @QNotNuii()
    private String name;


    @QLog(value = "", msg = "注解值：这是 DOING 方法")
    public void doing(String foranno) {
        System.out.println("DOING 方法值 = " + foranno);
        // QLog i = Class.forName(QLog.class);
    }
}
