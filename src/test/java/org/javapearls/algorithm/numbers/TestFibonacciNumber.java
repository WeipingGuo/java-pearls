package org.javapearls.algorithm.numbers;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.javapearls.algorithm.sorting.SortingUtil;
import org.junit.Test;

public class TestFibonacciNumber {

	@Test
	public void testNaiveAlg() {
		assertTrue(FibonacciNumber.naiveAlg(0) == 0);
		assertTrue(FibonacciNumber.naiveAlg(1) == 1);
		assertTrue(FibonacciNumber.naiveAlg(2) == 1);
		assertTrue(FibonacciNumber.naiveAlg(7) == 13);
	}

	@Test
	public void testButtomUp() {
		assertTrue(FibonacciNumber.buttomUp(0) == 0);
		assertTrue(FibonacciNumber.buttomUp(1) == 1);
		assertTrue(FibonacciNumber.buttomUp(2) == 1);
		assertTrue(FibonacciNumber.buttomUp(7) == 13);
	}

	@Test
	public void testFibDP(){
		assertTrue(FibonacciNumber.fibnumber(0) == 0);
		assertTrue(FibonacciNumber.fibnumber(1) == 1);
		assertTrue(FibonacciNumber.fibnumber(2) == 1);
		assertTrue(FibonacciNumber.fibnumber(7) == 13);
	}

	@Test
	public void testFibNumSeries(){
		int[] a = FibonacciNumber.fibNumberSeries(0);
		SortingUtil.printArray(a);

		a = FibonacciNumber.fibNumberSeries(1);
		SortingUtil.printArray(a);

		a = FibonacciNumber.fibNumberSeries(20);
		SortingUtil.printArray(a);
	}

	@Test
	public void testFibNumber(){
		BigInteger res = FibonacciNumber.fibNumber(100);
		System.out.println(res);

		int[] a = FibonacciNumber.fibNumberSeries(50);
		SortingUtil.printArray(a);
	}

}
