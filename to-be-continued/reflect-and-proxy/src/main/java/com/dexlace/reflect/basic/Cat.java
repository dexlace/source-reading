package com.dexlace.reflect.basic;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

@SuppressWarnings("all")
@Data
@AllArgsConstructor
public class Cat {
    public void eat(){
        System.out.println("喵喵 is eating");
    }

    public static void main(String[] args)
            throws IOException, ClassNotFoundException,
            IllegalAccessException, InstantiationException,
            NoSuchMethodException, InvocationTargetException {

        // 1、读取配置文件
        Properties properties=new Properties();
        properties.load(new FileInputStream("F:\\togithub\\source-reading\\to-be-continued\\reflect-and-proxy\\src\\main\\java\\com\\dexlace\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String method = properties.get("method").toString();
        System.out.println(classfullpath);
        System.out.println(method);

        // 2、拿到全路径类名和方法名 怎么创建对象
        // 传统方法无法解决

        // 3. 反射快速入门
        // 3.1 加载类，返回class类型的对象cls
        Class<?> cls = Class.forName(classfullpath);
        // 3.2 通过cls得到加载的类的对象实例
        Object o = cls.newInstance();
        System.out.println(o.getClass());
        // 3.3 通过cls得到加载的类的 “method”方法 对象
        // 得到加载的方法对象
        Method clsMethod = cls.getMethod(method);
        // 3.4 传入类对象参数，通过clsMethod调用invoke方法来实现方法调用
        // 方法.invoke(对象)是反射的灵魂
        // 方法.invoke(对象)是反射的灵魂
        // 方法.invoke(对象)是反射的灵魂
        // 方法.invoke(对象)是反射的灵魂
        // 方法.invoke(对象)是反射的灵魂
        // 方法.invoke(对象)是反射的灵魂
        // 方法.invoke(对象)是反射的灵魂
        // 方法.invoke(对象)是反射的灵魂
        // 方法.invoke(对象)是反射的灵魂
        // 方法.invoke(对象)是反射的灵魂
        // 方法.invoke(对象)是反射的灵魂
        // 方法.invoke(对象)是反射的灵魂
        clsMethod.invoke(o);


    }
}
