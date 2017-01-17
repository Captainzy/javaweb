package duanxin.dispatchThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import duanxin.modem.constant.SerialPortConstants;

/**
 * @author zouyang
 * @time 2017年1月17日 上午11:00:29
 * @description 线程调度工厂
 */
public class DispatchThreadFactory implements ThreadFactory {
	public static ExecutorService es;
	private static DispatchThreadFactory dtf;
	static{
		if(dtf==null){
			dtf = newInstance();
		}
		es = Executors.newFixedThreadPool(SerialPortConstants.CARDCOUNT,dtf);
	}
	
	private DispatchThreadFactory(){};
	
	public static DispatchThreadFactory newInstance(){
		if(dtf == null){
			dtf = new DispatchThreadFactory();
		}
		return dtf;
	}
	
	/**
	 * 实现线程工厂的方法，便于以后扩展
	 */
	@Override
	public Thread newThread(Runnable r) {
		return new Thread(r);
	}
	

}
