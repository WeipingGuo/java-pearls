package org.javapearls.foundation.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

@SuppressWarnings("unused")
public class H2O {

	private BlockingQueue<CountDownLatch> hq =
		new LinkedBlockingQueue<CountDownLatch>();
	private BlockingQueue<CountDownLatch> oq =
		new LinkedBlockingQueue<CountDownLatch>();

	public H2O h(){

		// do we have another H and O
		CountDownLatch h = new CountDownLatch(1);
		hq.add(h);
		try {
			h.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}

	public H2O o(){

		// do we have two H

		while (true) {
			try {
				CountDownLatch first = hq.take();
				CountDownLatch second = hq.poll();
				if (second == null) {
					hq.add(first);
					continue;
				}

				first.countDown();
				second.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return this;
		}
	}

}
