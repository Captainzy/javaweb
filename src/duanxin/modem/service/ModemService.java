package duanxin.modem.service;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.smslib.AGateway;
import org.smslib.GatewayException;
import org.smslib.Group;
import org.smslib.OutboundMessage;
import org.smslib.Service;
import org.smslib.TimeoutException;
import org.smslib.Message.MessageEncodings;
import org.smslib.modem.SerialModemGateway;

import duanxin.modem.constant.SerialPortConstants;
import duanxin.modem.notification.InboundMessageNotification;
import duanxin.modem.notification.OutboundMessageNotification;

public class ModemService {
	public static Service srv;
	private static ModemService msu;
	private static String SEND_GROUP_NAME;//群发组名
	static {
		srv = Service.getInstance();
		if (msu == null) {
			getInstance();
		}
		SEND_GROUP_NAME = "recipients";
	}

	private ModemService() {
	}

	public static ModemService getInstance() {
		if (msu == null) {
			msu = new ModemService();
		}
		return msu;
	}

	/**
	 * @author zouyang
	 * @time 2017年1月17日 下午1:55:11
	 * @description 开启短信猫服务
	 * @param list
	 *            可用串口列表
	 */
	public static void startModelService(List<Map<String, String>> list) {
		// 将猫服务中默认的网关全部移除
		Collection<AGateway> clt = srv.getGateways();
		Iterator<AGateway> it = clt.iterator();
		while (it.hasNext()) {
			try {
				srv.removeGateway(it.next());
			} catch (GatewayException e) {
				e.printStackTrace();
			}
		}
		// 添加发送短信监听器
		srv.setOutboundMessageNotification(new OutboundMessageNotification());
		// 添加接收短信监听器
		srv.setInboundMessageNotification(new InboundMessageNotification());
		//添加一个群发组
		srv.createGroup(SEND_GROUP_NAME);
		// 根据串口信息列表，生成网关，添加到猫服务中
		for (Map<String, String> m : list) {
			SerialModemGateway gateway = new SerialModemGateway("modelPort." + m.get("serialPortName"),
					m.get("serialPortName"), Integer.valueOf(m.get("baudRate")), m.get("manufacturer"), null);
			gateway.setInbound(false);//是否接收短信
			gateway.setOutbound(true);//是否发送短信
			try {
				// 添加网关到猫服务中
				srv.addGateway(gateway);
			} catch (GatewayException e) {
				e.printStackTrace();
			}
		}
		// 开启短信猫服务
		try {
			srv.startService();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("开启短信猫服务失败.........");
		}
		System.out.println("短信猫开启成功。。。。。。");
	}

	public static void stopModemService() {
		try {
			if (srv != null) {
				srv.stopService();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("关闭短信猫服务失败。。。。");
		}
		System.out.println("短信猫已经成功关闭。。。。");
	}

	public void sendMessageToOne(String msg, String number) {
		OutboundMessage outboundMsg = getOutboundMessage(msg, number);
		try {
			srv.sendMessage(outboundMsg);
		} catch (Exception e) {
			System.out.println("收件人：" + number + "的短信发送失败。。。。");
			e.printStackTrace();
		}
	}

	public void sendMessageToGroup(String msg, String[] numberGroup) {
		for (String number : numberGroup) {
			srv.addToGroup(SEND_GROUP_NAME, number);
		}
		OutboundMessage outboundMsg = getOutboundMessage(msg,SEND_GROUP_NAME);
		try {
			srv.sendMessage(outboundMsg);
			//发送完成后，将短信号码全部都移除
			for(String number:numberGroup){
				srv.removeFromGroup(SEND_GROUP_NAME, number);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public OutboundMessage getOutboundMessage(String msg,String recipient){
		OutboundMessage outboundMsg = new OutboundMessage();
		outboundMsg.setEncoding(MessageEncodings.ENCUCS2);
		outboundMsg.setDeliveryDelay(2000);
		outboundMsg.setRetryCount(SerialPortConstants.RETRY_SEND_COUNT);
		outboundMsg.setRecipient(recipient);
		return outboundMsg;
	}
}
