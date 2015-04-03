package org.javapearls.foundation.thread;

public class Worker implements Runnable{

	public static void main(String[] args){

		Thread w1 = new Thread(new Worker(null));
		Thread w2 = new Thread(new Worker(w1));
		Thread w3 = new Thread(new Worker(w2));

		w1.start();
		w2.start();
		w3.start();

		while (w3.isAlive()){
			System.out.println(Thread.currentThread().getName()  + ": waiting for the all jobs to be done");
			try {
				w3.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println(Thread.currentThread().getName() + " : all done.");
	}

	private Thread other;

	public Worker(Thread other){
		this.other = other;
	}

	@Override
	public void run(){

		String name = Thread.currentThread().getName();

		// wait for other to done
		while (other != null && other.isAlive()){
			System.out.println(name + ": waiting for " + other.getName());
			try {
				other.join();
			} catch (InterruptedException e) {
				System.out.println(name + " is interrupted.");
			}
		}

		System.out.println(name + ": my turn.");
		// do my stuff
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(name + ": done");
	}


}
