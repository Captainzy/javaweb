package proxyPractice;

public class RealObject implements ComInterface{

	@Override
	public void methodA() {
		System.out.println("RealObject method A");
	}

	@Override
	public void methodB() {
		System.out.println("RealObject method B");
	}

}
