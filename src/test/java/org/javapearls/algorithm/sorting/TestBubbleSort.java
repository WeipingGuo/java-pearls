package org.javapearls.algorithm.sorting;


import org.junit.Test;

public class TestBubbleSort {

	@Test
	public void testSort() {
		int[] a = {10,8,14,7,67,5,20};
		SortingUtil.printArray(a);
		BubbleSort.sort(a);
		SortingUtil.printArray(a);
	}

}
