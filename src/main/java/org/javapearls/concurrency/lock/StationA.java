package org.javapearls.concurrency.lock;

public class StationA extends Station {

	public StationA(WorkItem w) {
		super(w);
	}


	@Override
	protected void doWork() {
		work.A();
	}
}
