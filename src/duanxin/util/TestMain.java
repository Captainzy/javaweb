package duanxin.util;

import java.util.List;
import java.util.Map;

import duanxin.modem.util.SerialPortsUtil;

public class TestMain {
	public static void main(String[] args) {
		List<Map<String, String>> list = SerialPortsUtil.getAvaliableSerialPortsSet();
		for (Map<String, String> m : list) {
			for (Map.Entry<String, String> entry : m.entrySet()) {
				System.out.print(entry.getKey() + " : " + entry.getValue() + "   ");
			}
			System.out.println();
		}
	}
}
