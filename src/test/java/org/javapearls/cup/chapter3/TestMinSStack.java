package org.javapearls.cup.chapter3;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestMinSStack {

	@Test
	public void testMinSStack(){

		MinSStack<Integer> mstack = new MinSStack<Integer>();

		mstack.push(10);
		assertTrue(mstack.min() == 10);

		mstack.push(2);
		assertTrue(mstack.min() == 2);

		mstack.push(10);
		assertTrue(mstack.min() == 2);

		assertTrue(mstack.pop() == 10);
		assertTrue(mstack.min() == 2);

		assertTrue(mstack.pop() == 2);
		assertTrue(mstack.min() == 10);

		assertTrue(mstack.pop() == 10);
		assertNull(mstack.min());
		assertNull(mstack.pop());
	}

}
