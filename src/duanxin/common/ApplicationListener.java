package duanxin.common;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import duanxin.modem.service.ModemService;
import duanxin.modem.util.SerialPortsUtil;

/**
 * @author zouyang
 * @time 2017年1月17日 上午10:36:15
 * @description 短信系统初始化
 */
@WebListener
public class ApplicationListener implements ServletContextListener {

    public ApplicationListener() {
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	ModemService.stopModemService();
    }

    public void contextInitialized(ServletContextEvent sce)  {
    	List<Map<String,String>> list = SerialPortsUtil.getAvaliableSerialPortsSet();
    	
    	boolean flag = true;
    	//在独立项目中可以设置quartz调度器，让短信猫在固定的时间重启，放置短信猫时间长了崩溃
    	if(list.size()>0){
	    	for(int i = 0;i<5;i++){
	    		//启动短信猫服务，如果启动失败则重新启动，最多重启5次
	    		System.out.println("开始启动短信猫");
	    		flag = ModemService.startModelService(list);
	    		if(flag){
	    			break;
	    		}
	    	}
    	}else{
    		System.out.println("共有串口："+list.size()+"个可用");
    	}
    	
    }
	
}