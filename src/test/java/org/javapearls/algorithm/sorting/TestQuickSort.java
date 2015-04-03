package org.javapearls.algorithm.sorting;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestQuickSort {

	@Test
	public void testQuickSortFirst() {
		int[] a = {10,8,14,7,67,5,20,18};
		SortingUtil.printArray(a);
		QuickSort.quickSortFirst(a, 0, a.length -  1 );
		SortingUtil.printArray(a);
	}

	@Test
	public void testQuickSort() {
		int[] a = {10,8,14,7,67,5,20,18};
		SortingUtil.printArray(a);
		QuickSort.quickSort(a);
		SortingUtil.printArray(a);
	}

	@Test
	public void testPartition() {
		int[] a = {10,8,14,7,67,5,20};
		int p = QuickSort.partitionFirst(a, 0, a.length - 1);
		assertTrue(p == 3);
	}

	@Test
	public void testQuickSortLast() {
		int[] a = {10,8,14,7,67,5,20,7,18};
		SortingUtil.printArray(a);
		QuickSort.quickSortLast(a, 0, a.length -  1 );
		SortingUtil.printArray(a);
	}

	@Test
	public void testQuickSortRandom() {
		int[] a = {10,8,14,7,67,5,20,7,18};
		SortingUtil.printArray(a);
		QuickSort.quickSortRandom(a, 0, a.length -  1 );
		SortingUtil.printArray(a);
	}

}
