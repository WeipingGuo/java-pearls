package org.javapearls.foundation.thread.sync;


public class ProducerConsumerController {

	public static void main(String[] args){

		// Simple container
		System.out.println("TESTING SIMPLE CONTAINER ....");
		Container container = new SimpleContainer();
		Thread t1 =	new Thread(new Producer(container));
		Thread t2 = new Thread(new Consumer(container));
		t1.start();
		t2.start();

		try{
			t1.join();
			t2.join();
		}catch (InterruptedException e){ }


		// Advanced container
		System.out.println("TESTING ADVANCED CONTAINER ...");
		Container container2 = new AdvancedContainer();
		new Thread(new Producer(container2)).start();
		new Thread(new Consumer(container2)).start();
	}
}
