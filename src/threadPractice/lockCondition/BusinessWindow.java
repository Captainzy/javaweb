package threadPractice.lockCondition;

import java.util.concurrent.locks.Condition;

public class BusinessWindow implements Runnable {
	private boolean dealVip;
	private Condition cvip;
	private Condition c;
	private int num;// vip等待人数
	private int curNum;// 当前总共等待人数

	BusinessWindow() {
	}

	public BusinessWindow(boolean dealVip, Condition cvip, Condition c, int num, int curNum) {
		this.dealVip = dealVip;
		this.cvip = cvip;
		this.c = c;
		this.num = num;
		this.curNum = curNum;
	}

	public boolean isDealVip() {
		return dealVip;
	}

	public void setDealVip(boolean dealVip) {
		this.dealVip = dealVip;
	}

	
	public int getCurNum() {
		return curNum;
	}

	public void setCurNum(int curNum) {
		this.curNum = curNum;
	}

	public void checkNum() {
		if (num > 0) {
			dealVip = true;
			this.num--;
		} else {
			dealVip = false;
		}
		handleBusiness();
	}

	// 处理业务
	public void handleBusiness() {
		if (curNum > 0) {
			if (dealVip) {
				cvip.signalAll();
				System.out.println("正在办理vip客户业务");
			} else {
				c.signalAll();
				System.out.println("正在办理普通客户业务");
			}
			this.curNum--;
		}

	}

	@Override
	public void run() {
		System.out.println("----------开始办理业务");
		while (true) {
			checkNum();
		}
	}

}
