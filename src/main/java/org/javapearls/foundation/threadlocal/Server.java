package org.javapearls.foundation.threadlocal;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * demo the concept of threadlocal
 * 
 * @author wguo
 *
 */
public class Server {

	public static void main(String[] args){

		for (int i = 0; i < 10; i++){
			new Thread(new Worker()).start();
		}

		for (int i = 0; i < 10; i++){
			new Slave().start();
		}

		int max = Integer.MAX_VALUE;
		System.out.println("testing integer overflow ...");
		System.out.println("MAX_INT: " + max  + ", ++MAX_INT: " + ++max);
		System.out.println("++MAX_INT:" + ++max);

		AtomicInteger id = new AtomicInteger(Integer.MAX_VALUE);
		System.out.println("automtic max integer id: " + id.get());
		System.out.println("automtic next id: " + id.incrementAndGet());
	}

	private static class Worker implements Runnable{
		@Override
		public void run() {
			try {
				Thread.sleep(new Random().nextInt(50));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("[" + Thread.currentThread().getId() + "]:" + SessionId.get());
		}
	}

	private static class Slave extends Thread{
		public void run(){
			try {
				Thread.sleep(new Random().nextInt(100));
			} catch (InterruptedException e) {
				System.out.println("hello, i am interrrupted");
				return;
			}
			System.out.println("[" + Thread.currentThread().getId() + "]:" + SessionId.get());
		}
	}

}
