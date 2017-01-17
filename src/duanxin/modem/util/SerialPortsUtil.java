package duanxin.modem.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import duanxin.modem.constant.SerialPortConstants;
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

/**
 * @author zouyang
 * @time 2017年1月16日 下午2:42:50
 * @description 串口检测工具类
 */
public class SerialPortsUtil {
	/**
	 * @author zouyang
	 * @time 2017年1月16日 下午8:35:41
	 * @description 得到串口对应的Map信息
	 */
	@SuppressWarnings("unchecked")
	public static List<Map<String,String>> getAvaliableSerialPortsSet(){
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Enumeration<CommPortIdentifier> portList = CommPortIdentifier.getPortIdentifiers();
		CommPortIdentifier temPort;
		while (portList.hasMoreElements()) {
			temPort = portList.nextElement();
			if (temPort.getPortType() == CommPortIdentifier.PORT_SERIAL) {
				list = helloSerialPortTest(temPort,list);
			}
		}
		return list;
	}

	public static List<Map<String,String>> helloSerialPortTest(CommPortIdentifier temPort,List<Map<String,String>> list){
			for (int n = 0; n < SerialPortConstants.BAUD_RATE_ARRAY.length; n++) {
				/**
				 * Map里包含串口的基本信息
				 * 串口名serialPortName、比特率baudRate、所有者curOwner,短信猫提供商manuFacturer，还需其他信息可调整程序获取信息
				 */
				Map<String,String> m = null;
				SerialPort serialPort = null;
				try {
					serialPort = (SerialPort) temPort.open("P"+temPort.getName()+n, 30);
				} catch (PortInUseException e) {
					e.printStackTrace();
					break;
				}
				try {
					serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN);
					serialPort.setSerialPortParams(SerialPortConstants.BAUD_RATE_ARRAY[n], // 波特率
							SerialPort.DATABITS_8, // 数据位数
							SerialPort.STOPBITS_1, // 停止位
							SerialPort.PARITY_NONE);// 奇偶位
					serialPort.enableReceiveTimeout(100);
				} catch (UnsupportedCommOperationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				InputStream inputStream;
				try {
					inputStream = serialPort.getInputStream();
					OutputStream outputStream = serialPort.getOutputStream();
					outputStream.write('A');
					outputStream.write('T');
					outputStream.write('\r');
					int i;
					StringBuffer sb = new StringBuffer();
					int c;
					while ((c = inputStream.read()) != -1) {
						sb.append((char) c);
					}
					if (sb.indexOf("OK") >= 0) {
						System.out.println("成功收到指令返回值。");
						m = new HashMap<String,String>();
						//波特率
						m.put("baudRate",String.valueOf(SerialPortConstants.BAUD_RATE_ARRAY[n]));
						//串口名
						m.put("serialPortName", serialPort.getName().substring(4));
						//当前所有者
						m.put("curOwner", temPort.getCurrentOwner());
						//短信猫设备提供商
						m.put("manuFacturer", SerialPortConstants.MANUFACTURER);
						System.out.println(sb.toString());
					}
					inputStream.close();  
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
               
                serialPort.close();
                if(m != null){
                	list.add(m);
                }
			}
			System.out.println("通信失败");
			return list;
	}
}
