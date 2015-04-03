package org.javapearls.concurrency.lock;

public class StationB extends Station {

	public StationB(WorkItem w) {
		super(w);
	}

	@Override
	protected void doWork() {
		work.B();
	}

}
