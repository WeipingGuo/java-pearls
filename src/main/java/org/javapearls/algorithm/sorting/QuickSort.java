package org.javapearls.algorithm.sorting;

import java.util.Random;

public class QuickSort {


	public static void quickSort(int[] a){
		quickSort(a, 0, a.length - 1);
	}
	public static void quickSort(int[] a, int left, int right){
		if (left >= right) return;

		int p = partition(a, left, right);
		quickSort(a, left, p-1);
		quickSort(a, p, right);
	}

	/**
	 *
	 * @param a
	 * @param left
	 * @param right
	 * @return
	 */
	public static int partition(int[] a, int left, int right){

		int pivot = a[(left + right) >> 1];

		while (left <= right){

			while (a[left] < pivot){
				left++;
			}
			while (a[right] > pivot){
				right--;
			}

			if (left <= right){
				//swap two elments
				swap(a, left, right);
				left++;
				right--;
			}
		}

		// left holds the number > pivot
		return left;
	}


	/**
	 * Partition using the first element as pivot
	 *
	 * @param a
	 * @param left
	 * @param right
	 */
	public static void quickSortFirst(int[] a, int left, int right){
		if (left >= right){
			return;
		}

		int p = partitionFirst(a, left, right);

		// MUST SORT BY p
		// a[p] is the biggest element in the left subarray
		// if splitted by p-1:p, then a[p] is the smallest element
		// in the right subarray. When picked it as the pivot, we cannot
		// partition any more.
		quickSortFirst(a, left, p);
		quickSortFirst(a, p + 1, right);
	}


	/**
	 * Partition an array, and return the pivot index
	 *
	 * @param a
	 * @param left
	 * @param right
	 * @return
	 */
	public static int partitionFirst(int[] a, int left, int right){

		// swap first and last element, then call partition last
		swap(a, left, right);
		return partitionLast(a, left, right);

		// select the first element as the pivot
//		int pivot = a[left];
//
//		int i = left;
//		int j = left + 1;
//		while (j <= right){
//			if (a[j] <= pivot){
//				i++;
//				int t = a[j];
//				a[j] = a[i];
//				a[i] = t;
//			}
//			j++;
//		}
//
//		a[left] = a[i];
//		a[i] = pivot;
//
//		return i;
	}


	public static void quickSortLast(int[] a, int left, int right){
		if (left >= right){
			return;
		}

		int p = partitionLast(a, left, right);

		// MUST SORT BY p-1:
		// Otherwise, the last element on the left side is always
		// the biggest number.
		quickSortLast(a, left, p-1);
		quickSortLast(a, p, right);
	}

	/**
	 * Partition using the pivot as the last element
	 *
	 * @param a
	 * @param left
	 * @param right
	 * @return
	 */
	public static int partitionLast(int[] a, int left, int right){

		int pivot = a[right];

		int i = left - 1;
		int j = left;

		// the left side of i contains all the elements <= pivot
		while (j < right){
			if (a[j] <= pivot){
				i++;
				swap(a, i, j);
			}
			j++;
		}

		// swap the last one with a[i];
		i++;
		a[right] = a[i];
		a[i] = pivot;

		return i;
	}

	public static void quickSortRandom(int[] a, int left, int right){
		if (left >= right) return;

		int p = partionRandom(a, left, right);
		quickSortRandom(a, left, p - 1);
		quickSortRandom(a, p, right);
	}

	public static int partionRandom(int[] a, int left, int right){

		// random select an element
		Random random = new Random();
		int index = left + random.nextInt(right - left + 1);

		// swap with the last element
		swap(a, right, index);
		return partitionLast(a, left, right);
	}


	/**
	 * swap element index at x with y
	 *
	 * @param a
	 * @param x
	 * @param y
	 */
	private static void swap(int[] a, int x, int y){
		int t = a[x];
		a[x] = a[y];
		a[y] = t;
	}

}
