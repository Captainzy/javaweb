package netty.appFramework.common;

import java.io.File;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public enum AppContext {
	APPLICATIONCONTEXT;
	private ApplicationContext appContext;
	//枚举类型在调用的时候会默认执行构造函数，且只会执行一次.
	private AppContext(){
		//发布的时候由于要打jar文件，所以用绝对路径
		String[] configLocations = {new File("").getAbsolutePath()+"/netty.appFramework.config/applicationContext.xml"};
		//String[] configLocations = {"config/applicationContext.xml"};
		//配置文件在类路径下
		//context = new ClassPathXmlApplicationContext(configLocations);
		//配置文件在系统目录里
		appContext = new FileSystemXmlApplicationContext(configLocations);
	}
	public ApplicationContext getInstantce(){
		return appContext;
	}
}
