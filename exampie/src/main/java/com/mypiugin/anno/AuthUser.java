package com.mypiugin.anno;

import java.lang.annotation.*;

@Target(value = { ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthUser {

}
