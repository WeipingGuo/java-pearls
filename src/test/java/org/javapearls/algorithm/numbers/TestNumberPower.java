package org.javapearls.algorithm.numbers;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class TestNumberPower {

	@Test
	public void testNaiveAlg(){
		assertTrue(NumberPower.power(2, 3) == 8);
		assertTrue(NumberPower.power(3, 2) == 9);
		assertTrue(NumberPower.power(2, 5) == 32);
	}

	@Test
	public void testDivideAlg(){
		assertTrue(NumberPower.powerByDivide(2,3) == 8);
		assertTrue(NumberPower.powerByDivide(3,2) == 9);
		assertTrue(NumberPower.powerByDivide(2,5) == 32);
	}

}
