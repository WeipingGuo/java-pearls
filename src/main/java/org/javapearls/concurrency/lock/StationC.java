package org.javapearls.concurrency.lock;

public class StationC extends Station {

	public StationC(WorkItem w) {
		super(w);
	}

	@Override
	protected void doWork() {
		work.C();
	}
}
