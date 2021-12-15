package com.dexlace.reflect.basic;


import lombok.Data;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

@Data
public class ReflectionBasic2 {
    public static void main(String[] args) throws Exception{
        // class对象可以获取构造函数、实例、属性等
        Class<?> aClass = Class.forName("com.dexlace.reflect.basic.Cat");
        //    获取实例对象
        Object o = aClass.newInstance();

        // 1.获取构造函数
        Constructor<?>[] constructors = aClass.getConstructors();
        for (int i = 0; i < constructors.length; i++){
            Class<?> clazzs[] = constructors[i].getParameterTypes();
            System.out.println("cons[" + i + "] ");
            for (int j = 0; j < clazzs.length; j++) {
                if (j == clazzs.length - 1)
                    System.out.println(clazzs[j].getName());
                else
                    System.out.print(clazzs[j].getName() + ",");
            }
        }

        // 2. 通过Constructor获取实例对象
        // 由于第一个构造函数是全参数的，所以可以传递参数进去
        Object instance = constructors[0].newInstance(2, "dex");
        System.out.println(instance);
        Object instance1 = constructors[1].newInstance();
        System.out.println(instance1);


        // 3. 获取属性
        // 取得本类的全部属性，注意getDeclaredFields()仅仅获得本类的属性
        Field[] field = aClass.getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
            // 权限修饰符
            int mo = field[i].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = field[i].getType();
            System.out.println(priv + " " + type.getName() + " " + field[i].getName() + ";");
        }


        // 4. 获取实现的接口或者父类的public属性 getFields()
        Field[] filed1 = aClass.getFields();
        for (int j = 0; j < filed1.length; j++) {
            // 权限修饰符
            int mo = filed1[j].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = filed1[j].getType();
            System.out.println(priv + " " + type.getName() + " " + filed1[j].getName() + ";");
        }

    }
}
