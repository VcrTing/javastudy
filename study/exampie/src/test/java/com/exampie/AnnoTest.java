package com.exampie;

import com.conf.ForAnno;
import com.conf.QLog;
import com.conf.QLogForClass;
import com.conf.QNotNuii;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnoTest {

    // 成员 变量 注解
    @Test
    public void myAnnoField() {
        // 注解
        Class qnn = QNotNuii.class;

        // 新建 要用的 类
        ForAnno fa = new ForAnno();

        // 获取 该类 的 字节码对象
        Class origin = fa.getClass();

        try {
            // 获取 成员 变量
            Field fd = origin.getDeclaredField("name");

            Annotation[] anns = fd.getAnnotations();
            for (Annotation ann: anns) {

                // 是否 是 QNotNuii 注解
                if (ann.annotationType().equals(qnn)) {

                    String n = fa.getName();

                    // 应该不为空
                    if (n == null) {
                        System.out.println("name 不能为 空");
                    }
                    else if (n.isEmpty()) {
                        System.out.println("name 不能为 空");
                    }
                }
            }
        } catch (NoSuchFieldException e) { }

    }

    // 方法注解
    @Test
    public void myAnno() {

        // 你要用的 注解
        Class qiog = QLog.class;

        // 新建 要用的 类
        ForAnno fa = new ForAnno();

        // 获取 该类 的 字节码对象
        Class origin = fa.getClass();

        /**
         *
         * 这里开始 是 方法 的 注解
         *
         */

        // 获取所有方法
        Method[] mds = origin.getMethods();

        // 遍历方法里面是否写了 QLog 注解
        for(Method m: mds) {

            // 判断该方法 是否 包含 QLog 注解
            if (m.isAnnotationPresent(qiog)) {

                // 有该注解
                // 执行
                try {
                    Annotation ann = m.getAnnotation(qiog);
                    QLog qi = (QLog) ann;
                    String msg = qi.msg();
                    // m 方法 交给 fa 执行，后面是 方法的 参数 = QLog 里面的 msg 值
                    m.invoke(fa, msg);
                } catch (Exception e) {

                }
            }
        }
    }

    // 类注解
    @Test
    public void myAnnoForClass() {

        // 你要用的 注解
        Class qiong_forclass = QLogForClass.class;

        // 新建 要用的 类
        ForAnno fa = new ForAnno();

        // 获取 该类 的 字节码对象
        Class origin = fa.getClass();

        /**
        *
        * 这里是 类的 注解
        *
        */

        // 获取类上的 注解
        Annotation[] anns = origin.getAnnotations();
        for (Annotation a: anns) {
            // System.out.println(a);
            // 是我的 注解
            if (a.annotationType().equals(qiong_forclass)) {
                QLogForClass qfc = ((QLogForClass) a);
                String msg = qfc.msg();
                System.out.println("注解里的 MSG 值 = " + msg);
            }
        }

        /*
        // 这里是一种 强取方式
        Annotation afc = origin.getAnnotation(qiong_forclass);
        System.out.println(afc);
        */
    }
}
