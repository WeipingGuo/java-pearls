package org.javapearls.foundation.polishnotation;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPolishNotation {

	@Test
	public void testPolishNotation(){
		PolishNotation pn = new PolishNotation("-5*67");
		pn.evaluate();
	}

	@Test
	public void testPolishNotationAllPrefix(){
		PolishNotation pn = new PolishNotation("*+234");
		assertEquals(20, pn.evaluate());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testPolishNotationInvalid(){
		new PolishNotation("*5");
	}

	@Test
	public void testComplexPolishNotation(){
		PolishNotation pn = new PolishNotation("++-*+12345+67");
		pn.evaluate();
		//assertEquals(23, result);
	}

	@Test
	public void testComplexPolishNotation2(){
		PolishNotation pn = new PolishNotation("-*/15-7+113+2+11");
		pn.evaluate();
		//assertEquals(-1, result);
	}


	@Test
	public void testPolishNotationSimple(){
		String[] array = {"-", "5", "*", "6", "7"};
		int result = PolishNotation.evaluate(array, 0, array.length - 1);
		assertEquals(result, -37);
	}
	@Test
	public void testPolishNotationSimple2(){
		String[] array = {"*", "+", "2", "3", "4"};
		int result = PolishNotation.evaluate(array, 0, array.length - 1);
		assertEquals(result, 20);
	}
	@Test
	public void testPolishNotationComplex(){
		String[] array = {"-", "*", "/", "15", "-", "7", "+", "1", "1", "3", "+", "2", "+", "1", "1"};
		int result = PolishNotation.evaluate(array, 0, array.length - 1);
		assertEquals(result, 5);
	}
}
