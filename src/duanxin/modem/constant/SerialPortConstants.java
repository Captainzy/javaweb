package duanxin.modem.constant;

public abstract class SerialPortConstants {
	public static final int[] BAUD_RATE_ARRAY = {57600, 115200};//波特率数组
	public static final String MANUFACTURER = "WAVECOM";//短信猫设备提供商
	public static final int CARDCOUNT = 4;//短信猫里插的能工作的电话卡的数量
	public static final boolean DEBUG = false;//是否调试模式
	public static final int RETRY_SEND_COUNT = 4;////发送信息失败后允许重复发送的次数
	public static final String SERVICE_CENTER_NUMBER = "";//短信中心号码
}
