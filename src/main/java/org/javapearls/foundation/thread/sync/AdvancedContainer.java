package org.javapearls.foundation.thread.sync;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class AdvancedContainer implements Container{


	private BlockingQueue<String> queue = new LinkedBlockingQueue<String>();

	@Override
	public void put(String msg) {
		queue.add(msg);
	}

	@Override
	public String take() {
		try {
			String msg = queue.take();
			return msg;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

}
