package threadPractice.customerAndProducter;

/**
 * @author zouyang
 * @time 2017年1月9日 下午5:05:55
 * @description 产品仓库
 */
public class ProductWarehouse {
	private final int capacity = 10; // 容量
	private int curAmount; // 当前数量

	public int getCurAmount() {
		return curAmount;
	}

	public void setCurAmount(int curAmount) {
		this.curAmount = curAmount;
	}

	public int getCapacity() {
		return capacity;
	}

	public void sale() {
		synchronized (this) {
			if (this.curAmount <= 0) {
				System.out.println("库存空了，等待生产。");
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				this.curAmount--;
				notifyAll();
			}
		}
	}

	public void produce() {
		synchronized (this) {
			if (this.curAmount < this.capacity) {
				this.curAmount++;
				notifyAll();
			} else {
				System.out.println("库存满了，正在生产。");
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
