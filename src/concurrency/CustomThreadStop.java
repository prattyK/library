package concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CustomThreadStop {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

		// We can stop a thread by using thread.interrupt or volatile
		Future<?> future = null;
		Task1 task1 = new Task1();
		try {
			System.out.println(Thread.currentThread().getName());
			ExecutorService exec = Executors.newFixedThreadPool(2);
			future = exec.submit(task1);

//		future.get(1000, TimeUnit.MILLISECONDS);

			future.get(10000, TimeUnit.MILLISECONDS);

			System.out.println(Thread.currentThread().getName());
		} catch (TimeoutException ex) {
			future.cancel(true);
			System.out.println("HHH"+Thread.currentThread().getName()+"nanann"+Thread.currentThread().isInterrupted());
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		} catch (Exception ex) {
			System.out.println("Exception ex" + ex.getMessage());
		}

	}

	static class Task1 implements Runnable {

		@Override
		public void run() {

			System.out.println(Thread.currentThread().isInterrupted());
			while (!Thread.currentThread().isInterrupted()) {
				System.out.println("Current Thread name" + Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}

}
