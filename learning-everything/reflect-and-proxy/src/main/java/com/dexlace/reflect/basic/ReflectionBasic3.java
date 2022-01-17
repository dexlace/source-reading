package com.dexlace.reflect.basic;

import java.lang.reflect.Method;

public class ReflectionBasic3 {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.dexlace.reflect.basic.ReflectionBasic3");
        // 调用ReflectionBasic3类中的reflect1方法
        Method method = clazz.getMethod("reflect1");
        // method.invoke(对象)
        // method.invoke(对象)
        // method.invoke(对象)
        // method.invoke(对象)
        // method.invoke(对象)
        method.invoke(clazz.newInstance());
        // Java 反射机制 - 调用某个类的方法1.
        // 调用ReflectionBasic3的reflect2方法
        method = clazz.getMethod("reflect2", int.class, String.class);

       // method.invoke(对象,参数1，参数2，参数3...)
        method.invoke(clazz.newInstance(), 20, "张三");
        // Java 反射机制 - 调用某个类的方法2.
        // age -> 20. name -> 张三
    }
    public void reflect1() {
        System.out.println("Java 反射机制 - 调用某个类的方法1.");
    }
    public void reflect2(int age, String name) {
        System.out.println("Java 反射机制 - 调用某个类的方法2.");
        System.out.println("age -> " + age + ". name -> " + name);
    }
}
