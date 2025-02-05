package com.telusko.springbootrest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    //syntax  execution(return type classname.methodname(agrs))

    //executes before method call
    @Before("execution(* com.telusko.springbootrest.service.JobService.getJob(..)) || execution(* com.telusko.springbootrest.service.JobService.getAllJobs(..))")
    public void logMethodCall(JoinPoint jp) {
        LOGGER.info("Method called "+jp.getSignature().getName());
    }

    //executes after method call
    @After("execution(* com.telusko.springbootrest.service.JobService.getJob(..)) || execution(* com.telusko.springbootrest.service.JobService.getAllJobs(..))")
    public void logMethodExecuted(JoinPoint jp) {
        LOGGER.info("Method Executed "+jp.getSignature().getName());
    }

    //executes when error received
    @AfterThrowing("execution(* com.telusko.springbootrest.service.JobService.getJob(..)) || execution(* com.telusko.springbootrest.service.JobService.getAllJobs(..))")
    public void logMethodExecutionFailed(JoinPoint jp) {
        LOGGER.info("Method Execution failed "+jp.getSignature().getName());
    }

    //executes when no error received (successfully)
    @AfterReturning("execution(* com.telusko.springbootrest.service.JobService.getJob(..)) || execution(* com.telusko.springbootrest.service.JobService.getAllJobs(..))")
    public void logMethodExecutedSuccess(JoinPoint jp) {
        LOGGER.info("Method Executed sucessfully "+jp.getSignature().getName());
    }

}