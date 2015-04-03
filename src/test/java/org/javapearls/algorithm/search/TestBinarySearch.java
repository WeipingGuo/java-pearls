package org.javapearls.algorithm.search;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.javapearls.algorithm.sorting.SortingUtil;
import org.junit.Test;

public class TestBinarySearch {

	private int[] a = {7, 8, 10, 14, 20, 67, 100};

	@Test
	public void testSearch() {

		SortingUtil.printArray(a);
		int result = BinarySearch.search(a, 10, 0, a.length - 1);
		assertTrue(result == 2);

		result = BinarySearch.search(a, 500, 0, a.length - 1);
		assertTrue(result == -1);

		assertTrue(BinarySearch.search(a, 100, 0, a.length - 1) == 6);

		result = BinarySearch.binarySearch(a, 100, 0, a.length - 1);
		assertTrue(result == 6);

		assertTrue(BinarySearch.binarySearch(a, 10, 0, a.length - 1) == 2);

		assertTrue(BinarySearch.binarySearch(a, 10) == 2);
	}

	@Test
	public void testOneSideBinarySearch(){
		int[] a = new int[1000];
		for (int i = 0; i < a.length; i++){
			a[i] = i / 10;
		}
		Arrays.sort(a);
		SortingUtil.printArray(a);

		for (int i = 0; i <= 9; i++){
			int index = BinarySearch.oneSideBinarySearch(a, i);
			System.out.println("index of " + i + ":" + index);
		}
	}

	@Test
	public void testSortedMatrixSearch(){
		int[][] image = {{0, 1, 2}, {2, 3, 4}, {5, 6, 7}};
		BinarySearch.Pair pair = BinarySearch.search(image, 3);
		assertTrue(pair.row == 1 && pair.column == 1);
		pair = BinarySearch.search(image, 7);
		assertTrue(pair.row == 2 && pair.column == 2);

		assertTrue(BinarySearch.search(image, 100) == null);

		int[][] a = {{0, 1, 2, 4, 5, 6}, {6, 7, 8, 9, 10, 11}, {12, 12, 12, 12, 13, 15},
				{15, 18, 20, 20, 20, 20, 20}};
		pair = BinarySearch.search(a, 11);
		assertTrue(pair.row == 1 && pair.column == 5);
		pair = BinarySearch.search(a, 18);
		assertTrue(pair.row == 3 && pair.column == 1);
		pair = BinarySearch.search(a, 12);
		System.out.println("row: " + pair.row + ", column:" + pair.column);
		pair = BinarySearch.search(a, 20);
		System.out.println("row: " + pair.row + ", column:" + pair.column);

	}



}
