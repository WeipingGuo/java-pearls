package org.javapearls.algorithm.sorting;


import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TestHeapSort {

	@Test
	public void testSort() {
		int[] a = {10,8,14,7,67,5,20};
		int[] b = {10,8,14,7,67,5,20};

		HeapSort helper = new HeapSort();
		helper.sort(a);

		Arrays.sort(b);

		assertTrue(Arrays.equals(a, b));

	}

}
