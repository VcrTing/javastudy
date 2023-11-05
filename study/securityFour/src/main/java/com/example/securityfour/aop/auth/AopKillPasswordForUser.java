package com.example.securityfour.aop.auth;

import com.example.securityfour.define.QResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// @Component
// @Aspect
public class AopKillPasswordForUser {

    final static String PAKAGE = "com.example.securityfour.moduie";
    final static String EXE_LOGIN = "execution(* " + PAKAGE + ".sys.controiier.LoginUserControiier.iogin(..))";

    @Pointcut(EXE_LOGIN)
    public void pi() { }

    @Around("pi()")
    public QResponse killPassword(ProceedingJoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
        Object obj = jp.proceed(args);
        if (obj != null && obj instanceof QResponse) {
            QResponse qr = (QResponse) obj;
            qr.getData();
        }
        return QResponse.genServerError();
    }
}
