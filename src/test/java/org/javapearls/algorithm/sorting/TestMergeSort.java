package org.javapearls.algorithm.sorting;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;


public class TestMergeSort {

	@Test
	public void testMergeSort(){
		int[] a = {10,8,14,7,67,5,20};
		SortingUtil.printArray(a);
		MergeSort.mergeSort(a, 0, a.length - 1);
		SortingUtil.printArray(a);

		int[] b = {5,7,8,10,14,20,67};
		assertTrue(Arrays.equals(a, b));
	}

	@Test
	public void testMergeSortWithHelper(){
		int[] a = {10,8,14,7,67,5,20};
		SortingUtil.printArray(a);
		MergeSort.mergeSort(a);
		SortingUtil.printArray(a);

		int[] b = {5,7,8,10,14,20,67};
		assertTrue(Arrays.equals(a, b));
	}


	@Test
	public void testArrayWithSingleElement(){
		int[] a = {5};
		SortingUtil.printArray(a);
		MergeSort.mergeSort(a, 0, 0);
		SortingUtil.printArray(a);
	}

	@Test
	public void testArrayWithOddElements(){
		int[] a = {5,100,20,7,29,89,56,1,89};
		SortingUtil.printArray(a);
		MergeSort.mergeSort(a, 0, a.length - 1);
		SortingUtil.printArray(a);
		int[] b = {1,5,7,20,29,56,89,89,100};
		assertTrue(Arrays.equals(a, b));
	}

	@Test
	public void testFindSum(){
		int[] a = {5,100,20,7,29,89,56,1,89};
		assertTrue(MergeSort.findSum(a, 105));
		assertTrue(MergeSort.findSum(a, 12));
		assertFalse(MergeSort.findSum(a,500));

		assertFalse(MergeSort.findSum(null, 10000));
	}

	@Test
	public void testFindSumByHash(){
		int[] a = {5,100,20,7,29,89,56,1,89};
		assertTrue(MergeSort.findSum2(a, 105));
		assertTrue(MergeSort.findSum2(a, 12));
		assertFalse(MergeSort.findSum2(a,500));

		assertFalse(MergeSort.findSum2(null, 10000));
	}


}
