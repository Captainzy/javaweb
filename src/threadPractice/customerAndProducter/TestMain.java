package threadPractice.customerAndProducter;

public class TestMain {
	public static void main(String[] args) {
		ProductWarehouse pwh = new ProductWarehouse();
		Customer c1 = new Customer("C1",pwh);
		Customer c2 = new Customer("C2",pwh);
		Customer c3 = new Customer("C3",pwh);
		Customer c4 = new Customer("C4",pwh);
		Thread t1 = new Thread(new Producer("p1",pwh));
		Thread t2 = new Thread(new Producer("p2",pwh));
		Thread t3 = new Thread(new Producer("p3",pwh));
		Thread t4 = new Thread(new Producer("p4",pwh));
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
