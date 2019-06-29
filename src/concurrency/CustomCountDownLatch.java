package concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomCountDownLatch {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService exe = Executors.newFixedThreadPool(10);

		CountDownLatch cltd = new CountDownLatch(3);

		exe.submit(new TestTask(cltd));
		exe.submit(new TestTask1(cltd));
		exe.submit(new TestTask2(cltd));

		cltd.await();

		System.out.println("Custom Count Down");
	}

	private static class TestTask implements Runnable {

		private CountDownLatch latch;

		public TestTask(CountDownLatch latch) {
			this.latch = latch;
		}

		@Override
		public void run() {
			System.out.println("Test Task");
		
			latch.countDown();

		}

	}
	
	private static class TestTask1 implements Runnable {

		private CountDownLatch latch;

		public TestTask1(CountDownLatch latch) {
			this.latch = latch;
		}

		@Override
		public void run() {
			System.out.println("Test Task1");
		
			latch.countDown();

		}

	}
	
	private static class TestTask2 implements Runnable {

		private CountDownLatch latch;

		public TestTask2(CountDownLatch latch) {
			this.latch = latch;
		}

		@Override
		public void run() {
			System.out.println("Test Task2");
		
			latch.countDown();

		}

	}

}
