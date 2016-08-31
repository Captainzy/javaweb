package cn.zouyang.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zouyang.test.service.TestService;
import springTypeConversion.Child;
import springTypeConversion.IntegerToString;
import springTypeConversion.PeopleToAnimal;

/**
 * @ClassName: Test
 * @Description: TODO(杩欓噷鐢ㄤ竴鍙ヨ瘽鎻忚堪杩欎釜绫荤殑浣滅敤)
 * @author zouyang
 * @date 2016骞�鏈�8鏃�涓嬪崍4:06:32
 * 
 */

@Controller
@RequestMapping("/Test")
public class Test {
	
	@Autowired
	private TestService testService;
	@Autowired
	private IntegerToString integerToString;
	@Autowired
	private PeopleToAnimal peopleToAnimal;
	@RequestMapping(value="/test",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody String test(HttpServletRequest request,HttpServletResponse response){
		//aop测试
		testService.test();
		//类型转换测试   -01
		int i = 5;
		System.out.println(integerToString.convert(i));
		//类型转换测试   -02
		springTypeConversion.People p = new springTypeConversion.People();
		p.setAge("17");
		p.setName("Tom");
		Child child = peopleToAnimal.getConverter(Child.class).convert(p);
		System.out.println(child.toString());
		return "测试效果";
	}
	
	@RequestMapping(value="/getUserInfo",produces="text/html;charset=UTF-8")
	public String getUserInfo(HttpServletRequest request){
		request.setAttribute("userName", "zouyang");
		request.setAttribute("password", "12345");
		return "index";
	}
	
	@RequestMapping(value="/getUserInfoNew",produces="application/json;charset=UTF-8")
	public @ResponseBody String getUserInfoNew(HttpServletRequest request){
		request.setAttribute("userName", request.getParameter("userName"));
		request.setAttribute("password", request.getParameter("password"));
		return "success";
	}
	
	@RequestMapping(value="/{varName}/getPathVariable/{varValue}/{methodName}")
	public @ResponseBody String getPathVariable(String varName,String varValue,String methodName){
		System.out.println("varName:"+varName+"\nvarValue:"+varValue+"\nmethodName:"+methodName);	
		return "success";
	}
}
