package org.javapearls.datastructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ArrayQuestions {

	/**
	 * given two sorted integer array, find the union of two arrays
	 *
	 * @param a
	 * @param b
	 * @return
	 */
	public static Integer[] union(Integer[] a, Integer[] b){

		if (a == null || a.length == 0) return b;
		if (b == null || b.length == 0) return a;

		List<Integer> res = new ArrayList<Integer>();
		int i = 0, j = 0;
		while (i < a.length && j < b.length){
			if (a[i] == b[j]){
				res.add(a[i++]);
				j++;
			}else if (a[i] < b[j]){
				res.add(a[i++]);
			}else{
				res.add(b[j++]);
			}
		}

		// only one could be true
		while (i < a.length){
			res.add(a[i++]);
		}
		while (j < b.length){
			res.add(b[j++]);
		}

		return res.toArray(new Integer[res.size()]);
	}

	public static Integer[] intersection(Integer[] a, Integer[] b){
		if (a == null || a.length ==0 || b == null || b.length ==0) return null;

		List<Integer> res = new ArrayList<Integer>();
		int i =0, j = 0;
		while (i < a.length && j < b.length){
			if (a[i] == b[j]){
				res.add(a[i++]);
				j++;
			}else if (a[i] < b[j]){
				i++;
			}else{
				j++;
			}
		}

		return res.toArray(new Integer[res.size()]);
	}

	/**
	 * A[] has (n+1) elements, range: (1...n), only one duplicate
	 * @param a
	 * @return
	 */
	public static int findDup(int[] a){
		int sum = 0;
		for (int i = a.length - 1; i >= 0; i--){
			sum += (a[i] - i);
		}
		return sum;
	}
	public static int findDup2(int[] a){
		int sum = 0;
		for (int i = 0; i < a.length; i++){
			sum ^= i;
			sum ^= a[i];
		}
		return sum;
	}

	/**
	 * reorder elements so that negative numbers are before
	 * than positive numbers
	 *
	 * input -5 2 -3 4 -8 -9 1 3 -10
	 * output -5 -3 -8 -9 -10 2 4 1 3
	 * @param array
	 */
	public static void reorder(int[] array){
//
//		int left = 0,  right = array.length - 1;
//
//		while (left <= right){
//
//			while (array[left] < 0){
//				left++;
//			}
//			while (array[right] > 0){
//				right--;
//			}
//
//			while (left <= right){
//				int tmp = array[left];
//				array[left] = array[right];
//				array[right] = tmp;
//				left++;
//				right--;
//			}
//		}
	}


	/**
	 * Given a integer array, test if there is any consequence subarray
	 * which sum of elements is 0.
	 * [7, 1, 1, -2, 3, 4] ==> true [1, 1, -2]
	 *
	 * @param array
	 * @return
	 */
	public static boolean sumZero(int[] array){

		for (int i = 0; i < array.length; i++){
			int sum = 0;
			for (int j = i; j < array.length; j++){
				sum += array[j];
				if (sum == 0){
					return true;
				}
			}
		}

		return false;
	}

	public static boolean sumZero2(int[] array){
		Set<Integer> sumSet = new HashSet<Integer>();
		int sum = 0;
		for (int i = 0; i < array.length; i++){

			sum += array[i];
			if (sumSet.contains(sum)){
				return true;
			}
			else{
				sumSet.add(sum);
			}
		}
		return false;

	}


	/**
	 * given an integer array, return an array each
	 * element is the product of array A except
	 * the element at i.
	 * constraint: no division is allowed
	 * @param a
	 * @return
	 */
	public static int[] tranform(int[] a){

		// define c[i] = a[0]*a[1]*...a[i];
		// define d[i] = a[i]*a[i+1]...a[a.length-1]
		int[] c = new int[a.length];
		int[] d = new int[a.length];
		for (int i = 0; i < a.length; i++){
			c[i] = 1;
			d[i] = 1;
		}

		// calculate the c[i] and d[i]
		c[0] = a[0];
		for (int i = 1; i < a.length; i++){
			c[i] = c[i-1] * a[i];
		}
		System.out.println("C=====");
		print(c);

		d[a.length - 1] = a[a.length-1];
		for (int j = a.length -2; j >= 0; j--){
			d[j]= a[j] * d[j+1];
		}
		System.out.println("D=====");
		print(d);

		// calculate the b[i] = c[i-1] *d[i+1];
		int[] b = new int[a.length];
		b[0] = d[1];
		b[a.length - 1] = c[a.length - 2];
		for (int i = 1; i < a.length - 1; i++){
			b[i]= c[i-1] * d[i+1];
		}

		return b;
	}

	public static int[] transform2(int[] a){
		int[] b = new int[a.length];
		int product = 1;
		for (int i = 0; i < a.length; i++){
			product *= a[i];
		}
		for (int i = 0; i < a.length; i++){
			b[i] = product/a[i];
		}
		return b;
	}

	/**
	 * sort array so that: a1 < a2 > a3 < a4 > a5
	 *
	 * @param a
	 */
	public static void sortEvenOdd(int[] a){

		// sort the array first
		Arrays.sort(a);

		// swap values odd index with even index
		// start from 1
		int i = 1;
		while ( i + 1 < a.length){
			int tmp = a[i+1];
			a[i+1] = a[i];
			a[i] = tmp;
			i += 2;
		}
	}


	/**
	 * find the ocurrance of the given element
	 * using modified binary search
	 * @param a
	 * @return
	 */
	public static int occurance(int[] a, int target){

		Arrays.sort(a);

		int lower = lowerBound(a, target);
		if (lower == -1){
			return 0;
		}
		int upper = upperBound(a, target);

		return upper - lower + 1;
	}

	public static int lowerBound(int[] a, int target){

		int low = 0, high = a.length - 1;
		int index = -1;
		while (low <= high){
			int middle = (low + high) >>> 1;
			if (a[middle] == target){
				index = middle;
				high = middle - 1;
			} else if (a[middle] < target){
				low = middle +1;
			} else {
				high = middle - 1;
			}
		}
		return index;
	}

	public static int upperBound(int[] a, int target){

		int low = 0, high = a.length - 1;
		int index = -1;
		while (low <= high){
			int middle = (low + high) >>> 1;
			if (a[middle] == target){
				index = middle;
				low = middle + 1;
			} else if (a[middle] < target){
				low = middle + 1;
			} else {
				high = middle -1;
			}
		}

		return index;
	}

	/**
	 * remove duplications of String array
	 *
	 * @param array
	 * @return
	 */
	public static List<String> removeDuplicate(List<String> list){

		if (list == null || list.isEmpty()){
			throw new IllegalArgumentException("null or empty list");
		}

		Set<String> set = new HashSet<String>(list);
		return new ArrayList<String>(set);
	}

	public static List<String> removeDuplicationReserveOrder(List<String> list){
		Set<String> set = new LinkedHashSet<>(list);
		return new ArrayList<String>(set);
	}

	public static int find(int[] a){
		int res = 0;
		for (int i = 0; i < a.length; i++){
			res ^= a[i];
		}
		return res;
		
	}
	
	/**
	 * Given three arrays A,B,C containing unsorted numbers. Find three numbers a, 
	 * b, c from each of array A, B, C such that |a-b|, |b-c| and |c-a| are minimum
	 * Please provide as efficient code as you can. 
	 * @param a
	 */
	public static void findMin(int[] a, int[] b, int[] c){
	  
	}
	
	/**
	 * given a sorted array, the value is in the rang of [0, 99], 
	 * print the missing numbers, for example:
	 * input: [0,1,3,50,75]
	 * output: [2,4-49,51-74,76-99]
	 * write test cases
	 * 
	 * @param a
	 * @param max
	 */
	public static void printMissing(int[] a, int max){
	  
	  if (a == null){
	    throw new IllegalArgumentException("null input array");
	  }
	  
	  // empty array
	  if (a.length == 0){
	    System.out.println("0-" + max);
	    return;
	  }
	  
	  int from = 0;
	  for (int i = 0; i < a.length; i++){
	    if (a[i] != from){
	      print(from, a[i]);
	    }
	    from = a[i] + 1;
	  }
	  
	  // print the remaining
	  if (from <= max){
	    print(from, max + 1);
	  }
	  
	}
	
	private static void print(int from, int to){
	  if (from == to - 1){
	    System.out.println(from);
	  } else {
	    System.out.println(from + "-" + (to-1));
	  }
	}

	private static void print(int[] a){
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + ",");
		}
		System.out.println();
		
	}

}
