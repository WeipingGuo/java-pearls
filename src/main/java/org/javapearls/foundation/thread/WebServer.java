package org.javapearls.foundation.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class WebServer {

	private static final int MAX_THREAD	= 100;
	private static final ExecutorService exec = Executors.newFixedThreadPool(MAX_THREAD);

	private static volatile WebServer instance;

	private WebServer() {}

	public static WebServer getInstance(){
		if (instance == null){
			synchronized(WebServer.class){
				if (instance == null){
					instance = new WebServer();
				}
			}
		}
		return instance;
	}

	public void stop(){
		System.out.println("shut down the server instance.");
		exec.shutdown();

		if (exec.isShutdown()){
			System.out.println("Executor service shut down");
		}
	}

	public void test(){

		for (int i = 0; i < 50; i++){
			System.out.println("creating " + i + " task...");
			Runnable task = new Runnable(){
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getId() + " is running");
				}
			};
			exec.execute(task);
		}
	}

	public long time(int concurrency, final Runnable action){

		System.out.println("running " + concurrency  + " threads  ...");

		final CountDownLatch ready =  new CountDownLatch(concurrency);
		final CountDownLatch done = new CountDownLatch(concurrency);
		final CountDownLatch start = new CountDownLatch(1);

		for (int i = 0; i < concurrency; i++){
			exec.execute(new Runnable(){

				@Override
				public void run() {

					// tell the main thread I am ready
					ready.countDown();
					System.out.println("houston : " + Thread.currentThread().getId() + " is ready.");

					try{
						// wait for the peers to be ready
						start.await();
						action.run();
					}catch (InterruptedException e){
						Thread.currentThread().interrupt();
					}finally{
						// tell the main thread I am done
						System.out.println("houston : " + Thread.currentThread().getId() + " is landed.");
						done.countDown();
					}
				}

			});
		}

		// Here is main thread
		try {
			// wait for all the threads to be ready
			ready.await();

			// all the thread is ready
			long startTime = System.nanoTime();

			System.out.println("let's kick off.");
			start.countDown();

			// wait for all done
			done.await();
			System.out.println("all the threads are done");
			return System.nanoTime() - startTime;
		} catch (InterruptedException e) {
			System.err.println("the main thread is interrupted.");
			Thread.currentThread().interrupt();
		}

		return -1;

		}


	public static class SelfReportTask implements Runnable{

		@Override
		public void run() {
			System.out.println("hi, my id is : " + Thread.currentThread().getId());
		}
	}

}
