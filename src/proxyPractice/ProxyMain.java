package proxyPractice;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyMain {
	public static void main(String[] args) throws Exception{
		//getProxyClass获取代理对象
//		MyInvocationHandler handler = new MyInvocationHandler();
//		Class proxyClass = Proxy.getProxyClass(Life.class.getClassLoader(), new Class[]{LifeInterface.class});
//		Constructor constructor = proxyClass.getConstructor(new Class[]{InvocationHandler.class});
//		LifeInterface life = (LifeInterface) constructor.newInstance(handler);
//		life.working();
//		life.resting();
		
		//newProxyInstance获取代理对象
//		MyInvocationHandler handler2 = new MyInvocationHandler();
//		LifeInterface proxyClass2 = (LifeInterface) Proxy.newProxyInstance(Life.class.getClassLoader(), new Class[]{LifeInterface.class}, handler2);
//		proxyClass2.working();
//		proxyClass2.resting();
		
		//代理工厂
		LifeInterface life  = new Life();
		LifeInterface obj = (LifeInterface)ProxyFactory.getProxy(life);
		obj.working();
		obj.resting();
	}
}
