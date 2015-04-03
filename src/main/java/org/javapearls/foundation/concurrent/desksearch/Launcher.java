package org.javapearls.foundation.concurrent.desksearch;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Launcher {

	private static final int QUEUE_CAPACITY = 10;
	private static final int NUM_INDEXER	= 5;

	public static void main(String[] args){

		BlockingQueue<File> queue = new LinkedBlockingQueue<File>(QUEUE_CAPACITY);

		FileFilter filter = new FileFilter(){
			@Override
			public boolean accept(File pathname) {
				return true;
			}
		};

		File[] roots = new File[2];
		roots[0] = new File("C://tools");
		roots[1] = new File("../");

		for (File root : roots){
			new Thread(new FileCrawler(queue, filter, root)).start();
		}
		Thread[] indexers = new Thread[NUM_INDEXER];
		for (int i = 0; i < NUM_INDEXER; i++){
			indexers[i] =new Thread(new Indexer(queue));
			indexers[i].start();
		}

		try{
			Thread.sleep(10000);
		}catch (InterruptedException e){

		}
		// let's stop index
		for (Thread t : indexers){
			t.interrupt();
		}

		// we are done
	}

}
