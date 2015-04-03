package org.javapearls.collections.queue;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestJobScheduler {

	@Test
	public void testAddJob() {
		JobScheduler scheduler = new JobScheduler();
		Job job1 = new Job("job1", 16);
		scheduler.addJob(job1);

		assertTrue(scheduler.totalJobs() == 1);

		Job record = new Job("job1", 16);
		assertTrue(record.equals(scheduler.peek()));
		assertTrue(record.equals(scheduler.remove()));
		assertTrue(scheduler.totalJobs() == 0);
	}

	@SuppressWarnings("unused")
	@Test
	public void testPeek(){
		JobScheduler scheduler = new JobScheduler();

		JobScheduler.JobComparator comp = scheduler.new  JobComparator();
		JobScheduler.SampleInnerClass staticInnerClass = new
			JobScheduler.SampleInnerClass();

		for(int i = 0; i < 100; i++){
			scheduler.addJob(new Job("job" + i, i));
			System.out.println("priority: " + scheduler.peek().getPriority());
		}
	
	}


	@Test
	public void testRemove() {


	}


}
