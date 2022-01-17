package com.dexlace.annotation.case6.annotation;

import com.dexlace.annotation.case6.validator.FirstConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
// 需要实现ConstraintValidator类来实现initialize方法和isValid判断方法
@Constraint(validatedBy = FirstConstraintValidator.class)
public @interface FirstConstraint {

    String message() default "参数校验不通过，请重新输入";;

    long minLength();

    long maxLength();


    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}