package org.javapearls.foundation.thread.sync;


/**
 *  demo for simple producer-consumer 
 *
 * @author wguo
 *
 */
public class SimpleContainer implements Container {

	private String message;

	private volatile boolean empty = true;

	public synchronized String take(){

		// if empty, wait for it has something read
		while (empty){
			try {
				wait();
			} catch (InterruptedException e) { }
		}

		empty = true;
		notifyAll();
		return message;
	}


	public synchronized void put(String msg){

		while (!empty){
			try{
				wait();
			}catch (InterruptedException e){}
		}

		this.message = msg;
		empty = false;
		notifyAll();
	}

}
