package org.javapearls.algorithm.dp.basic;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class FibNumber {
	
	private static final Map<Integer, BigInteger> cache = new HashMap<>();
	
	static {
		cache.put(0, BigInteger.ZERO);
		cache.put(1,  BigInteger.ONE);
	}
	
	public static BigInteger fib(int n){
		if (n < 0){
			throw new IllegalArgumentException("invalid input negative number");
		}
		
		BigInteger f = cache.get(n);
		if (f != null){
			return f;
		}
		
		f = fib(n-1).add(fib(n-2));
		cache.put(n, f);
		return f;
	}
	
	public static long fibDp(int n){
		if (n < 0){
			throw new IllegalArgumentException("negative number for fib number");
		}
		if (n == 0) return 0L;
		if (n == 1) return 1L;
		
		long back1 = 1, back2 = 0, next;
		for (int i = 2; i <= n; i++){
			next = back1 + back2;
			back2 = back1;
			back1 = next;
		}
		return (back1 + back2);			
	}

}
