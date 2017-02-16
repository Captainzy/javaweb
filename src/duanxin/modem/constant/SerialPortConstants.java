package duanxin.modem.constant;

public abstract class SerialPortConstants {
	public static final int[] BAUD_RATE_ARRAY = {9600,19200,38400,115200};//常见的波特率数组
	public static final String MANUFACTURER = "WAVECOM";//短信猫设备提供商
	public static final int CARDCOUNT = 4;//短信猫里插的能工作的电话卡的数量
	public static final boolean DEBUG = false;//是否调试模式
	public static final boolean INBOUNDMESSAGE = false;//是否可以接收短信
	public static final boolean OUTBOUNDMESSAGE = true;//是否可以发送短信
}
