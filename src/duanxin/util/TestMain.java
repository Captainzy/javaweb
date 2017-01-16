package duanxin.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import gnu.io.UnsupportedCommOperationException;

public class TestMain {
	public static void main(String[] args) {
		try {
			List<Map<String, String>> list = SerialPortsUtil.getAvaliableSerialPortsSet();
			for (Map<String, String> m : list) {
				for (Map.Entry<String, String> entry : m.entrySet()) {
					System.out.print(entry.getKey() + " : " + entry.getValue() + "   ");
				}
				System.out.println();
			}
		} catch (UnsupportedCommOperationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
