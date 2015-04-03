package org.javapearls.algorithm.sorting;


/**
 * Let a[] be an array of n distinct numbers. If i < j and A[i] > A[j], then the
 * the pair of i, j is called an inversion of A.
 *
 * @author wguo
 *
 */
public class Inversion {

	/**
	 * find the total number of inversions for given integer array
	 *
	 * @param a
	 * @return
	 */
	public static int findInversion(int[] a){
		int result = 0;
		for(int i = 0; i <= a.length - 2; i++){
			for (int j = i + 1; j <= a.length -1; j++){
				if (a[j] < a[i]){
					result += 1;
				}
			}
		}
		return result;
	}

	/**
	 * Give an algorithm that determines the number of inversions in any permutation
	 * on n elements in nlgn  worst-case time ((Hint: Modify merge sort.)
	 *
	 */
	public static int inversions(int[] a, int left, int right){

		if (right - left < 1) 	return 0;

		int middle = left + ((right - left) >>> 1);

		System.out.println("middle: " + middle);

		return inversions(a, left, middle) +
			inversions(a, middle + 1, right) +
			inversionMerge(a, left, middle, right);
	}

	public static int inversionMerge(int[] a, int left, int middle, int right){

		int[] c = new int[right - left  + 1];

		int count = 0;

		int i = left;
		int j = middle + 1;
		int k = 0;
		while ( i <= middle && j <= right){
			if (a[i] <= a[j]){
				c[k++] = a[i++];
			}else{
				c[k++] = a[j++];

				// when copy an element from the right sub-array, it creates
				// number of inversions: whatever number elements remaining
				// on the left sub-array
				count += (middle - i + 1);
			}
		}

		while (i <= middle){
			c[k++] = a[i++];
		}
		while (j <= right){
			c[k++] = a[j++];
		}

		// copy the sorted array back to the original
		int r = left;
		for (k = 0; k <= c.length - 1; k++){
			a[r++] = c[k];
		}

		System.out.println("inversion in the merge: " + count);
		return count;
	}
}
