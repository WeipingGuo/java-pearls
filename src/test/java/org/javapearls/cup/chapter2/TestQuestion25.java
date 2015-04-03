package org.javapearls.cup.chapter2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestQuestion25 {

	@Test
	public void testLoopStart() {

		SNode<Integer> s13 = new SNode<Integer>(5, null);
		SNode<Integer> s12 = new SNode<Integer>(4, s13);
		SNode<Integer> s11 = new SNode<Integer>(9, s12);
		SNode<Integer> s10 = new SNode<Integer>(9, s11);
		SNode<Integer> s09 = new SNode<Integer>(9, s10);

		s13.next = s10;
		assertTrue(Question25.loopStart(s09) == s10);

		s13.next = s12;
		assertTrue(Question25.loopStart(s09) == s12);
	}

	@Test
	public void testLoopCheck(){
		SNode<Integer> s13 = new SNode<Integer>(5, null);
		SNode<Integer> s12 = new SNode<Integer>(4, s13);
		SNode<Integer> s11 = new SNode<Integer>(9, s12);
		SNode<Integer> s10 = new SNode<Integer>(9, s11);
		SNode<Integer> s09 = new SNode<Integer>(9, s10);

		s13.next = s10;
		assertTrue(Question25.isCycle(s09));

		s13.next = null;
		assertFalse(Question25.isCycle(s09));
	}

}
