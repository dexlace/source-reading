package com.dexlace.annotation.case3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  SQLInteger 和 SQLString一样，都是要求在javabean上，根据不同的数据类型使用不同的注解

 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLInteger {
    String name() default "";
    //注解嵌套
    Constrains constrains() default @Constrains;
}

