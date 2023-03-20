package com.example.staffnetwork.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
public class JobSeekerAop {
    Logger logger = LoggerFactory.getLogger(JobSeekerAop.class);

    @Before("execution(* com.example.staffnetwork.service.impl.JobSeekerServiceImpl+.*(..))")
    public void before(JoinPoint joinPoint){
        logger.info("Before - "+joinPoint.getSignature().getName());
        logger.info("Before - "+joinPoint.getTarget().getClass());
        logger.info("Before - "+ Arrays.toString(joinPoint.getArgs()));
    }

    @After("execution(* com.example.staffnetwork.service.impl.JobSeekerServiceImpl+.*(..))")
    public void after(JoinPoint joinPoint){
        logger.info("After - "+joinPoint.getTarget().getClass());
        logger.info("After - "+joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "execution(* com.example.staffnetwork.service.impl.JobSeekerServiceImpl+.*(..))",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        logger.info("After Return - "+joinPoint.getTarget().getClass());
        logger.info("After Return - "+joinPoint.getSignature().getName());
        logger.info("Returned - "+result);
    }

    @AfterThrowing(value = "execution(* com.example.staffnetwork.service.impl.JobSeekerServiceImpl+.*(..))",throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint,Exception ex){
        logger.info("After Throwing - "+joinPoint.getTarget().getClass());
        logger.info("After Throwing - "+joinPoint.getSignature().getName());
        logger.info("Exception - "+ex.getMessage());
    }
}
