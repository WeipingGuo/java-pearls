package org.javapearls.datastructure;

import static org.junit.Assert.*;

import org.javapearls.datastructure.linkedlist.SLinkedList;
import org.junit.After;
import org.junit.Test;

public class TestSLinkedList {

	private static SLinkedList<String> sList =
		new SLinkedList<String>();


	@After
	public void clear(){
		sList.clear();
	}

	@Test
	public void testAddHeader() {
		sList.addHeader("One");
		assertTrue("One".equals(sList.getFirst()));
		assertTrue("One".equals(sList.getLast()));
		assertTrue(sList.getSize() == 1);

		sList.addHeader("Two");
		assertTrue("Two".equals(sList.getFirst()));
		assertTrue("One".equals(sList.getLast()));
		assertTrue(sList.getSize() == 2);
	}

	@Test
	public void testAddTail() {
		sList.addTail("One");
		assertTrue("One".equals(sList.getFirst()));
		assertTrue("One".equals(sList.getLast()));
		assertTrue(sList.getSize() == 1);

		sList.addTail("Two");
		assertTrue("One".equals(sList.getFirst()));
		assertTrue(sList.getSize() == 2);
	}

	@Test
	public void testRemove() {

		sList.addTail("One");
		assertTrue("One".equals(sList.getFirst()));
		assertTrue("One".equals(sList.getLast()));
		assertTrue(sList.getSize() == 1);

		sList.addTail("Two");

		sList.remove("One");
		assertTrue(sList.getSize() == 1);

		sList.remove("Two");
		assertTrue(sList.getSize() == 0);
	}
}
