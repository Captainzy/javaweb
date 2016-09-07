package aop;

import java.io.File;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import controllerTest.service.TestService;

public class AopTestMain {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-servlet.xml","applicationContext.xml");
		TestService ts = (TestService) ac.getBean("testService");
		ts.test();
	
	}
}
