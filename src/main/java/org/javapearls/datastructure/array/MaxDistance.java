package org.javapearls.datastructure.array;


/**
 * Given an int array A[], define: distance=A[i]+A[j]+(j-i), j>=i)
 * Find max distance in A[]?
 *
 * @author wguo
 *
 */
public class MaxDistance {

	/**
	 * A[i] + A[j] + j - i ===> (A[i] - i) + (A[j] + j)
	 *
	 * @param a
	 * @return
	 */
	public static int maxDistance(int[] a){

		if (a == null || a.length == 0) {
			return 0;
		}


		int[] rightMax = new int[a.length]; 	// the right max of A[j] + j (including j)
		int max = rightMax[a.length - 1] = a[a.length - 1] + a.length - 1;
		for (int j = a.length - 2; j >= 0; j--){
			if (a[j] + j > max){
				max = a[j] + j;
			}
			rightMax[j] = max;
		}

		int[] leftMax = new int[a.length]; 		// the left max of A[i] - i (including i)
		max = leftMax[0] = a[0] - 0;
		for (int i = 1; i < a.length; i++){
			if (a[i] - i > max){
				max = a[i] - i;
			}
			leftMax[i] = max;
		}

		// the maximum distance
		int maxDistance = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++){
			maxDistance = Math.max(maxDistance, leftMax[i] + rightMax[i]);
		}

		return maxDistance;
	}

	/**
	 * THE GREEY SOLUTION IS INCORRECT!!!
	 *
	 * @param a
	 * @return
	 */
	public static int maxDistance2(int[] a){

		int maxDistance = Integer.MIN_VALUE;
		for (int low = 0, high = a.length-1; low <= high; ){
			maxDistance = Math.max(maxDistance, a[low] - low + a[high] + high);
			if (a[low] - low < a[high] + high){
				low++;
			}else{
				high--;
			}
		}
		return maxDistance;
	}


	public static int trap(int[] a){

		if (a == null || a.length == 0){
			return 0;
		}

		int[] leftMax = new int[a.length];
		int[] rightMax = new int[a.length];
		leftMax[0] = 0;
		int max = a[0];

		// maximum on the left of i
		for (int i = 1; i < a.length; i++){
			leftMax[i] = max;
			if (max < a[i]){
				max = a[i];
			}
		}

		// maximum on the right of i
		max = a[a.length - 1];
		for (int j = a.length - 2; j >= 0; j--){
			rightMax[j] = max;
			if (a[j] > max){
				max = a[j];
			}
		}

		int total = 0;
		for (int i = 1; i < a.length - 1; i++){
			int trap = Math.min(leftMax[i], rightMax[i]) - a[i];
			if (trap > 0){
				total += trap;
			}
		}

		return total;
	}


	public static int secondMax(int[] a){

		if (a == null || a.length == 0){
			throw new IllegalArgumentException("null or empty array");
		}

		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++){
			if (a[i] > max){
				secondMax = max;
				max = a[i];
			}else if (a[i] > secondMax && a[i] < max){
				secondMax = a[i];
			}
		}

		return secondMax;
	}

}
