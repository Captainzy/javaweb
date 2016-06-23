package cn.zouyang.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value="/test",produces="application/json;charset=UTF-8")
	public @ResponseBody String test(){
		return "测试效果";
	}
}
