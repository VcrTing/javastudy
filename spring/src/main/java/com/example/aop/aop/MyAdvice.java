package com.example.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {

    // 定義 誰
    // @Pointcut("execution(void org.example.aop.exam.UserDao.save())")
    @Pointcut("execution(* com.example.aop.exam.UserDao.*(..))")
    // @Pointcut("execution(* org.example.aop.exam.UserDao.save(*))")
    private void pi() { }
    // 你這裡 UserDao 是實現類，儘量給接口做 aop，接口有利於降低耦合

    // 建立依賴，在 pi 執行之前 執行 這個 iog 方法
    /*
    @Before("pi()")
    public void iog() {
        System.out.println("系統時間 = " + System.currentTimeMillis());
    }
     */

    @Around("pi()")
    public Object arround(ProceedingJoinPoint pjp) throws Throwable {
        Long star = System.currentTimeMillis();
        System.out.println("BEFORE");
        // 對原始操作的調用
        Object res = pjp.proceed();
        System.out.println("proceed 返回值 = " + res + " 這個值要返回出去給別人用");
        //
        System.out.println("AFTER");
        Long end = System.currentTimeMillis();
        return res;
    }
}
