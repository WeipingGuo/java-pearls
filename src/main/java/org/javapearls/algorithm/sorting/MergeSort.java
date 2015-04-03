package org.javapearls.algorithm.sorting;

import java.util.HashMap;


/**
 * Divide and Conquer:
 * Sort left sub-array and right sub-array and merge two sorted array
 *
 * Merge Sort Running Time: O(nlgn)
 *
 * Need additional space for MERGING.
 *
 * @author wguo
 *
 */
public class MergeSort {

	/**
	 * @param a
	 * @param left
	 * @param right
	 */
	public static void mergeSort(int[] a, int left, int right){

		if (right - left <= 0){
			return;
		}

		//int middle = left + (right - left)/2 ;
		int middle = (left + right) >>> 1;
		mergeSort(a, left, middle);
		mergeSort(a, middle+1, right);
		merge(a, left, middle, right);
	}


	/**
	 * Merge two sorted array: a[left, middle] and a[middle+1, right]
	 *
	 *
	 * @param a		-	array
	 * @param left	-	the left index
	 * @param middle -	the middle point
	 * @param right	-	the right index
	 */
	public static void merge(int[] a, int left, int middle, int right){

		// create a new array
		int[] c = new int[right - left + 1];

		int i = left;
		int j = middle +1;
		int k = 0;
		while ( i <= middle && j <= right){
			if (a[i] <= a[j]){
				c[k++] = a[i++];
			}
			else{
				c[k++] = a[j++];
			}
		}

		while (i <= middle){
			c[k++] = a[i++];
		}
		while (j <= right){
			c[k++] = a[j++];
		}

		// copy back to the original array
		for ( int w = 0; w < c.length; w++){
			a[left++] = c[w];
		}
	}


	public static void mergeSort(int[] a){
		int[] helper = new int[a.length];
		mergeSort(a, helper, 0, a.length - 1);
	}

	public static void mergeSort(int[] a, int[] helper, int left, int right){
		if (left >= right) return;

		int middle = (left+right)>>1;
		mergeSort(a, helper, left, middle);
		mergeSort(a, helper, middle + 1, right);
		merge(a, helper, left, middle, right);
	}

	public static void merge(int[] a, int[] helper, int left, int middle, int right){

		// copy over to the helper array
		for (int i = left; i <= right; i++){
			helper[i] = a[i];
		}

		int current = left, i = left, j = middle + 1;
		while (i <= middle && j <= right){
			if (helper[i] <= helper[j]){
				a[current] = helper[i++];
			}else{
				a[current] = helper[j++];
			}
			current++;
		}

		while (i <= middle){
			a[current++] = helper[i++];
		}

		// no need to copy over the right side because it is there already
	}

	// Describe a nlgn algorithm that, given a set S of n integers and another
	// integer x, determines whether or not there exist two elements in S whose sum is
	// exactly x.
	public static boolean findSum(int[] a, int sum){

		if (a == null) return false;
		if (a.length <= 0) return false;

		mergeSort(a, 0, a.length - 1);

		int i = 0;
		int j = a.length - 1;
		while (i < j ){
			if (a[i] + a[j] == sum){
				return true;
			}
			if (a[i] + a[j] > sum){
				j--;
				continue;
			}

			i++;
		}
		return false;
	}

	// find the sum using a hash table
	public static boolean findSum2(int[] a, int sum){
		if (a == null) return false;
		if (a.length == 0) return false;

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for(int i = 0; i <= a.length - 1; i++){
			if (map.get(Integer.valueOf(a[i])) != null){
				return true;
			}
			map.put(Integer.valueOf(sum - a[i]), Integer.valueOf(i));
		}
		return false;
	}


}
