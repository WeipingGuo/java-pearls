package org.javapearls.foundation.concurrent.desksearch;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;

public class FileCrawler implements Runnable {

	private final BlockingQueue<File> fileQueue;
	private final FileFilter fileFilter;
	private final File root;

	public FileCrawler(BlockingQueue<File> queue, FileFilter filter, File root){
		this.fileQueue = queue;
		this.fileFilter = filter;
		this.root = root;
	}

	public void run(){
		try{
			crawl(root);
		}catch (InterruptedException e){
			Thread.currentThread().interrupt();
		}
	}

	private void crawl(File root) throws InterruptedException{

		System.out.println(Thread.currentThread().getId() + ": crawling " + root.toString());
		File[] entries = root.listFiles(fileFilter);
		if (entries == null || entries.length < 1){
			return;
		}

		for (File entry : entries){
			if (entry.isDirectory()){
				crawl(entry);
			}else{
				fileQueue.put(entry);
			}
		}
	}
}
