package org.javapearls.algorithm.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerArray {

	/**
	 * Given an unsorted integer array, find the first missing positive integer.
	 * For example,
	 * Given [1,2,0] return 3,
	 * and [3,4,-1,1] return 2.
	 * and [-3,-4,1,2,6,7] return 3
	 * Your algorithm should run in O(n) time and uses constant space
	 */
	public static int findMissingPositiveInteger(int[] a){

		Arrays.sort(a);

		// skip the negative and zero number
		int i = 0;
		while (a[i] <= 0){
			i++;
		}

		int j = i + 1;
		while (j <= a.length - 1 && a[j] == a[i] + 1){
			i = j;
			j++;
		}

		if (j == a.length){
			return a[j-1] + 1;
		}else{
			return a[i] + 1;
		}
	}

	/**
	 * given integer array containing both positive and negative numbers.
	 * find the continuous sequence with the largest sum
	 *
	 * @return
	 */
	public static int maxSum(int[] array){

		int sum = 0, maxSum = 0;
		for (int i = 0; i < array.length; i++){
			sum += array[i];
			if (sum < 0){
				sum = 0;
			}
			if (sum > maxSum){
				maxSum = sum;
			}
		}

		return maxSum;
	}

	public static List<Integer> maxSumSeq(int[] array){
		int sum = 0, maxSum = 0;
		List<Integer> res = new ArrayList<Integer>();
		List<Integer> tmp = new ArrayList<Integer>();

		for (int i = 0; i < array.length; i++){
			tmp.add(array[i]);
			sum += array[i];
			if (sum < 0){
				sum = 0;
				tmp.clear();
			}

			if (sum > maxSum){
				res.clear();
				maxSum = sum;
				res.addAll(tmp);
			}
		}
		return res;
	}

	public static List<Integer> maxSumSeq2(int[] array){

		int sum = 0, maxSum = 0;
		int left = 0, right = 0, rLeft = 0, rRight;

		for (int i = 0; i < array.length; i++){

			rRight = i;
			sum += array[i];

			if (sum < 0){
				sum = 0;
				rLeft = rRight = i + 1;
			}

			if (sum > maxSum){
				left = rLeft;
				right = rRight;
				maxSum = sum;
			}
		}

		List<Integer> res = new ArrayList<Integer>();
		for (int i = left; i <= right; i++){
			res.add(array[i]);
		}
		return res;
	}

}
