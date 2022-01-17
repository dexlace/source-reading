package com.dexlace.annotation.case5.aspect;


import com.dexlace.annotation.case5.annotation.MyFieldAnnotation;
import com.dexlace.annotation.case5.annotation.MyMethodAnnotation;
import com.dexlace.annotation.case5.entity.Person;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
@Aspect
public class MyMethodAspect {

    /**
     * 其中@Pointcut声明了切点（这里的切点是我们自定义的注解类），

     */
    @Pointcut("@annotation(com.dexlace.annotation.case5.annotation.MyMethodAnnotation)")
    private void pointcut() {}

    // 环绕通知
    @Around("pointcut() && @annotation(myMethodAnnotation)")
    public Object advice(ProceedingJoinPoint joinPoint, MyMethodAnnotation myMethodAnnotation) {
        System.out.println("["
                + joinPoint.getSignature().getDeclaringType().getSimpleName()
                + "][" + joinPoint.getSignature().getName()
                + "]-这是我的方法自定义注解-[" + myMethodAnnotation.fieldConstrains()+ "]");

        Object result = null;

        // 1. 拿到请求参数 before处理
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof Person){
                System.err.println("这里进来了没");
                // 处理person参数
                Class clazz;
                try {
                    clazz=Class.forName("com.dexlace.annotation.case5.entity.Person");
                    String name="";
                    int age=0;
                    int scores=0;
                    Field[] fields = clazz.getDeclaredFields();
                    for(Field field :fields){
                        // 如果自定义的字段注解存在
                        if(field.isAnnotationPresent(MyFieldAnnotation.class)){
                            MyFieldAnnotation fieldAnnotation = field.getAnnotation(MyFieldAnnotation.class);
                            if(field.getType()==Integer.class && field.getName().equals("age")){
                                // 如果字段值的类型是integer 且字段值是age
                                age=fieldAnnotation.number();
                                continue;
                            }
                            if(field.getType()==Integer.class && field.getName().equals("scores")){
                                // 如果字段值的类型是integer 且字段值是age
                                scores=fieldAnnotation.number();
                                continue;
                            }

                            if(field.getType()==String.class && field.getName().equals("name")){
                                // 如果字段值的类型是integer 且字段值是age
                                name=fieldAnnotation.name();
                            }
                        }
                    }

                    // person参数有注解  所以转换一下
                    args[i]= clazz.getConstructors()[0].newInstance(name, age, scores);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }




        // 2.执行
        try {
            result = joinPoint.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

      return result;
    }

}
