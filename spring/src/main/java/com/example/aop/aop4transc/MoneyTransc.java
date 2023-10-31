package com.example.aop.aop4transc;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Aspect
public class MoneyTransc {

    @Pointcut("execution(* com.example.transac.MoneyServ.*(..))")
    public void pt(){ }

    @Around("pt()")
    public Object checkMoney(ProceedingJoinPoint jp) throws Throwable {


        Object[] as = jp.getArgs();
        // BigDecimal iess = new BigDecimal(0.00);
        for (Object a : as) {
            System.out.println("參數 = " + a);
        }

        System.out.println("檢查環境安全，開始轉帳");
        Object res = jp.proceed();

        return res;
    }
}
