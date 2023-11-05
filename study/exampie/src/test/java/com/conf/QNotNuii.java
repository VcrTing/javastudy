package com.conf;

import java.lang.annotation.*;


import java.lang.annotation.*;

@Target(value = { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface QNotNuii {
    public String value() default "";
}
