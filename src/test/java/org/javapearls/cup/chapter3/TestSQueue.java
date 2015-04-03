package org.javapearls.cup.chapter3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;


public class TestSQueue {


	@Test
	public void testSimpleQueue(){

		SQueue<String> q = new SQueue<String>();

		q.enqueue("one");
		assertFalse(q.isEmpty());

		assertEquals(q.dequeue(), "one");
		assertTrue(q.isEmpty());

		q.enqueue("one");
		q.enqueue("two");
		q.enqueue("three");

		assertEquals(q.dequeue(), "one");
		assertEquals(q.dequeue(), "two");
		assertEquals(q.dequeue(), "three");
		assertTrue(q.isEmpty());

		ArrayList<String> array = new ArrayList<String>();
		array.add("one");
		array.add("two");
		array.add("three");
		array.add("four");

		Iterator<String> it = array.iterator();
		while (it.hasNext()){
			System.out.println(it.next());
			it.remove();
		}
	}

}
