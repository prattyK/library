package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class CustomSemaphore {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService exes = Executors.newFixedThreadPool(100);

		Semaphore sema = new Semaphore(3);

		IntStream.of(1000).forEach(i -> exes.execute(new TestTask(sema)));

		
		exes.shutdown();
		exes.awaitTermination(10000, TimeUnit.MILLISECONDS);
	}

	private static class TestTask implements Runnable {

		private Semaphore semaphore;

		public TestTask(Semaphore semaphore) {
			this.semaphore = semaphore;
		}

		@Override
		public void run() {
			try {
				semaphore.acquire();
				
				System.out.println("Acquire and going to release");
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			} finally {
				semaphore.release();
			}
		}

	}

}
