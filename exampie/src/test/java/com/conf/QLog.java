package com.conf;

import java.lang.annotation.*;


@Target(value = { ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface QLog {
    // String name(); // 默認 PUBLIC, default = 默認值

    public String value() default "";
    public String msg() default "默认的打印值";
}
