package com.dexlace.annotation.case5.annotation;


import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface MyFieldAnnotation {
    String name() default "zhangsan";

    int number() default 20;
}
