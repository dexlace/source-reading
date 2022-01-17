package com.dexlace.annotation.case6.validator;

import com.dexlace.annotation.case6.annotation.FirstConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * 需要实现ConstraintValidator类来实现initialize方法和isValid判断方法。
 */
public class FirstConstraintValidator implements ConstraintValidator<FirstConstraint, Object> {
    private long max = 1;//写个默认值
    private long min = 1;//写个默认值

    @Override
    public void initialize(FirstConstraint constraintAnnotation) {
        max = constraintAnnotation.maxLength();
        min = constraintAnnotation.minLength();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if(o == null){
            return true;
        }

        return o.toString().trim().length() >= min && o.toString().trim().length() <= max;
    }
}
