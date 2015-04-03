package org.javapearls.foundation.thread;

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

	@Override
	public void run() {
		try{
			crawl(root);
		}catch (InterruptedException e){
		}
	}

	private void crawl(File root) throws InterruptedException {
		File[] entries = root.listFiles(fileFilter);
		if (entries != null){
			for (File entry : entries){
				if (entry.isDirectory()){
					crawl(entry);
				}else {
					fileQueue.add(entry);
				}
			}
		}

	}

}
