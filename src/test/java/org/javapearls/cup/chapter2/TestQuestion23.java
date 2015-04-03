package org.javapearls.cup.chapter2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestQuestion23 {

	@Test(expected=IllegalStateException.class)
	public void testDeleteSingleNodeNoNext() {

		SNode<String> s1 = new SNode<String>("one", null);
		Question23.delete(s1);
	}

	@Test
	public void testDeleteSingleNode() {

		SNode<String> s1 = new SNode<String>("one", null);
		SNode<String> s2 = new SNode<String>("two", s1);
		SNode<String> s3 = new SNode<String>("three", s2);
		SNode<String> s4 = new SNode<String>("four", s3);
		SNode<String> s5 = new SNode<String>("five", s4);

		// five -> four -> three -> two -> one
		Question23.delete(s2);
		// five -> four --> three --> one
		assertTrue(s3.next.element.equals("one"));
		assertTrue(s3.next == s2);

		Question23.delete(s4);
		// five --> three --> one
		assertTrue(s5.next.element.equals("three"));
		assertTrue(s5.next == s4);
		assertTrue(s5.next.next == s2);

	}

}
