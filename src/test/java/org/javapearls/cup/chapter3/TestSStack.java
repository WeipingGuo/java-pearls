package org.javapearls.cup.chapter3;

import static org.junit.Assert.*;


import org.junit.Test;

public class TestSStack {

	@Test
	public void testStackPush() {

		SStack<Integer> stack = new SStack<Integer>();

		stack.push(10);
		assertTrue(stack.size() == 1);
		assertTrue(stack.peek() == 10);

		stack.push(100);
		assertTrue(stack.size() == 2);
		assertTrue(stack.peek() == 100);

		assertTrue(stack.pop() == 100);
		assertTrue(stack.size() == 1);

		assertTrue(stack.pop() == 10);
		assertTrue(stack.size() == 0);


		for (int i = 0; i < 100; i++){
			stack.push(i);
			assertTrue(stack.size() == (i+1));
			assertTrue(stack.peek() == i);
		}

	}

}
