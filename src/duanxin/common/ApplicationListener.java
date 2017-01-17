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
    	ModemService.startModelService(list);
    }
	
}
