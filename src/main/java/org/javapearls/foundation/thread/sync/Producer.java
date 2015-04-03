package org.javapearls.foundation.thread.sync;

import java.util.Random;

public class Producer  implements Runnable{

	private static final  String info[] = {
        "Mares eat oats",
        "Does eat oats",
        "Little lambs eat ivy",
        "A kid will eat ivy too"
    };

	private Container container;
	public Producer(Container target){
		this.container = target;
	}

	public void run(){
		Random random = new Random();
		for (int i = 0; i < info.length; i++){
			container.put(info[i]);
			System.out.println("producing: " + info[i]);
			try{
				Thread.sleep(random.nextInt(3000));
			}catch (InterruptedException e){ }
		}

		container.put("DONE");
		System.out.println("producer DONE");
	}
}
