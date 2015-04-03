package org.javapearls.algorithm.numbers;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {

	/**
	 * find all the prime up to n(including n)
	 */
	public static List<Integer> findPrimes(int n){

	    List<Integer> res = new ArrayList<Integer>();
	    if (n <= 1) return res;

	    // create a boolean array to track whether a number
	    // is a prime or not
	    boolean[] primeTrack = new boolean[n+1];
	    for (int i = 2; i <= n; i++){
	        primeTrack[i] = true;
	    }

	    int upper = (int)Math.sqrt(n);
	    for (int i = 2; i <= upper; i++){
	        for (int j = i * i; j <= n; j += i){
	            primeTrack[j] = false;
	        }
	    }

	    for (int i = 2; i <= n; i++){
	        if (primeTrack[i] == true){
	            res.add(i);
	        }
	    }

	    return res;

	}


	public static List<Integer> primeFactors(int n){

	    List<Integer> factors = new ArrayList<Integer>();

	    // return an empty list
	    if (n <= 1){
	    	return factors;
	    }

	    // all the prime numbers up to sqrt(n)
		List<Integer> primes = findPrimes((int)Math.sqrt(n));
		for (int i : primes){
			while ( n % i == 0){
				factors.add(i);
				n /= i;
			}
			if (n == 1){
				break;
			}
		}

		// the remaining is a prime number, add to the result
		if (n > 1){
			factors.add(n);
		}

	    return factors;
	}

	public static void primeFactors(int n, List<Integer> factors){

	    // all the prime numbers up to sqrt(n)
		List<Integer> primes = findPrimes((int)Math.sqrt(n));

		for (int i : primes){
			while ( n % i == 0){
				factors.add(i);
				n /= i;
			}
			if (n == 1){
				break;
			}
		}

		// the remaining is a prime number, add to the result
		if (n > 1){
			factors.add(n);
		}
	}

	public static void primeFactor(int n, List<Integer> factors, List<Integer> primes, int primeIndex){

		if (n <= 1) return;

		int prime = primes.get(primeIndex);
		while (n% prime == 0 && n > 1){
			factors.add(prime);
			n /= prime;
		}

		if (n <= 1) return;

		primeFactor(n, factors, primes, ++primeIndex);
	}

}
