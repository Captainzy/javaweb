package threadPractice.customerAndProducter;

/**
 * @author zouyang
 * @time 2017年1月9日 下午4:56:57
 * @description 生产者
 */
public class Producer implements Runnable {
	private ProductWarehouse pwh;
	private String name;
	Producer() {
	}

	Producer(String name,ProductWarehouse pwh) {
		this.pwh = pwh;
		this.name = name;
	}

	@Override
	public void run() {
		for(int i = 0;i<10;i++){
			pwh.produce();
		}
	}
}
