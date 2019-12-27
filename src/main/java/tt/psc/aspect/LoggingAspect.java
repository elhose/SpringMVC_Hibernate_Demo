package tt.psc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    //setup looger
    private Logger logger = Logger.getLogger(this.getClass().getName());

    //setupPointcuts
    @Pointcut("execution( * tt.psc.dao.*.*(..))")
    private void forDaoPackage() {
    }

    @Pointcut("execution( * tt.psc.service.*.*(..))")
    private void forServicePackage() {
    }

    @Pointcut("execution( * tt.psc.controller.*.*(..))")
    private void forControllerPackage() {
    }

    @Pointcut("forDaoPackage() || forServicePackage() || forControllerPackage()")
    private void forDaoAndServiceAndControllerPackage() {
    }

    //add @Before advice
    @Before("forDaoAndServiceAndControllerPackage()")
    private void before(JoinPoint joinPoint) {
        //display method calling
        String signature = joinPoint.getSignature().toShortString();
        logger.info("@Before method ==========> " + signature);

        //display arguments to the method
        Object[] arguments = joinPoint.getArgs();

        for (Object argument : arguments) {
            logger.info("argument from " + signature + " method ->>>>>>>>>> " + argument);
        }
    }

    //add @AfterReturning advice
    @AfterReturning(pointcut = "forDaoAndServiceAndControllerPackage()", returning = "result")
    private void after(JoinPoint joinPoint, Object result) {

        //display method
        String signature = joinPoint.getSignature().toShortString();
        logger.info("@After method ==========> " + signature);

        //display data returned
        logger.info("result ==========> " + result);

    }
}
