package cn.sy.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAopTest {

	//@Around("execution(* cn.sy..*.DriverService.*(..))")
	@Around("execution(* cn.sy..*.DriverController.*(..))")
	public Object logServiceAccess(ProceedingJoinPoint joinPoint) {
		Object o = null;
		try {
			//System.out.println("LoggingAopTest start: " + joinPoint);
			log.info("LoggingAopTest start: " + joinPoint);
			
			//System.out.println("LoggingAopTest long string: " + joinPoint.toLongString());
			log.info("LoggingAopTest long string: " + joinPoint.toLongString());
			
			for(Object arg : joinPoint.getArgs()) {
				//System.out.println("args: " + arg);
				log.info("args: " + arg);
			}

			long start = System.currentTimeMillis();
			o = joinPoint.proceed();
			long end = System.currentTimeMillis();
			
			//System.out.println("LoggingAopTest Completed in " + (end - start) + " ms: " + joinPoint);
			log.info("LoggingAopTest Completed in " + (end - start) + " ms: " + joinPoint);

			return o;
			
		} catch (Throwable e) {
			e.printStackTrace();
			//System.out.println("LoggingAopTest failed: " + joinPoint);
			log.info("LoggingAopTest failed: " + joinPoint);
		}
		
		return o;
	}

	
//	@After("execution(* cn.sy..*.DriverService.*(..))")
//	//@Before("execution(* cn.sy..*.DriverService.*(..))")
//	public void logServiceAccess(JoinPoint joinPoint) {
//		
//		try {
//			//System.out.println("LoggingAopTest start: " + joinPoint);
//			logger.info("LoggingAopTest start: " + joinPoint);
////			
////			//System.out.println("LoggingAopTest long string: " + joinPoint.toLongString());
////			logger.info("LoggingAopTest long string: " + joinPoint.toLongString());
////			
////			for(Object o : joinPoint.getArgs()) {
////				//System.out.println("args: " + o);
////				logger.info("args: " + o);
////			}
//
//			//System.out.println("LoggingAopTest Completed in " + (end - start) + " ms: " + joinPoint);
//			logger.info("LoggingAopTest Completed " + joinPoint);
//
//		} catch (Throwable e) {
//			e.printStackTrace();
//			//System.out.println("LoggingAopTest failed: " + joinPoint);
//			logger.info("LoggingAopTest failed: " + joinPoint);
//		}
//	}

}
