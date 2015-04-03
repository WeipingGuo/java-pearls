package org.javapearls.concurrency.lock;

import org.junit.Test;

public class TestWork {

	@Test
	public void testWorkInOrder(){

		WorkItem work  = new Work();
		Station a = new StationA(work);
		Station b = new StationB(work);
		Station c = new StationC(work);

		b.start();
		c.start();
		a.start();
	}

	@Test
	public void testWorkInOrderCountDown(){

		WorkItem work  = new ExtraWork();
		Station a = new StationA(work);
		Station b = new StationB(work);
		Station c = new StationC(work);

		b.start();
		c.start();
		a.start();
	}

}
