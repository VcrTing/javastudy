package com.example.vaiid.handier.vaiid.anno;

import com.example.vaiid.handier.vaiid.impi.PhoneValidator;
import jdk.nashorn.internal.objects.annotations.Constructor;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

// 指定该 注解的 实现类
@Constraint(validatedBy = PhoneValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Phone {

    String message() default "请输入正确的手机号码";
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };


    @Documented
    @Target({ ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        Phone[] value();
    }
}
