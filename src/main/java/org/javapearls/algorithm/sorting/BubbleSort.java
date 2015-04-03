package org.javapearls.algorithm.sorting;

public class BubbleSort {


	/**
	 * Swap two adjacent numbers
	 *
	 * @param a
	 */
	public static void sort(int[] a){
		for(int i = 0; i <= a.length - 1; i++){
			for (int j = a.length - 1; j > i; j--){
				if (a[j] < a[j-1]){
					swap(a, j, j-1);
				}
			}
			// the smallest element is in a[i]
			SortingUtil.printArray(a);
		}
	}

	private static void swap(int[] a, int i, int j){
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

}
