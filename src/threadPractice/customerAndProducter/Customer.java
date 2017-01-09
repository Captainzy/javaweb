package threadPractice.customerAndProducter;
/**
 * @author zouyang
 * @time 2017年1月9日 下午4:56:46
 * @description 消费者
 */
public class Customer extends Thread{
	private ProductWarehouse pwh;
	private String name;
	Customer(){}
	Customer(String name,ProductWarehouse pwh){
		this.pwh = pwh;
		this.name = name;
	}
	@Override
	public void run() {
		for(int i = 0;i<10;i++){
			pwh.sale();
		}
	}

}
