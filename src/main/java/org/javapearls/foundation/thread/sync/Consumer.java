package org.javapearls.foundation.thread.sync;

import java.util.Random;

public class Consumer  implements Runnable{

	private Container container;

	public Consumer(Container container){
		this.container = container;
	}

	public void run(){
		Random random = new Random();
		do{
			String msg = container.take();
			System.out.println("consuming: " + msg);
			if (msg.equals("DONE")){
				break;
			}
			try{
				Thread.sleep(random.nextInt(5000));
			}catch (InterruptedException e){}

		}while (true);

		System.out.println("consumer is done");
	}
}
