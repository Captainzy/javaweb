package netty.appFramework.common;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import io.netty.channel.Channel;

public class AppContext {
	private Map<String, Channel> sessionMap;
	private ApplicationContext appContext;

	protected AppContext() {

		// 发布的时候由于要打jar文件，所以用绝对路径
		String[] configLocations = {
				new File("").getAbsolutePath() + "/netty.appFramework.config/applicationContext.xml" };
		// String[] configLocations = {"config/applicationContext.xml"};
		// 配置文件在类路径下
		// context = new ClassPathXmlApplicationContext(configLocations);
		// 配置文件在系统目录里
		appContext = new FileSystemXmlApplicationContext(configLocations);
	}

	public Map<String, Channel> getSessionMap() {
		return sessionMap;
	}

	public ApplicationContext getAppContext() {
		return appContext;
	}
}
