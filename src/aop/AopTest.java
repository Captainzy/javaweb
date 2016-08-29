package aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component  //注意：切面必须是 IOC 中的 bean：添加了 @Component 注解或者将切面在
public class AopTest {
	@Pointcut("execution(* cn.zouyang.test.service.*.*(..))")
	private void testPointCut(){
		System.out.println("----------------testPointCut--------------");
	}
	
	@Before("testPointCut()")
	public void beforePointCut(){
		System.out.println("====================beforePointCut=-=====================");
	}
	
	@After("testPointCut()")
	public void afterPointCut(){
		System.out.println("====================afterPointCut=-=====================");
	}
	
	
}
