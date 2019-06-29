package concurrency;

import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomThreadLocal {

	private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>() {

		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd");
		}

		@Override
		public SimpleDateFormat get() {
			return super.get();
		}
	};

	private SimpleDateFormat birthDate(int userId) {
		return threadLocal.get();
	}

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(10);

		for (int i = 0; i <= 10; i++) {

			executorService.submit(() -> new CustomThreadLocal().birthDate(0));

		}

	}

}
