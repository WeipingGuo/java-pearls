package org.javapearls.concurrency.lock;

import java.util.concurrent.CountDownLatch;

public class ExtraWork implements WorkItem {

	private final CountDownLatch aDone = new CountDownLatch(1);
	private final CountDownLatch bDone = new CountDownLatch(1);

	public ExtraWork(){

	}

	@Override
	public void A(){
		System.out.println("doing A() ...");
		System.out.println("A() is done.");
		aDone.countDown();
	}

	@Override
	public void B(){
		System.out.println("B() is waiting for A()");
		try {
			aDone.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("doing B()...");
		System.out.println("B() is done.");

		bDone.countDown();
	}

	@Override
	public void C(){

		System.out.println("C() is waiting for B()...");
		try {
			bDone.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("doing C() ...");
		System.out.println("C() is done.");
	}

}
