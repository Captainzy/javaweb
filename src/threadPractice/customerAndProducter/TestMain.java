package threadPractice.customerAndProducter;

public class TestMain {
	public static void main(String[] args) {
		ProductWarehouse pwh = new ProductWarehouse();
		Customer c1 = new Customer("C1",pwh);
	}
}
