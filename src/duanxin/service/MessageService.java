package duanxin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import duanxin.modem.constant.SerialPortConstants;
import duanxin.modem.service.ModemService;

@Service
public class MessageService {

	@Autowired
	private JdbcTemplate jt;

	/**
	 * @author zouyang
	 * @time 2017年1月17日 上午10:41:49
	 * @description TODO
	 * @param msg短信内容
	 * @param number电话号码
	 * @return
	 */
	public boolean sendMsgToSingle(String msg, String number) {
		if (SerialPortConstants.DEBUG) {
			return true;
		} else {
			boolean flag = true;// 短信发送成功标识
			ModemService.getInstance().sendMessageToOne(msg, number);
			return flag;
		}
	}
}
