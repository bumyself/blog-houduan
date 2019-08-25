package com.linminrui.blog.aspect;


import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.linminrui.blog.web.*.*(..))")
    public void pointCut(){

    }

    @Before( "pointCut()")
    public void before(){
        logger.info("--------------Before--------------");
    }

    @After( "pointCut()")
    public void after(){
        logger.info("--------------After--------------");
    }

    @AfterReturning(returning = "result", pointcut = "pointCut()")
    public void afterResult(Object result){
        logger.info("the result is " + result);
    }

}
