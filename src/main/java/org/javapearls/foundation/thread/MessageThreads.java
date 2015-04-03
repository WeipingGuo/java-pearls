package org.javapearls.foundation.thread;

public class MessageThreads {


	public static void main(String[] args) throws InterruptedException{

		long timeout = 1000 * 14;
		long startTime = System.currentTimeMillis();
		threadPrint("start time: " + startTime);


		Thread worker = new Thread(new Worker());
		worker.start();
		threadPrint("waiting for working to finish...");

		while (worker.isAlive()){
			threadPrint("still waiting ...");

			// wait for worker to finish, timeout
			worker.join(1000);

			// really tied of waiting
			if ((System.currentTimeMillis() - startTime > timeout) && worker.isAlive()){
				threadPrint("tried ofwaiting ...");
				worker.interrupt();
				worker.join();
			}
		}

		threadPrint("end time: " + System.currentTimeMillis());
	}


	private static void threadPrint(String msg){
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + ":" + msg);

	}

	private static class Worker implements Runnable{

		private static final  String info[] = {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kid will eat ivy too"
        };

		public void run(){
			try{
				for (int i = 0; i < info.length; i++){
					Thread.sleep(5000);
					threadPrint(info[i]);
				}
			}
			catch (InterruptedException e){
				threadPrint("hello, I am not done yet!");
				System.out.println("is this thread interrupted: " + Thread.currentThread().isInterrupted());
				Thread.currentThread().interrupt();
				System.out.println("after interrupt(), is this thread interrupted: " + Thread.currentThread().isInterrupted());
				Thread.currentThread().interrupt();
				System.out.println("after interrupt(), is this thread interrupted: " + Thread.currentThread().isInterrupted());
			}
		}
	}

}
