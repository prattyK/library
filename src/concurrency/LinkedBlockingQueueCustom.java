package concurrency;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedBlockingQueueCustom<E> implements BlockingQueueCustom<E> {

	private final ReentrantLock takeLock = new ReentrantLock();

	/** Wait queue for waiting takes */
	private final Condition notEmpty = takeLock.newCondition();

	/** Lock held by put, offer, etc */
	private final ReentrantLock putLock = new ReentrantLock();

	/** Wait queue for waiting puts */
	private final Condition notFull = putLock.newCondition();

	private final AtomicInteger count = new AtomicInteger();

	private List<E> finalList = new LinkedList<>();

	@Override
	public void put(E item) throws InterruptedException {
		final int c;
		try {
			if (item == null)
				throw new NullPointerException();
			final ReentrantLock putLock = this.putLock;
			putLock.lockInterruptibly();

			if (size() == count.get()) {
				notFull.wait();
			}

			finalList.add(item);
			c = count.getAndIncrement();

			if (c + 1 < size()) {
				notFull.signal();
			}

		} finally {
			putLock.unlock();
		}

		if (c == 0) {
			signalNotEmpty();
		}

	}

	private void signalNotEmpty() {
		final ReentrantLock takeLock = this.takeLock;
		takeLock.lock();
		try {
			notEmpty.signal();
		} finally {
			takeLock.unlock();
		}
	}

	@Override
	public E take() throws InterruptedException {

		E x;
		try {
			final ReentrantLock takeLock = this.takeLock;

			takeLock.lockInterruptibly();

			while (count.get() == 0) {
				notEmpty.await();
			}

			x = finalList.remove(0);

			int c = count.decrementAndGet();

			if (c > 1) {
				notEmpty.signal();
			}
		} finally {
			takeLock.unlock();
		}

		return x;
	}

	@Override
	public int size() {
		return count.get();
	}

}
