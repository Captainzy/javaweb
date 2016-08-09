package cn.proxyPractice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

	private Object target;
	
	public void setTarget(Object target){
		this.target = target;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if(this.target != null ){
			System.out.println("before AOP");
			System.out.println(method.invoke(target, args));
			System.out.println("after AOP");
		}else{
			System.out.println("现在执行方法："+method.getName());
		}
		if(args != null && args.length>0){
			System.out.println("下面是参数");
			for(int i = 0;i<args.length;i++){
				System.out.print(args[i].toString());
			}
			System.out.println();
		}
		return null;
	}
	
}
