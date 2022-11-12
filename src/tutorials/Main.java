package tutorials;

import tutorials.concurrency.ThreadPool;

public class Main {

	public static void main(String... argz) throws Exception {
		ThreadPool threadPool = new ThreadPool(111, 111);

		for (int i = 0; i < 1113; i++) {
			int taskNo = i;
			threadPool.execute(() -> {
				String message = Thread.currentThread().getName() + ": Task " + taskNo;
				System.out.println(message);
			});
		}

		threadPool.waitUntilAllTasksFinished();
		threadPool.stop();
	}
}