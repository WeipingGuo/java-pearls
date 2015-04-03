package org.javapearls.cup.chapter5;

/**
 * Explain what the following code does: ((n & (n-1)) == 0).
 *
 * @author wguo
 *
 */
public class Question54 {

	/**
	 * Checks if is power of 2.
	 *
	 * @param n the n
	 * @return true, if is power of2
	 */
	public static boolean isPowerOf2(int n){

		if (n < 0){
			throw new IllegalArgumentException("negative integers are not supported.");
		}

		if (n == 0){
			return true;
		}

		return ((n & (n-1)) == 0);
	}


	/**
	 * Bit counts: count how many '1' bit for given integer
	 *
	 * @param n the n
	 * @return the int
	 */
	public static int bitCounts(int n){

		int count = 0;
		while (n > 0){
			count++;
			n >>>= 1;
		}

		return count;
	}

	/**
	 * Return the absolute value of an integer
	 *
	 * @param n the n
	 * @return the int
	 */
	public static int absolute(int n){

		if (n >= 0){
			return n;
		}

		if (n == Integer.MIN_VALUE){
			return ~n;
		}

		return (~n + 1);
	}

}
