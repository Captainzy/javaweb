package duanxin.common;

import java.util.List;
import java.util.Map;

import duanxin.modem.service.ModemService;
import duanxin.modem.util.SerialPortsUtil;

public class TaskRestartCat {
	public void restartMessageCat(){
		new Thread(new Runnable(){

			@Override
			public void run() {
				boolean flag = true;
				flag = SerialPortsUtil.resetMessageCat();
				if(flag){
					try {
						//使用AT指令来进行远程复位重启短信猫设备。AT+CFUN=1是重启短信猫软件堆栈和硬件堆栈的指令。
						//执行短信猫复位AT指令后，执行后稍等30秒左右再进行其他操作
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ModemService.getInstance().stopModemService();
					List<Map<String,String>> list = SerialPortsUtil.getAvaliableSerialPortsSet();
					ModemService.getInstance().startModelService(list);
				}else{
					
				}
			}
			
		});
	}
}
