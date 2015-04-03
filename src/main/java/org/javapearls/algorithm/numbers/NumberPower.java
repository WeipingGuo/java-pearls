package org.javapearls.algorithm.numbers;

public class NumberPower {


	/**
	 * Compute x^n
	 * @param x
	 * @param n
	 * @return
	 */
	public static int power(int x, int n){
		if (n == 0) return 1;

		int result = 1;
		int i = 1;

		while (i <= n){
			result *= x;
			i++;
		}
		return result;
	}

	/**
	 * Divide and Conquer algorithm lgn
	 *
	 * @param x
	 * @param n
	 * @return
	 */
	public static int powerByDivide(int x, int n){
		if (n == 0) return 1;
		if (n == 1) return x;

		if (n % 2 == 0){
			int result = powerByDivide(x, n/2);
			return result * result;
		}
		else{
			int result = powerByDivide(x, (n-1)/2);
			return result * result * x;
		}
	}

}
