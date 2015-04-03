package org.javapearls.collections.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Scheduler based on PriorityQueue
 *
 * @author wguo
 *
 */
public class JobScheduler {


	private PriorityQueue<Job> queue = null;

	private static final int CAPACITY = 10;

	int value = 100;

	public JobScheduler() {
		JobComparator jobComparator = this.new JobComparator();
		queue = new PriorityQueue<Job>(10, jobComparator);

		// OR
		queue = new PriorityQueue<Job>(10,
				new Comparator<Job>(){
					public int compare(Job o1, Job o2) {
						return 0;
					}
		}
		);

	}

	public void addJob(Job job){
		queue.add(job);
	}
	public Job peek(){
		return queue.peek();
	}
	public Job remove(){
		return queue.remove();
	}
	public int totalJobs(){
		return queue.size();
	}

	// some words about the inner class
	// inner class is used to implement some helper
	// for the below JobComparator, it needs an Scheduler instance,
	// such as this.new JobComparator();
	// it can access the Scheduler's field directly
	//
	// we can add access specifier: public, private, protected.
	// default access: package access
	class JobComparator implements Comparator<Job>{

		public int compare(Job a, Job b) {

			if (a.getPriority() > b.getPriority()){
				return -1;
			}
			if (a.getPriority() < b.getPriority()){
				return 1;
			}

			return 0;
		}
	}

	public static class SampleInnerClass {

		public void accessStaticVariable(){
			System.out.println("queue capacity:" + CAPACITY);
		}

	}

}
