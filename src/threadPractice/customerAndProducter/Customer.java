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
		while(true){
			synchronized(pwh){
				if(pwh.getCapacity()>0){
					System.out.println("消费者："+name+"买了一个商品");
					pwh.setCurAmount(pwh.getCurAmount()-1);
				}else{
					System.out.println("没有货了，先等等");
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
