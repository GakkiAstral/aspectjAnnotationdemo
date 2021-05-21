package com.bjsxt.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

@Aspect //指定当前对象为切面对象
@Order(2)
public class MyAspect2 {
    /**
     * 配置切点
     */
    @Pointcut("execution(* com.bjsxt.service.*.*(..))")
    public void myPointcut() {

    }

    /**
     * 前置通知
     *
     * @param joinPoint
     */
    //@Before("execution(* com.bjsxt.service.*.*(..))")
    //在定义了切点方法以后,可以简写为切点方法的方法名
    @Before("myPointcut()")
    public void myBefore(JoinPoint joinPoint) {
        System.out.println("Before2……" + joinPoint.getSignature().getName());
    }

    /**
     * 后置通知
     *
     * @param joinPoint
     */
    @AfterReturning("myPointcut()")
    public void myAfterReturning(JoinPoint joinPoint) {
        System.out.println("AfterReturning2……" + joinPoint.getSignature().getName());
    }

    /**
     * 环绕通知
     *
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("myPointcut()")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Around Before2 ");
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("Around After2 ");
        return obj;
    }

    /**
     * 最终通知
     */
    @After("myPointcut()")
    public void myAfter() {
        System.out.println("最终通知2");
    }

    /**
     * 异常通知,需要定义value和throwing传递到哪个参数里
     *
     * @param ex
     */
    @AfterThrowing(value = "myPointcut()", throwing = "ex")
    public void myAfterThrowing(Exception ex) {
        System.out.println("Exception2 " + ex);
    }
}
