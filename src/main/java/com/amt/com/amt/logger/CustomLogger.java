package com.amt.com.amt.logger;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * Created by MedMalek on 24/10/2015.
 */
@Aspect
@Component
public class CustomLogger {

    private static final Log LOGGER = LogFactory.getLog(CustomLogger.class);

    @Around("execution(* com.amt..*(..))")
    public Object logTimeMethod(final ProceedingJoinPoint joinPoint) throws Throwable {
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object retVal = joinPoint.proceed();
        stopWatch.stop();
        if (LOGGER.isDebugEnabled()) {
            final StringBuffer logMessage = new StringBuffer();
            logMessage.append(joinPoint.getTarget().getClass().getName());
            logMessage.append(".");
            logMessage.append(joinPoint.getSignature().getName());
            logMessage.append("( ");
            // append args
            final Object[] args = joinPoint.getArgs();
            logMessage.append(StringUtils.join(args, ", "));
            logMessage.append(" )");
            logMessage.append(" execution time: ");
            logMessage.append(stopWatch.getTotalTimeMillis());
            logMessage.append(" ms");
            LOGGER.debug(logMessage.toString());
        }
        return retVal;
    }

}

