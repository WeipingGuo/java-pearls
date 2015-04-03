package org.javapearls.concurrency;

/**
 * Demonstrate the usage of 'volatile' keyword
 *
 * @author wguo
 *
 */
public class VolatileDemo extends Thread {

	private volatile boolean stop;

	@Override
	public void run() {

		while (!stop) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void setStop(){
		stop = true;
	}

}
