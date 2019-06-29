package concurrency;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

public class CustomThreadPoll {

	private final int threads;
	private final ThreadTask threadTasks[];
	private LinkedBlockingQueue queue;

	public CustomThreadPoll(int threads) {
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

		CustomThreadPoll testThreadPoll =new CustomThreadPoll(10);
		testThreadPoll.execute(new TestThread());
		
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
				task = (Runnable) queue.poll();

				try {
					task.run();
				} catch (RuntimeException ex) {
					System.out.println("Excpeiton in kfekjf" + ex.getMessage());
				}
			}
		}
	}

}
