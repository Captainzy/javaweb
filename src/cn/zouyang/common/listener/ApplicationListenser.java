package cn.zouyang.common.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @ClassName: ApplicationListenser
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zouyang
 * @date 2016年7月11日 下午9:03:41
 * 
 */

@WebListener
public class ApplicationListenser implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();
		ApplicationContext appContext = ApplicationContext.getApplicationContext();
		appContext.register(servletContext);
		appContext.setBasePath(servletContext.getContextPath());
	}
	
}
