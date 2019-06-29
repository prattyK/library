package concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadAndWriteCustom {


	 static class ReaderWirterList<E> {
		 
		 private ReadWriteLock lock = new ReentrantReadWriteLock();

		private List<E> list = new ArrayList<>();

		public ReaderWirterList(E... list1) {
			list.addAll(Arrays.asList(list1));

		}

		Lock writeLock = lock.writeLock();
		public void add(E element) {
			try {
				writeLock.lock();
				System.out.println("--------"+Thread.currentThread().getName());
				writeLock.newCondition().await();
				System.out.println("hhhhhhhhhhhhhhhhhhhh");
				list.add(element);
			} catch (Exception ex) {
			} finally {
				writeLock.unlock();
			}

		}

		public E get(int index) {
			Lock readLock = lock.readLock();
			readLock.lock();
			try {

				return list.get(index);
			} catch (Exception ex) {

			} finally {
				readLock.unlock();
			}
			return null;
		}

		public int size() {
			Lock readLock = lock.readLock();
			readLock.lock();
			try {

				return list.size();
			} catch (Exception ex) {

			} finally {
				readLock.unlock();
			}
			return 0;
		}
	}

	static class Reader implements Runnable {

		private ReaderWirterList<Integer> sharedList;

		public Reader(ReaderWirterList<Integer> sharedList) {
			this.sharedList = sharedList;
		}

		@Override
		public void run() {
			Random random = new Random();
	        int index = random.nextInt(sharedList.size());
	        Integer number = sharedList.get(index);
	        System.out.println("getNumber"+number);
		}
	}

	static class Writer implements Runnable {

		private ReaderWirterList<Integer> sharedList;

		public Writer(ReaderWirterList<Integer> sharedList) {
			this.sharedList = sharedList;
		}

		@Override
		public void run() {

			Random random = new Random();
			int number = random.nextInt(100);
			sharedList.add(number);

		}
	}

	public static void main(String[] args) {

		Integer [] elements = {1,2,3,4,5};
		ReaderWirterList<Integer> readWriteList = new ReaderWirterList<>(elements); 
		
		ExecutorService exec = Executors.newFixedThreadPool(3);
			exec.submit(new Writer(readWriteList));
			exec.submit(new Writer(readWriteList));
//		}
		
//		for(int j = 0; j<=10 ;j++) {
//			new Reader(readWriteList).run();
//		}
	}

}
