package com.dexlace.annotation.case4.aspect;


import com.dexlace.annotation.case4.annotation.MyLog;
import com.dexlace.annotation.case4.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLogAspect {

    /**
     * 其中@Pointcut声明了切点（这里的切点是我们自定义的注解类），

     */
    @Pointcut("@annotation(com.dexlace.annotation.case4.annotation.MyLog)")
    private void pointcut() {}

    /**
     * * 其中@Before声明了通知内容，在具体的通知中，
     * 我们通过@annotation(logger)拿到了自定义的注解对象，所以就能够获取我们在使用注解时赋予的值了
     */
//    @Before("pointcut() && @annotation(logger)")
//    public void advice(MyLog logger) {
//        System.out.println("--- 日志的内容为[" + logger.value() + "] ---");
//    }

    /**
     * 演示拿到自定义注解的类名和方法名
     */
//    @Before("pointcut() && @annotation(logger)")
//    public void advice(JoinPoint joinPoint, MyLog logger) {
//        //  System.out.println("注解作用的方法名: " + joinPoint.getSignature().getName());
//        //
//        //        System.out.println("所在类的简单类名: " + joinPoint.getSignature().getDeclaringType().getSimpleName());
//        //
//        //        System.out.println("所在类的完整类名: " + joinPoint.getSignature().getDeclaringType());
//        //
//        //        System.out.println("目标方法的声明类型: " + Modifier.toString(joinPoint.getSignature().getModifiers()));
//        System.out.println("["
//                + joinPoint.getSignature().getDeclaringType().getSimpleName()
//                + "][" + joinPoint.getSignature().getName()
//                + "]-日志内容-[" + logger.value() + "]");
//    }


    // 环绕通知
    @Around("pointcut() && @annotation(logger)")
    public Object advice(ProceedingJoinPoint joinPoint, MyLog logger) {
        System.out.println("["
                + joinPoint.getSignature().getDeclaringType().getSimpleName()
                + "][" + joinPoint.getSignature().getName()
                + "]-日志内容-[" + logger.value() + "]");

        Object result = null;

        // 1. 拿到请求参数 before处理
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            // 这里演示的是把拿到的integer参数减去一再传入
            if(args[i] instanceof Integer) {
                args[i] = (Integer)args[i] - 1;
                break;
            }
        }

        // 2.执行
        try {
            result = joinPoint.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        // 3. after处理  返回的还是原来的id
        // 这只是在说明aop吧
        if(result instanceof User) {
            User user = (User) result;
            user.setId(user.getId() + 1);
            return user;
        }
        return result;
    }




}
