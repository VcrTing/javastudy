package com.example.vaiid.utii;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ValidateUtii {
    private static Validator validator;
    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public static <T> List<String> valid(T data) {
        Set<ConstraintViolation<T>> set = validator.validate(data);
        return set.stream().map(s->"属性：" + s.getPropertyPath() + ", 值：" + s.getInvalidValue() + "，校验不通过，因为：" + s.getMessage()).collect(Collectors.toList());
    }
}
