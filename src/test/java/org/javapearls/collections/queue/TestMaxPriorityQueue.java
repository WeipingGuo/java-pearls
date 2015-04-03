package org.javapearls.collections.queue;

import static org.junit.Assert.*;

import java.util.PriorityQueue;

import org.javapearls.collections.queue.Job;
import org.javapearls.collections.queue.MaxPriorityQueue;
import org.junit.Test;

public class TestMaxPriorityQueue {

	MaxPriorityQueue scheduler = new MaxPriorityQueue(10);


	@Test
	public void testSingleElement() {

		Job job = new Job("List directory", 16);
		scheduler.insert(job);

		Job max = scheduler.maximum();
		assertTrue(max.getPriority() == job.getPriority());
		assertTrue(max.getName().equals(job.getName()));

		assertTrue(scheduler.getHeapSize() == 1);

		max = scheduler.extractMax();
		assertTrue(max.getPriority() == job.getPriority());
		assertTrue(max.getName().equals(job.getName()));
		assertTrue(scheduler.getHeapSize() == 0);
	}

	@Test
	public void testInsert() {

		for(int i = 0; i < 10; i++){
			Job job = new Job("Job-" + i, i);
			scheduler.insert(job);
		}
		assertTrue(scheduler.getHeapSize() == 10);

		for (int i = 9; i >= 0; i--){

			Job max = scheduler.maximum();
			assertTrue(max.getPriority() == i);
			assertTrue(max.getName().equals("Job-" + i));

			assertTrue(scheduler.getHeapSize() == i + 1);

			max = scheduler.extractMax();
			assertTrue(max.getPriority() == i);
			assertTrue(max.getName().equals("Job-" + i));
			assertTrue(scheduler.getHeapSize() == i);
		}

	}

	/**
	 * Test
	 */
	@Test
	public void testUtilPriorityQueue(){

		PriorityQueue<String> queue = new PriorityQueue<String>();
		queue.add("one");
		queue.add("two");
		queue.add("four");

		assertTrue(queue.size() == 3);
		assertTrue(queue.peek().equals("four"));

		queue.poll();
		assertTrue(queue.size() == 2);
		assertTrue(queue.peek().equals("one"));
	}


}
