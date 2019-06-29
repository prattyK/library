package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomCyclicBarrier {

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService executor = Executors.newFixedThreadPool(10);
		CyclicBarrier cyclic = new CyclicBarrier(3);
		executor.submit(new TestTask(cyclic));
		executor.submit(new TestTask(cyclic));
		executor.submit(new TestTask(cyclic));
		
		
		
	}

	private static class TestTask implements Runnable {

		private CyclicBarrier cyclicBarrier;

		public TestTask(CyclicBarrier cyclicBarrier) {
			this.cyclicBarrier = cyclicBarrier;
		}

		@Override
		public void run() {

//			while (true) {
				try {
					System.out.println(Thread.currentThread().getName());
					cyclicBarrier.await();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
				System.out.println("Charanjeet Singh CJ"+Thread.currentThread().getName());
			}

//		}

	}

}
