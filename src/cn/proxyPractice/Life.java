package cn.proxyPractice;

public class Life implements LifeInterface {

	@Override
	public String working() {
		System.out.println("现在正在休息。。。。。");
		return "working";
	}

	@Override
	public String resting() {
		// TODO Auto-generated method stub
		System.out.println("现在正在工作。。。。。");
		return "resting";
	}
	
}
