package org.javapearls.algorithm.numbers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Fibonacci Number:
 * 		if n = 0, F(n) = 0;
 * 		if n = 1, F(n) = 1;
 * 		otherwise, F(n) = F(n-1) + F(n-2)
 * @author wguo
 *
 */
public class FibonacciNumber {

	public static int naiveAlg(int n){
		if (n == 0) return 0;
		if (n == 1) return 1;
		return naiveAlg(n - 1) + naiveAlg(n - 2);
	}

	public static int buttomUp(int n){
		if (n == 0) return 0;
		if (n == 1) return 1;

		int k = 0;
		int k1 = 1;
		int result = 0;
		for (int i = 2; i <= n; i++){
			result = k + k1;
			k = k1;
			k1 = result;
		}
		return result;
	}

	public static int fibnumber(int x){
		if (x < 0) throw new IllegalArgumentException("negative number does not have fibanico number");
		if (x == 0) return 0;
		if (x == 1) return 1;

		int a = 0, b = 1;
		for (int i = 2; i <= x; i++){
			b = a + b;
			a = b - a;
		}

		return b;
	}

	// Cache the fibonacci number
	private static ArrayList<BigInteger> cache = new ArrayList<BigInteger>();
	static{
		cache.add(BigInteger.ZERO);
		cache.add(BigInteger.ONE);
	}

	public static BigInteger fib(int n){
		if (n > cache.size()){
			cache.add(n, fib(n-1).add(fib(n-2)));
		}
		return cache.get(n);
	}

	/**
	 * How to create a fibonnaci series using only two variables
	 *
	 * Create a fibonnaci number series up to count
	 *
	 * @param count
	 */
	public static int[] fibNumberSeries(int count){

		int[] series = new int[count + 1];
		if (count == 0){
			series[0] = 0;
			return series;
		}
		if (count == 1){
			series[0] = 0;
			series[1] = 1;
			return series;
		}

		series[0] = 0;
		series[1] = 1;

		int a = 0;
		int b = 1;
		for (int i = 2; i <= count; i++){
			b = a + b;
			series[i] = b;
			a = b - a;
		}

		return series;
	}

	/**
	 * Fib series.
	 *
	 * @param size the size
	 * @return the list
	 */
	public static List<BigInteger> fibSeries(int size) {

		List<BigInteger> fibSequence = new ArrayList<BigInteger>();

		BigInteger c0 = BigInteger.ZERO;
		BigInteger c1 = BigInteger.ONE;

		fibSequence.add(c0);
		fibSequence.add(c1);

		for (int i = 2; i <= size; i++) {
			c1 = c0.add(c1);
			c0 = c1.subtract(c0);
			fibSequence.add(c1);
		}

		return fibSequence;
	}

	public static BigInteger fibNumber(int n){
		List<BigInteger> fibSeq = fibSeries(n);

		return fibSeq.get(n);
	}

}
