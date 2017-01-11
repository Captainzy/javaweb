package threadPractice.lockCondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Customer implements Runnable {
	private ReentrantLock lock;
	private Condition c;
	private BusinessWindow bw;
	private boolean isVip;

	public Customer() {
	}

	public Customer(ReentrantLock lock, Condition c, BusinessWindow bw, boolean isVip) {
		super();
		this.lock = lock;
		this.c = c;
		this.bw = bw;
		this.isVip = isVip;
	}

	@Override
	public void run() {
		lock.lock();
		try {
			System.out.println("等待办理业务");
			c.await();
			System.out.println("客户开始办理");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (isVip) {
			System.out.println("VIP客户办理业务");
		} else {
			System.out.println("普通客户办理业务");
		}
		lock.unlock();
	}

}
