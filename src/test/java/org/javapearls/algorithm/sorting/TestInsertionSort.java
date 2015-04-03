package org.javapearls.algorithm.sorting;

import org.junit.Test;


public class TestInsertionSort {

	@Test
	public void testInsertionSort(){

		int[] a = {10,8,14,7,67,5,20};
		System.out.println("orig array:");
		for (int i = 0; i <= a.length - 1; i++){
			System.out.print(a[i] + ",");
		}
		System.out.println("");

		InsertionSort.sort(a);
		System.out.println("sorted array:");
		for (int i = 0; i <= a.length - 1; i++){
			System.out.print(a[i] + ",");
		}

	}


}
