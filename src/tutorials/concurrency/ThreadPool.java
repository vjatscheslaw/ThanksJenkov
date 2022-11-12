package tutorials.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {

	private BlockingQueue<Runnable> tasksBuffer = null;
	private List<PoolThreadRunnable> workersCollection = new ArrayList<>();
	private boolean isStopped = false;

	public ThreadPool(int noOfThreads, int maxNoOfTasks) {
		tasksBuffer = new ArrayBlockingQueue<Runnable>(maxNoOfTasks);

		for (int i = 0; i < noOfThreads; i++)
			workersCollection.add(new PoolThreadRunnable(tasksBuffer));

		for (var runnable : workersCollection)
			new Thread(runnable).start();
	}

	public synchronized void execute(Runnable task) throws Exception {
		if (this.isStopped)
			throw new IllegalStateException("ThreadPool is stopped");

		this.tasksBuffer.put(task);
	}

	public synchronized void stop() {
		this.isStopped = true;
		for (var runnable : workersCollection)
			runnable.doStop();
	}

	public synchronized void waitUntilAllTasksFinished() {
		while (this.tasksBuffer.size() > 0) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}