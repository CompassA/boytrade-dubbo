package org.study.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author fanqie
 * @date 2020/5/30
 */
@Aspect
@Component
public class HttpAspect {

    @Pointcut("execution(public * org.study.controller.*.*(..))")
    public void httpInfoLog() {}

    @Around("httpInfoLog()")
    public Object httpInfoLogAround(ProceedingJoinPoint proceedingJoinPoint) {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                        .getRequest();
        String info = String.format("remote_ip: %s, method: %s, URL: %s",
                request.getRemoteAddr(), request.getMethod(), request.getRequestURL());
        System.out.printf("Receiving request: %s\n", info);

        long startTime = System.nanoTime();
        Object res = null;
        try {
            res = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long endTime = System.nanoTime();
        System.out.printf("End of request processing, info: %s, time-consuming %.3f s\n",
                info, (endTime-startTime) / 10e9);
        return res;
    }
}
