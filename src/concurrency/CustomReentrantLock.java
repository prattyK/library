package concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CustomReentrantLock {

	public ReentrantLock lock = new ReentrantLock();
	private final Condition queueEmpty = lock.newCondition();
	private final Condition queueFull = lock.newCondition();

	Queue<Integer> queue = new LinkedList<>();

	AtomicInteger atomic = new AtomicInteger();

	public void putData(int data) {
		try {

			lock.lock();
			System.out.println("Check queue size" + queue.size() + "data" + data + "Thread name"
					+ Thread.currentThread().getName());
			System.out.println("lock" + lock.getHoldCount() + " data length" + lock.getQueueLength()
					+ " data queued threads" + lock.hasQueuedThreads() + " data islocaked: " + lock.isLocked());
			while (atomic.get() == 0) {
				try {
					queueEmpty.await();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
			System.out.println("adding following data" + data);
			queue.add(data);
			atomic.incrementAndGet();
			queueFull.signalAll();
		} finally {
			System.out.println("finally");
			lock.unlock();
		}
	}

	public void getData() {
		try {
			lock.lock();
			System.out.println("Going to fetch data from queue" + queue.size());
			while (queue.isEmpty()) {
				try {
					queueFull.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Polling follwoing data" + queue.poll());
			atomic.decrementAndGet();
			queueEmpty.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {

		CustomReentrantLock custom = new CustomReentrantLock();
//		Thread t1 = new Thread(() -> {
//			custom.getData();
//		});
//		t1.start();

		Thread t = new Thread(() -> {
			custom.putData(3);
		});
		t.start();
//		Thread.sleep(2000);

		Thread t2 = new Thread(() -> {
			custom.putData(4);
		});
		t2.start();

	}

}
