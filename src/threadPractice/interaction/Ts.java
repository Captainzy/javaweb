package threadPractice.interaction;
import java.io.IOException;
import java.util.Stack;

public class Ts {

	public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException, IOException {

		Calculator c = new Calculator();
		new ReadResultThread(c).start();
		new ReadResultThread(c).start();
		new ReadResultThread(c).start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(c).start();
		
		
	}

}
