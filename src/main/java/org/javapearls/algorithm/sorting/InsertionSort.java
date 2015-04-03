package org.javapearls.algorithm.sorting;


/**
 * This is an in-place sort algorithm.
 * Loop through the element, and find its position on the sorted
 * left subarray
 *
 * @author wguo
 *
 */
public class InsertionSort {

	public static void sort(int[] a){

		if (a.length <= 1 ){
			return;
		}

		for (int j = 1; j < a.length; j++){
			int key = a[j];
			int i = j -1;

			// insert a[j] into sorted a[0, j-1]
			// find the position where key should be
			while (i >= 0 && a[i] > key){
				a[i+1] = a[i];
				i--;
			}
			a[i+1] = key;
			SortingUtil.printArray(a);
		}
	}

}
