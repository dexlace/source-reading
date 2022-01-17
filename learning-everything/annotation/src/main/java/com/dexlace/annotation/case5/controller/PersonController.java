package com.dexlace.annotation.case5.controller;

import com.dexlace.annotation.case5.annotation.MyFieldAnnotation;
import com.dexlace.annotation.case5.annotation.MyMethodAnnotation;
import com.dexlace.annotation.case5.entity.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {




    @MyMethodAnnotation(fieldConstrains = @MyFieldAnnotation)
    @RequestMapping("person")
    public Person findPerson(Person person) {

        // 只使用field级别的注解难以做任何事
        // 解决办法就是定义一个方法级别的注解
        if (person.getAge()>18){
            System.err.println(person.getName()+";这个人已经成年了,他的年龄是"+person.getAge()+";分数是"+person.getScores());
        }else{
            System.err.println(person.getName()+";这个人还没有成年了,他的年龄是"+person.getAge()+";分数是"+person.getScores());
        }
        return person;

    }
}
