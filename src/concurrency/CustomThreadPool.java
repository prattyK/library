package concurrency;

import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {

	private final int threads;
	private final ThreadTask threadTasks[];
	private LinkedBlockingQueue queue;

	public CustomThreadPool(int threads) {
		this.threads = threads;
		this.threadTasks = new ThreadTask[threads];
		this.queue = new LinkedBlockingQueue();

		for (int i = 0; i <= threads - 1; i++) {
			threadTasks[i] = new ThreadTask();
			threadTasks[i].start();
		}
	}

	public void execute(Runnable task) {
		queue.add(task);
	}

	public static void main(String[] args) {

		CustomThreadPool testThreadPool =new CustomThreadPool(10);
		testThreadPool.execute(new TestThread());
		testThreadPool.execute(new TestThread());
		testThreadPool.execute(new TestThread());
		testThreadPool.execute(new TestThread());
		testThreadPool.execute(new TestThread());
		testThreadPool.execute(new TestThread());
		testThreadPool.execute(new TestThread());
		testThreadPool.execute(new TestThread());
		testThreadPool.execute(new TestThread());
		testThreadPool.execute(new TestThread());
		testThreadPool.execute(new TestThread());
		testThreadPool.execute(new TestThread());
		testThreadPool.execute(new TestThread());
		testThreadPool.execute(new TestThread());
		testThreadPool.execute(new TestThread());
		testThreadPool.execute(new TestThread());
		testThreadPool.execute(new TestThread());
		testThreadPool.execute(new TestThread());
		
	}

	 static class TestThread implements Runnable {
		public void run() {
			System.out.println(Thread.currentThread().getName());

		}
	}

	private class ThreadTask extends Thread {

		public void run() {
			Runnable task;
			while (true) {
				try {
				task = (Runnable) queue.take();
					task.run();
				} catch (InterruptedException ex) {
					System.out.println("Excpeiton in kfekjf" + ex.getMessage());
				}
			}
		}
	}

}
