package org.javapearls.concurrency.lock;

public abstract class Station extends Thread {

	protected WorkItem work;

	public Station(WorkItem w){
		this.work = w;
	}

	@Override
	public void run(){
		doWork();
	}

	abstract protected void doWork();

}
