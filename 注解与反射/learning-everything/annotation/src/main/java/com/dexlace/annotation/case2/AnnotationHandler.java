package com.dexlace.annotation.case2;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 所以其实是一个注解处理器  底层原理是反射
 */
public class AnnotationHandler {
    public static void main(String[] args) {

        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUseCases(useCases, PasswordUtils.class);
    }
    public static void trackUseCases(List<Integer> useCases, Class<?> cl) {
        /**
         * 得到类的所有注解对象
         */
        for (Method m : cl.getDeclaredMethods()){
            // getDeclaredAnnotation  返回指定类型的 注解对象
            UseCase uc = m.getDeclaredAnnotation(UseCase.class);
            if (uc != null){
                System.out.println("Found UseCase :" + uc.id() + "\t" + uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }

        System.out.println("--------------------------------------");
        for (int i : useCases){
            System.out.println("Warning : Miss use case --" + i);
        }
    }

}

