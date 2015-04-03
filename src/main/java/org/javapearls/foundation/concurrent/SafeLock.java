package org.javapearls.foundation.concurrent;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SafeLock {


	public static void main(String[] args) throws InterruptedException{

		final Friend herry = new Friend("herry");
		final Friend sally = new Friend("sally");

		final SafeLock safeLock = new SafeLock();

		final Controller controller1 = safeLock.new Controller(herry, sally);
		final Controller controller2 = safeLock.new Controller(sally, herry);

		new Thread(controller1).start();
		new Thread(controller2).start();

		Thread.sleep(10000);
		controller1.stop();
		controller2.stop();
	}

	public void foo(){
		System.out.println("i am foo.");
	}


	private final class Controller implements Runnable{

		private volatile boolean stop = false;

		private Friend one;
		private Friend theOther;

		public Controller(Friend here, Friend there){
			this.one = here;
			this.theOther = there;
			foo();
		}

		public void stop(){
			this.stop = true;
		}

		public void run(){
			Random random = new Random();

			while (!stop){
				try{
					Thread.sleep(random.nextInt(2000));
				}catch (InterruptedException e) {}
				one.bow(theOther);
			}
			System.out.println("controller is done");
		}
	}


	static class Friend{

		private final String name;
		private final Lock lock = new ReentrantLock();

		public Friend(String name){
			this.name = name;
		}
		public String getName(){
			return this.name;
		}

		public boolean pendingBow(Friend other){
			boolean myLock = false;
			boolean yourLock = false;
			try{
				myLock = lock.tryLock();
				yourLock = other.lock.tryLock();
			}finally{
				if (!(myLock && yourLock)){
					if (myLock){
						lock.unlock();
					}
					if (yourLock){
						other.lock.unlock();
					}
				}
			}
			return myLock && yourLock;
		}

		public void bow(Friend other){
			if (pendingBow(other)){
				try{
					System.out.format("%s: %s has  bowed to me!%n", this.name, other.getName());
			    	bowBack(this);
				}finally{
					this.lock.unlock();
					other.lock.unlock();
				}

			}else{
				 System.out.format("%s: %s started to bow to me, but saw that"
		                    + " I was already bowing to him.%n",
		                    this.name, other.getName());
			}
		}

		public void bowBack(Friend other){
			 System.out.format("%s: %s has bowed back to me!%n", this.name, other.getName());
		}
	}

}
