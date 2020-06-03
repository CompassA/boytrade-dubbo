package org.study.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author fanqie
 * @date 2020/6/2
 */
@Aspect
@Component
public class ServiceLogAspect {

    @Pointcut("execution(public * org.study.service.impl.*.*(..))")
    public void serviceLog() {}

    @Around("serviceLog()")
    public Object serviceInfoLogAround(ProceedingJoinPoint proceedingJoinPoint) {
        Signature signature = proceedingJoinPoint.getSignature();
        String info = String.format("Service class: %s, serviceMethod: %s.",
                signature.getDeclaringTypeName(), signature.getName());
        System.out.printf("Request received. info: %s\n", info);

        Object res = null;
        long startTimeNano = System.nanoTime();
        try {
            res = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.printf("End of request processing. info: %s, time-consuming: %.3f\n",
                info, (System.nanoTime() - startTimeNano) / 10e9);
        return res;
    }
}
