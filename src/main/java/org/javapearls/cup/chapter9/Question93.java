package org.javapearls.cup.chapter9;


/**
 * Given a sorted array of n integers that has been rotated
 * an unknown number of times, give an O(log n) algorithm that
 * finds an element in the array. You may assume that the array
 * was originally sorted in increasing order.
 *
 * EXAMPLE:
 * Input: find 5 in array (15 16 19 20 25 1 3 4 5 7 10 14)
 * Output: 8 (the index of 5 in the array)
 *
 * @author wguo
 *
 */
public class Question93 {


	public static int find(int[] array, int target){

		if (array == null || array.length == 0){
			return -1;
		}

		return find(array, 0, array.length - 1, target);
	}

	private static int find(int[] array, int left, int right, int target){

		while (left <= right){

			int middle = (left + right) >> 1;
			if (array[middle] == target){
				return middle;
			}else if (array[left] <= array[middle]){




			}else if (target < array[middle]){

			}else if (target <= array[right]){

			}else {

			}

		}

		return -1;
	}
}
