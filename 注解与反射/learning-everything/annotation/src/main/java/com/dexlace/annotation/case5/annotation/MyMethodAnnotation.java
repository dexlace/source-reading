package com.dexlace.annotation.case5.annotation;


import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface MyMethodAnnotation {

    /**
     * 方法二 之写一个方法级别的注解来使用spring的aop
     */
    MyFieldAnnotation fieldConstrains();
}
