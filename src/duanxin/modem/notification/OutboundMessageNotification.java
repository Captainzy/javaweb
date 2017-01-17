package duanxin.modem.notification;

import org.smslib.AGateway;
import org.smslib.IOutboundMessageNotification;
import org.smslib.OutboundMessage;

public class OutboundMessageNotification implements IOutboundMessageNotification{

	@Override
	public void process(AGateway gateway, OutboundMessage outboundMsg) {
		boolean flag = true;
		try {
			flag = gateway.sendMessage(outboundMsg);
			if(!flag){
				System.out.println("发送短信失败。。。。");
			}else{
				System.out.println("发送短信成功。。。。。");
			}
		} catch (Exception e) {
			System.out.println("发生异常，发送短信失败。。。。。");
			e.printStackTrace();
		}
		
	}

}
