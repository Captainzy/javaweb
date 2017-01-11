package threadPractice.lockCondition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestCondition {
	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		Condition cvip = lock.newCondition();
		Condition c = lock.newCondition();
		List<Customer> list = new ArrayList<Customer>();

		BusinessWindow bw = new BusinessWindow(true, cvip, c, 3,9);

		list.add(new Customer(lock, cvip, bw, true));
		list.add(new Customer(lock, c, bw, false));
		list.add(new Customer(lock, c, bw, false));
		list.add(new Customer(lock, cvip, bw, true));
		list.add(new Customer(lock, c, bw, false));
		list.add(new Customer(lock, c, bw, false));
		list.add(new Customer(lock, c, bw, false));
		list.add(new Customer(lock, c, bw, false));
		list.add(new Customer(lock, cvip, bw, true));

		ExecutorService es = Executors.newFixedThreadPool(10);
		
		for (int i = 0; i < 9; i++) {
			es.execute(list.get(i));
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		es.execute(bw);
	}
}
