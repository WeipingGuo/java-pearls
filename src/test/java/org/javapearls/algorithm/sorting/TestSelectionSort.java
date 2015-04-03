package org.javapearls.algorithm.sorting;


import org.junit.Test;

public class TestSelectionSort {

	@Test
	public void testSelectionSort() {
		int[] a = {10,8,14,7,67,5,20};
		SortingUtil.printArray(a);
		SelectionSort.selectionSort(a);
		SortingUtil.printArray(a);
	}

}
