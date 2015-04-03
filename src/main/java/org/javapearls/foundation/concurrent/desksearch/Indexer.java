package org.javapearls.foundation.concurrent.desksearch;

import java.io.File;
import java.util.concurrent.BlockingQueue;

public class Indexer implements Runnable{

	private final BlockingQueue<File> queue;
	private volatile boolean stop = false;

	public Indexer(BlockingQueue<File> queue){
		this.queue = queue;
	}
	public void stop(){
		this.stop =true;
	}

	public void run(){
		while (!stop){
			try{
				indexFile(queue.take());
			}catch (InterruptedException e){
				Thread.currentThread().interrupt();
				stop = true;
			}
		}
		System.out.println(Thread.currentThread().getId() + ": done");
	}

	private void indexFile(File file){
		System.out.println(Thread.currentThread().getId() + ": indexing " + file.toString());
	}

}
