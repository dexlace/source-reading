package com.dexlace.annotation.case1;


import java.lang.annotation.*;

/**
 * 水果颜色注解
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
    /**
     * 颜色枚举
     * @author peida
     *
     */
     enum Color{ BULE,RED,GREEN};

    /**
     * 颜色属性
     * @return
     */
    Color fruitColor() default Color.GREEN;

}