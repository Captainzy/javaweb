package netty.appFramework.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import netty.appFramework.service.TestService;


@Component
public class Test {
	@Autowired
	private TestService testService;
	
	public int testAction(){
		System.out.println("测试测试测试");
		return testService.testQueryCount();
	}
}
