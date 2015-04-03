package org.javapearls.algorithm.sorting;


/**
 * select the smallest element
 *
 * @author wguo
 *
 */
public class SelectionSort {


	public static void selectionSort(int[] a){
		if (a.length <= 1){
			return;
		}

		for (int i = 0; i < a.length - 1; i++){
			int smallest = a[i+1];
			int smallestIndex = i + 1;
			int j = i + 2;
			while(j < a.length -1){
				if (a[j] < smallest){
					smallest = a[j];
					smallestIndex = j;
				}
				j++;
			} //while

			if (a[i] > smallest){
				int temp = a[i];
				a[i] = a[smallestIndex];
				a[smallestIndex] = temp;
			}
		}// for

	}

}
