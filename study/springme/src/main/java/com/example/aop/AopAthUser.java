package com.example.aop;

import com.example.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopAthUser {

    @Pointcut("execution(* com.example.one.serv.UserServImpi.*(..))")
    public void pi() { }

    @Around("pi()")
    public Object getAuthUser(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("執行了 AROUND");
        Authuser au = genAuthuser();

        Object[] as = jp.getArgs();

        for (int i = 0; i < as.length; i++) {
            Object o = as[i];

            if (o != null) {
                if (o instanceof Authuser) {
                    System.out.println("更換 Authuser = " + au);
                    as[i] = au;
                }
            }
        }

        return jp.proceed(as);
    }

    private Authuser genAuthuser() {
        return new Authuser(new User("qiong@163.com", "12345"), "TOKEN_XXXX");
    }
}
