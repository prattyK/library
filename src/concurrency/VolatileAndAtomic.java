package concurrency;

public class VolatileAndAtomic {

	boolean check = true;

	private void prcoess() throws InterruptedException {

		new Task1().run();
		new Task2().run();
	}

	public static void main(String[] args) throws InterruptedException {

		new VolatileAndAtomic().prcoess();

	}

	class Task1 implements Runnable {

		public void run() {

			System.out.println("Check" + check);
			while (check) {
				System.out.println("Printing" + Thread.currentThread().getName());
			}
			System.out.println("After While Check" + check);

		}
	}

	class Task2 implements Runnable {

		public void run() {

			check = false;

			System.out.println("Second Thread" + Thread.currentThread().getName());

		}
	}

}
