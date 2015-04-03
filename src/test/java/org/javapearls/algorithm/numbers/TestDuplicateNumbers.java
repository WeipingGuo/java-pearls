package org.javapearls.algorithm.numbers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestDuplicateNumbers {

	private static int[] a = new int[10001];

	@Before
	public void initArray(){
		for (int i = 0; i < a.length - 1; i++){
			a[i] = i + 1;
		}
		a[a.length - 1] = 3333;

	}

	@Test
	public void testFindDup() {
		int dup = DuplicatedNumbers.findDup(a);
		assertEquals(dup, 3333);
	}

	@Test
	public void testFindDup2() {
		int dup = DuplicatedNumbers.findDup2(a);
		assertEquals(dup, 3333);

		int[] b = {1,2,2,3};
		dup = DuplicatedNumbers.findDup2(b);
		assertEquals(dup, 2);
	}

	@Test
	public void testFindDup3() {
		int dup = DuplicatedNumbers.findDup3(a);
		assertEquals(dup, 3333);
	}

	@Test
	public void testFindDup4(){
		int dup = DuplicatedNumbers.findDup4(a);
		assertEquals(dup, 3333);
	}

	@Test
	public void testFindDup5(){
		int dup = DuplicatedNumbers.findDup5(a);
		assertEquals(dup, 3333);
	}

	@Test
	public void testSwapNumberByAddtionSubstraction(){
		Integer a = Integer.valueOf(10);
		Integer b = Integer.valueOf(100);

		DuplicatedNumbers.Pair<Integer, Integer> result =
			DuplicatedNumbers.swapByAddtionSubstrction(a, b);
		assertTrue(result.getFirst() == 100);
		assertTrue(result.getSecond() == 10);
	}

	@Test
	public void testSwapByXOR(){
		int a = 100;
		int b = 10;

		DuplicatedNumbers.Pair<Integer, Integer> result =
			DuplicatedNumbers.swapByXOR(a, b);
		assertTrue(result.getFirst() == 10);
		assertTrue(result.getSecond() == 100);
	}

	@Test
	public void testCountOnes(){
		assertTrue(DuplicatedNumbers.countOnes(0) == 0);
		assertTrue(DuplicatedNumbers.countOnes(8) == 1);

		assertTrue(DuplicatedNumbers.countOnes(32) == 1);

		assertTrue(DuplicatedNumbers.countOnes(31) == 5);

	}

}
