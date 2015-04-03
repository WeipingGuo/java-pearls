package org.javapearls.concurrency.lock;

import java.util.concurrent.Semaphore;

/**
 * The same work instance will be passed to different threads to run.
 * Need make sure A()->B()->C()
 * @author wguo
 *
 */
public class Work implements WorkItem {

	private final Semaphore aSem = new Semaphore(1);
	private final Semaphore bSem = new Semaphore(1);
	private final Semaphore cSem = new Semaphore(1);

	public Work(){
		try {
			aSem.acquire();
			bSem.acquire();
			cSem.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Work is constructed.");
	}

	@Override
	public void A(){
		System.out.println("doing A()...");
		System.out.println("A() is done");
		aSem.release();
	}

	@Override
	public void B(){
		// wait for A to be done
		System.out.println("B() waiting for A() ...");
		try {
			aSem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		aSem.release();

		System.out.println("doing B() ...");
		System.out.println("B() is done.");
		bSem.release();
	}

	@Override
	public void C(){
		// wait for B to be done
		System.out.println("C() waiting for B() ...");
		try {
			bSem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bSem.release();

		System.out.println("doing C() ...");
		System.out.println("C() is done.");
		cSem.release();
	}

}
