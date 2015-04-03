package org.javapearls.algorithm.search;

public class BinarySearch {

	/**
	 * Find x in a sorted array
	 *
	 * @param a	- array
	 * @param x	- element to be found
	 * @param left	- left index
	 * @param right	- right index
	 * @return	the index which matches x; -1 if not found
	 */
	public static int search(int[] a, int x, int left, int right){

		if (left == right){
			if (a[left] == x){
				return left;
			}
			else{
				return -1;
			}
		}

		// int middle = left + (right - left)/2;
		int middle = (left + right) >>> 1;

		if (a[middle] > x){
			return search(a, x, left, middle - 1);
		}else if (a[middle] < x){
			return search(a, x, middle + 1, right);
		}else{
			return middle;
		}
	}

	public static int binarySearch(int[] a, int key){
		return binarySearch(a, key, 0, a.length - 1);
	}

	public static int binarySearch(int[] a, int key, int fromIndex, int toIndex){

		int low = fromIndex;
		int high = toIndex;

		while (low <= high){

			// if we write as (low + high)/2, it could be some overflow issue
			// when (low + high) > Integer.MAX_VALUE
			// int length = Integer.MAX_VALUE;
			// int middle = (2 + length)/2;	 	// -1073741823
			// int mid2 = (2 + length) >>> 1; 	// 1073741824
			int middle = low + ((high - low ) >>> 1);
			if (a[middle] < key){
				low = middle + 1;
			}
			else if (a[middle] > key){
				high = middle -1;
			}
			else{
				// found the value
				return middle;
			}
		}

		return -(low + 1);
	}


	/**
	 *
	 * one side binary search, assume the length of array is unknown
	 *
	 * @param a 	sorted array
	 * @param key
	 * @return
	 */
	public static int oneSideBinarySearch(int[] a, int key){

		int low = 0, high = 1;
		if (a[low] == key){
			return low;
		}
		if (a[high] == key){
			return high;
		}
		if (a[low] > key){ // not found
			return -1;
		}

		while (a[high] < key){
			low = high + 1;
			high = ((high + 1) << 1) - 1;
		}

		// do the binary search the range low, high
		return binarySearch(a, key, low, high);
	}

	public static class Pair{
		public int row;
		public int column;
		public Pair(int row, int column){
			this.row = row;
			this.column = column;
		}
	}

	/**
	 *  given matrix, sorted on each row, first element of next row is larger(or
	 *  equal) to the last element of previous row, now giving a target number,
	 *  returning the position that the target locates within the matrix
	 * @param a
	 * @param target
	 * @return
	 */
	public static Pair search(int[][] a, int target){

		int rows = a.length, columns = a[0].length;

		// find the target row using binary search
		int low = 0, high = rows - 1;
		int targetRow = -1;
		while (low <= high){
			int middle = (low + high) >>> 1;
			if (a[middle][0] <= target && a[middle][columns - 1] >= target){
				targetRow = middle;
				break;
			} else if (a[middle][0] > target){
				high = middle - 1;
			} else if (a[middle][columns-1] < target){
				low = middle + 1;
			}
		}

		// not found
		if (targetRow == -1){
			return null;
		}

		// binary search the target row
		low = 0;
		high = columns - 1;
		while (low <= high){
			int middle = (low + high) >>> 1;
			if (a[targetRow][middle] == target){
				return new Pair(targetRow, middle);
			} else if (a[targetRow][middle] < target){
				low = middle + 1;
			} else {
				high = middle - 1;
			}
		}

		// not found
		return null;
	}

}
