package threadPractice.customerAndProducter;
/**
 * @author zouyang
 * @time 2017年1月9日 下午5:05:55
 * @description 产品仓库
 */
public class ProductWarehouse {
	private final int capacity = 10;  //容量
	private int curAmount; //当前数量
	
	public int getCurAmount() {
		return curAmount;
	}
	
	public void setCurAmount(int curAmount) {
		this.curAmount = curAmount;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
}
