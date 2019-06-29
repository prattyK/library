package concurrency;

public class DoubleSynchronizedTest {

	private  synchronized void m1() {
		System.out.println(Thread.currentThread().getName());
		m2();
	}

    private synchronized void m2() {
    	System.out.println(Thread.currentThread().getName());
	}

	public static void main(String[] args) {
     new DoubleSynchronizedTest().m1();
	}

}
