package threadPractice.threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestMain {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		List<Future<String>> list = new ArrayList<Future<String>>();
		for (int i = 1; i <= 6; i++) {
			String name = "t" + i;
			Future f = null;
			if (i > 3) {
				f = es.submit(new DealThread_02(name));
				list.add(f);
			} else {
				/**
				 * execute 和 submit的最大的区别就是，execute有返回值，submit没有
				 * execute传递的参数是实现Runnable接口的类
				 * submit传递的参数是实现了Runnable接口的类或者实现了Callable<?>接口的类，但是只有参数是实现了Callable<?>接口的类时才有返回值。
				 * Callable<?>接口的call方法就相当于实现Runnable接口的run方法
				 */
				// es.execute(new DealThread(name));
				f = es.submit(new DealThread(name));
				list.add(f);
			}
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		for (Future<String> f : list) {
			String result = "";
			try {
				result = f.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			System.out.println("线程的返回值是：" + result);
		}
	}
}
