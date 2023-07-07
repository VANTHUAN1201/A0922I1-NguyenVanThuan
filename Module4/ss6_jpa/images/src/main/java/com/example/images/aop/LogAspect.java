package com.example.images.aop;

import com.example.images.entity.Comment;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Logger;
@Aspect
@Component
public class LogAspect {
    Logger logger= Logger.getLogger(LogAspect.class.getName());

    @Around("execution(* com.example.images.controller.CommentController.create(..))")
    public Object writeLogValidate(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        Object[] argsObject = joinPoint.getArgs();
        Comment comment = new Comment();
        BindingResult bindingResult = null;
        for (Object o: argsObject){
            if (o instanceof Comment){
                comment = (Comment) o;
                continue;
            }
            if (o instanceof BindingResult){
                bindingResult = (BindingResult) o;
            }
        }

        logger.info(String.format("Before execution in %s.%s: ", className, methodName));
        Object result = joinPoint.proceed();
        assert bindingResult != null;
        if (bindingResult.hasErrors()){
            logger.info(String.format("After execution in %s.%s -- [Bad word: %s] -- [author: %s] -- [time: %s]",
                    className, methodName, comment.getFeedBack(), comment.getAuthor(), new Timestamp((new Date()).getTime())));
        }
        return result;
    }
    @Before("execution(* com.example.images.service.CommentServiceImpl.*(..))")
    public void writeLogCommentService(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        logger.info("Before execution service: "+ methodName);
    }
}
