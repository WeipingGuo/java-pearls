package org.javapearls.cup.chapter5;

/**
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j.
 * Write a method to set all bits between i and j in N equal to M
 * (e.g., M becomes a substring of N located at i and starting at j).
 * EXAMPLE:
 * Input:  N = 10000000000, M = 10101, i = 2, j = 6
 * Output: N = 10001010100
 *
 * @author wguo
 *
 */
public class Question51 {


	/**
	 * Int sub string.
	 *
	 * @param n the n
	 * @param m the m
	 * @param i the i
	 * @param j the j
	 * @return the int
	 */
	public static int intSubString(int n, int m, int i, int j){

		// sanity check
		if (i > 31 || j > 31 || i < 0 || j < 0){
			throw new IllegalArgumentException("invalid index.");
		}

		// what if j - i < Integer.toBinaryString(m)?

		// consider N as three parts: left + M + right
		int right = n & ((1<<i) - 1);

		// middle part
		n >>= (j+1);
		n = (n << (j - i + 1)) | m;

		n = (n << i) | right;
		return n;
	}

	/**
	 * Solution from the book.
	 *
	 * @param n the n
	 * @param m the m
	 * @param i the i
	 * @param j the j
	 * @return the int
	 */
	public static int updateBits(int n, int m, int i, int j){

		// all '1's
		int max = ~0;

		// left with '1'
		int left = max - ((1<<j) -1);

		// right with '1'
		int right = ((1<<i) - 1);

		// left with '1', middle '0', and right '1'
		int mask = left | right;

		// clear up the middle
		return (n & mask) | (m << i);
	}

}
