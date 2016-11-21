package webservice.ws1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CXFWebServiceTest {
	public String getName(String name){
		return name;
	}
	
	public List<TestBean> getTestBeanList(){
		List<TestBean> list = new ArrayList<TestBean>();
		list.add(new TestBean("TestBean NO.1"));
		list.add(new TestBean("TestBean NO.2"));
		list.add(new TestBean("TestBean NO.3"));
		return list;
	}
	
	public Map<Integer,TestBean> getTestBeanMap(){
		Map<Integer,TestBean> map = new HashMap<Integer,TestBean>();
		map.put(1, new TestBean("TestBean map NO.1"));
		map.put(2, new TestBean("TestBean map NO.2"));
		map.put(3, new TestBean("TestBean map NO.3"));
		return map;
	}
}
