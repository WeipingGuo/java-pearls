package org.javapearls.algorithm.ordering;

public class KthElement {


	/**
	 * find kth smalllest element in an integer array
	 *
	 * @param a
	 * @param k
	 * @return
	 */
	public static int findElement(int[] a, int k){

		if (a == null || a.length == 0){
			throw new IllegalArgumentException("Null or empty array");
		}

		// k cannot be greater than the length of the array
		if (k >= a.length){
			throw new IllegalArgumentException("rank is greater than the total elements in the array.");
		}

		return findElement(a, k, 0, a.length - 1);
	}
	
	
	/**
	 * sorted matrix = each row/column is sorted
	 * e.g.,
	 * 1 6 6
	 * 2 7 7
	 * 2 8 9
	 * 
	 * k=7
	 * remember k=O(n^2) 
	 * 
	 * @param a
	 * @param k
	 * @return
	 */
	public static int findSortedElement(int[][] a, int k){
	  return -1;
	}

	/**
	 * Find the kth smalllest element
	 *
	 * @param a
	 * @param k
	 * @param fromIndex
	 * @param toIndex
	 * @return
	 */
	private static int findElement(int[]a, int k, int fromIndex, int toIndex){

		if (fromIndex == toIndex){
			return a[fromIndex];
		}

		int m = partition(a, fromIndex, toIndex);
		if (m == k){
			return a[m];
		}
		else if (m > k){
			return findElement(a, k, 0, m-1);
		}
		else {
			return findElement(a, k-m, m+1, toIndex);
		}
	}

	/**
	 * Partition an array using the last element as pivot
	 *
	 * @param a
	 * @param fromIndex
	 * @param toIndex
	 * @return
	 */
	private static int partition(int[] a, int fromIndex, int toIndex){

		int pivot = a[toIndex];

		int i = fromIndex - 1;
		int j = fromIndex;
		while (j < toIndex){
			if (a[j] <= pivot){
				swap(a, ++i, j);
			}
			j++;
		}

		a[toIndex] = a[++i];
		a[i] = pivot;
		return i;
	}

	/**
	 * Swap element at i with j
	 * @param a
	 * @param i
	 * @param j
	 */
	private static void swap(int[] a, int i, int j){
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

}
