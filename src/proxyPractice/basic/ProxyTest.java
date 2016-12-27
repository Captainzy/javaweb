package proxyPractice.basic;

/**
 * @author zouyang
 * @time 2016年12月27日 上午9:29:13
 * 代理模式一般涉及到三个角色：
 *	1.抽象角色：
 *		声明真实对象和代理对象的共同接口(ComInterface)
 *	2.代理角色(ProxyObject)：
 *		代理对象内部包含有真实角色的引用(proxy)，从而可以操作真实角色，
 *		同时代理对象 与真实对象有相同的接口，能在任何时候代替真实对象，
 *		同时代理对象可以在执行真实对象前后加入特定的逻辑以实现功能的扩展。
 *	3.真实角色(RealObject)：
 *		代理角色所代表的真实对象，是我们最终要引用的对象
 */
public class ProxyTest {

	public static void main(String[] args) {
		//通过对象直接实现
		test(new RealObject());
		//通过代理对象间接实现
		test(new ProxyObject(new RealObject()));
			
	}
	
	public static void test(ComInterface obj){
		obj.methodA();
		obj.methodB();
	}

}
