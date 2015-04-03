package org.javapearls.algorithm.numbers;

import java.util.BitSet;


/**
 * For a given integer array, elements are from 1 - 10000, however
 * the size of the array is 10001. Please find the duplicated number.
 *
 * @author wguo
 *
 */
public class DuplicatedNumbers {


	/**
	 * Use a BitSet to track the appearance of a number
	 * boolean[] should work too.
	 *
	 * @param a
	 * @return
	 */
	public static int findDup(int[] a){

		BitSet bs = new BitSet(a.length);

		for (int i = 0; i < a.length; i++){
			if (bs.get(a[i])){
				return a[i];
			}
			else {
				bs.set(a[i]);
			}
		}

		throw new IllegalArgumentException("the array contains no duplicated integers");
	}

	/**
	 * Sum all the way
	 * Index: 0 - 9999
	 * Value: 0 - 10000
	 *
	 * @param a
	 * @return
	 */
	public static int findDup2(int[] a){

		long sum = 0;
		for (int i = 0; i < a.length; i++){
			sum += (a[i] - i);
		}

		return (int)sum;
	}

	/**
	 * Use bit operation
	 *
	 * @param a
	 * @return
	 */
	public static int findDup3(int[] a){

		int sum = 0;
		for (int i = 0; i < a.length; i++){
			sum ^= a[i];
			sum ^= i;
		}

		return sum;
	}

	/**
	 * 1+2+3+...+n = n*(n+1)/2
	 * Range: 1 - 10000
	 *
	 * @param a
	 * @return
	 */
	public static int findDup4(int[] a){

		int total = (10000 * (10000+1))>>>1;
		for (int i = 0; i < a.length; i++){
			total -= a[i];
		}
		return (-1) * total;
	}

	/**
	 * Find the duplication using swap
	 *
	 * @param a
	 * @return
	 */
	public static int findDup5(int[] a){

		for (int i = 0; i < a.length; i++){

			// swap the value to its position
			// such as position i holds i+1
			while (a[i] != i+1){

				int tmp = a[a[i]-1];

				// if position a[i] holds the same value
				// we find the duplication.
				if (a[i] == tmp){
					return tmp;
				}
				else {
					a[a[i]-1] = a[i];
					a[i] = tmp;
				}
			}// while
		}

		throw new IllegalStateException("no duplicated numbers are found");
	}


	public static class Pair<E, F>{
		private final E first;
		private final F second;

		public Pair(E e, F f){
			this.first = e;
			this.second = f;
		}

		public E getFirst(){ return this.first; }
		public F getSecond() { return this.second; }

	}

	public static Pair<Integer, Integer> swapByAddtionSubstrction(Integer a, Integer b){
		a = a + b;
		b = a - b;
		a = a - b;

		return new Pair<Integer, Integer>(Integer.valueOf(a), Integer.valueOf(b));
	}

	public static Pair<Integer, Integer> swapByXOR(Integer a, Integer b){
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;

		return new Pair<Integer, Integer>(Integer.valueOf(a), Integer.valueOf(b));
	}

	public static int countOnes(int number){
	    int res = 0;
	    while (number > 0){
	        if ((number & 1) == 1 ){
	            res++;
	        }
	        number >>= 1;
	    }
	    return res;
	}



}
