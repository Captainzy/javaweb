package cn.proxyPractice;

import java.lang.reflect.Proxy;

public class ProxyFactory {
	public static Object getProxy(Object target){
		MyInvocationHandler handler = new MyInvocationHandler();
		handler.setTarget(target);
		Object obj = Proxy.newProxyInstance(Life.class.getClassLoader(), target.getClass().getInterfaces(), handler);
		return obj;
	}
}
