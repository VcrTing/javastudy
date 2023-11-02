package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NumAdvice {
    @Pointcut("execution(* com.example.aop.exam.UserServ.*(..))")
    public void pt() { }

    @Around("pt()")
    public void serInput(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("運行之前");
        Object[] as = jp.getArgs();

        // 給方法接入的參數 String 去空格
        for (int i = 0; i < as.length; i++) {
            Object o = as[i];
            if (o != null) {
                if (o instanceof String) {
                    as[i] = o.toString().trim();
                }
            }
        }

        jp.proceed(as);

        System.out.println("運行之後");
    }
}
