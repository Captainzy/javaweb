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
		while (true) {
			synchronized (pwh) {
				if (pwh.getCurAmount() >= pwh.getCapacity()) {
					try {
						System.out.println("厂库满了，等等再生产");
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("生产了一个产品");
					try {
						Thread.sleep(1000);// 模拟生产时间
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					pwh.setCurAmount(pwh.getCurAmount() + 1);

				}
			}
		}
	}
}
