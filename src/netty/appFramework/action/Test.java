package netty.appFramework.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import netty.appFramework.model.APIResult;
import netty.appFramework.service.TestService;


@Component
public class Test {
	@Autowired
	private TestService testService;
	
	public APIResult<Map<String,Object>> testAction(){
		System.out.println("测试测试测试");
		APIResult<Map<String,Object>> result = new APIResult<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String,Object>();
		result.setCode(1);
		result.setMsg("成功");
		map.put("data", testService.testQueryCount());
		result.setData(map);
		return result;
	}
}
