package org.javapearls.algorithm.sorting;

/**
 * All the elements in the array [0, n-1] are in the ranges
 * 0 - k, and k = O(n).
 * Stable sorting
 *
 *
 * @author wguo
 *
 */
public class CountingSort {

	/**
	 * Sort the integer array a, range low - high
	 *
	 * @param a
	 * @param from
	 * @param to
	 */
	public static int[] sort(int[] a, int low, int high){

		int[] b = new int[a.length];
		int[] c = new int[high - low + 1];

		// c[i]: the number of elements of i
		for (int i = 0; i <= a.length - 1; i++){
			c[a[i] - low]++;
		}

		// c[i]: the number of elements <= i
		for (int i = 1; i <= c.length - 1; i++){
			c[i] = c[i - 1] + c[i];
		}

		// find the position of a[j]
		for (int j = a.length - 1; j >= 0; j--){
			b[c[a[j] -low] - 1] = a[j];
			c[a[j]-low]--;
		}
		return b;
	}

	/**
	 * Sort the integer array a, range from 0 - k
	 *
	 * @param a
	 * @param k
	 */
	public static int[] sort(int[] a, int k){

		// allocate storage for final output and counting
		int[] b = new int[a.length];
		int[] c = new int[k+1];

		// c[i]: the number of elements = i
		for (int i = 0; i <= a.length - 1; i++){
			c[a[i]]++;
		}
		SortingUtil.printArray(c);

		// c[i]: the number of elements <= i
		for (int i = 1; i <= c.length - 1; i++){
			c[i] = c[i - 1] + c[i];
		}

		SortingUtil.printArray(c);

		// find the position of a[j]
		// since c[i] contains the number of elements <= i,
		// the final position of a[j] should be c[a[j]] - 1
		for (int j = b.length - 1; j >= 0; j--){
			b[c[a[j]] - 1] = a[j];
			c[a[j]]--;
		}

		return b;
	}

	/*
	 * Describe an algorithm that, given n integers in the range 0 to k, preprocesses its
	 * input and then answers any query about how many of the n integers fall into a
	 * range of [a, b] in O(1)time.
	 */
	public static int range(int[] a, int k, int x, int y){

		int[] c = sort(a,k);

		// find the a[i] >= x
		int i = 0;
		while (c[i] < x && i < c.length){
			i++;
		}

		// count all elements <= y
		int total = 0;
		while(i < c.length && c[i] <= y){
			i++;
			total++;
		}

		return total;
	}

}
