package org.javapearls.datastructure;

import static org.junit.Assert.*;

import org.javapearls.datastructure.linkedlist.DLinkedList;
import org.junit.After;
import org.junit.Test;

public class TestDLinkedList {

	private static DLinkedList<String>
		linkedList = new DLinkedList<String>();

	@After
	public void cleanup(){
		linkedList.clear();
	}

	@Test
	public void testGetFirst() {
		String s = linkedList.getFirst();
		assertTrue( s == null);

		linkedList.insertHead("Hello");
		linkedList.insertTail("World");
		s = linkedList.getFirst();
		assertTrue("Hello".equals(s));
	}

	@Test
	public void testGetLast() {
		assertTrue(linkedList.getLast() == null);

		linkedList.insertTail("One");
		linkedList.insertTail("Two");
		assertTrue(linkedList.getLast().equals("Two"));
	}

	@Test
	public void testFind() {

		assertTrue(linkedList.find("One") == null);

		linkedList.insertHead("One");
		assertTrue(linkedList.find("One") != null);

		linkedList.remove("One");
		assertTrue(linkedList.find("One") == null);
	}


}
