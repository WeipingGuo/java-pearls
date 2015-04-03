package org.javapearls.algorithm.sorting;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TestCountingSort {

	@Test
	public void testSortIntArray() {
		int[] a = {6,4,2,5,3,4,7,2,3};
		int[] b = {2,2,3,3,4,4,5,6,7};

		int[] c = CountingSort.sort(a, 2, 7);

		Arrays.sort(a);
		assertTrue(Arrays.equals(b, c));
		assertTrue(Arrays.equals(a, c));
	}

	@Test
	public void testSortIntArrayInt() {

		int[] a = {6,4,2,5,3,4,7,2,3};
		int[] b = {2,2,3,3,4,4,5,6,7};

		int[] c = CountingSort.sort(a, 7);

		assertTrue(Arrays.equals(b, c));
	}

	@Test
	public void testRange(){
		int[] a = {6,4,2,5,3,4,7,2,3};

		int total = CountingSort.range(a, 7, 2, 5);

		System.out.println("total = " + total);

		assertTrue(total == 7);

		int n = 100;
		n = -n;
		System.out.println("n = " + n);

	}

}
