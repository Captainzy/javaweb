package duanxin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import duanxin.entity.UserMsg;
import duanxin.service.MessageService;

/**
 * @author zouyang
 * @time 2017年1月18日 下午3:23:10
 * @description 短信推送
 */
@Controller
@RequestMapping("/sendMsg")
public class MessageController {
	
	@Autowired
	private MessageService ms;
	/**
	 * @author zouyang
	 * @time 2017年1月18日 下午3:23:22
	 * @description TODO
	 * @param msg
	 * @param numbers 短信接收号码，每个号码必须以分号结束
	 * @return
	 */
	@RequestMapping(value="/sendMsgToGroup",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody String sendMsgToGroup(
			@RequestParam(value="inforList",required=true,defaultValue="")String inforList){
		List<UserMsg> list = new ArrayList<UserMsg>();
		list = JSON.parseArray(inforList, UserMsg.class);
		String result = ms.sendMsgToGroup(list);
		return result;
	}
}
