package com.conf;

import java.lang.annotation.*;

@Target(value = { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface QLogForClass {
    public String value() default "";
    public String msg() default "默认的打印值";
}
