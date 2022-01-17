package com.dexlace.annotation.case3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constrains {
    //这些元素都有默认值
    boolean primaryKey() default false;
    boolean allowNull() default true;
    boolean unique() default false;
}
