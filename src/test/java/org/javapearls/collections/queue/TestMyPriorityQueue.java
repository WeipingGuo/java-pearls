package org.javapearls.collections.queue;

import org.junit.Before;
import org.junit.Test;

public class TestMyPriorityQueue {

	MyPriorityQueue<Integer> myQueue = null;

	@Before
	public void setUp(){
		myQueue = new MyPriorityQueue<Integer>(6);
	}

	@Test
	public void testAddRemoveElement(){
		myQueue.add(4);
		myQueue.print();

		myQueue.add(8);
		myQueue.print();

		myQueue.add(2);
		myQueue.print();

		myQueue.add(9);
		myQueue.print();

		myQueue.add(7);
		myQueue.print();

		myQueue.add(6);
		myQueue.print();

		myQueue.add(5);
		myQueue.print();

		myQueue.add(3);
		myQueue.print();

		System.out.println("removed the smallest element");
		myQueue.remove();
		myQueue.print();

		System.out.println("removed element 6");
		myQueue.remove(6);
		myQueue.print();
	}

}
