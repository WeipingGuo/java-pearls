package org.javapearls.algorithm.sorting;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TestRadixSort {

	@Test
	public void testGetDigit() {
		assertTrue(RadixSort.getDigit(123, 0) == 3);
		assertTrue(RadixSort.getDigit(123, 1) == 2);
		assertTrue(RadixSort.getDigit(123, 2) == 1);
		assertTrue(RadixSort.getDigit(123, 5) == 0);
	}

	@Test
	public void testTotalDigits(){

		assertEquals(RadixSort.totalDigit(5), 1);
		assertEquals(RadixSort.totalDigit(0), 1);
		assertEquals(RadixSort.totalDigit(-5), 1);

		assertEquals(RadixSort.totalDigit(10), 2);
		assertEquals(RadixSort.totalDigit(123), 3);
	}

	@Test
	public void testRadixSort(){

		int[] a = {111,444,222,888,999,666,333};

		int[] b = Arrays.copyOf(a,a.length);
		RadixSort.sort(a, 3);

		Arrays.sort(b);
		assertTrue(Arrays.equals(a, b));


		int[] x = {123,56,12,1000};
		int[] y = Arrays.copyOf(x, x.length);
		RadixSort.sort(x, 4);

		SortingUtil.printArray(x);

		Arrays.sort(y);
		assertTrue(Arrays.equals(x, y));
	}

}
