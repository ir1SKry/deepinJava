package com.ustbcafe.deepin.proxy.aspectj;

import com.ustbcafe.deepin.proxy.Monitor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * Created by wangjin18 on 2017/7/26.
 */

@Aspect
 public class MonitorAspect {


    @Pointcut("@annotation(monitor)")
    public void monitorAspect(Monitor monitor){

    }
    @Before("@annotation(monitor) &&execution(* *(..))")
    public void before(JoinPoint point,Monitor monitor) throws Throwable{

        System.out.println("before aspect ,monitor aspect");
    }
    /*
    *  without execution will lead invoke process twice
    * */

    @Around("@annotation(monitor) &&execution(* *(..))")
    public Object process(ProceedingJoinPoint point,Monitor monitor) throws Throwable{
        Object[] args=point.getArgs();
       // String key= monitor.key().getKey();&&

        System.out.println(Arrays.toString(args) + ",monitor aspect");
        Object result= point.proceed(point.getArgs());
        System.out.println("result:"+result);

       return  8;
    }
//   @AfterThrowing(pointcut = "@annotation(monitor) &&execution(* *(..))",throwing ="Exception" )
//   public void afterThrowing(JoinPoint point){
//       System.out.println("result:exception signature "+point.getSignature()+",target"+point.getTarget());
//    }

    @AfterReturning("@annotation(monitor) &&execution(* *(..))")
    public void afterReturning(JoinPoint point,Monitor monitor){

    }

}
