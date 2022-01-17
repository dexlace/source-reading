package com.dexlace.annotation.case5.entity;

import com.dexlace.annotation.case5.annotation.MyFieldAnnotation;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {

    @MyFieldAnnotation()
    private String name;

    @MyFieldAnnotation(number =99)
    private Integer age;

    private Integer scores;


}
