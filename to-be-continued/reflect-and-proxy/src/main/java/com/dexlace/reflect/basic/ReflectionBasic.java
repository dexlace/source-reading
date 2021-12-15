package com.dexlace.reflect.basic;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReflectionBasic implements Serializable {
    private static final long serialVersionUID = -2862585049955236662L;
    public static void main(String[] args) throws Exception{

        ReflectionBasic reflectionBasic = new ReflectionBasic();
        // 1. 获取类的全路径类名
        System.out.println(reflectionBasic.getClass().getName());
        // 2. 实例化java Class对象
        // 2.1 一般使用这种
        Class aClass = Class.forName("com.dexlace.reflect.basic.ReflectionBasic");
        Class bClass = new ReflectionBasic().getClass();
        Class cClass = ReflectionBasic.class;
        System.out.println(aClass.getName());
        System.out.println(bClass.getName());
        System.out.println(cClass.getName());

        // 2.2 获取父类及该类实现的的接口
        Class<? super ReflectionBasic> superclass = ReflectionBasic.class.getSuperclass();
        System.out.println(superclass.getName());
        Class<?>[] classes = ReflectionBasic.class.getInterfaces();
        for(Class clazz:classes){
            System.out.println(clazz.getName());
        }

        


    }
}
