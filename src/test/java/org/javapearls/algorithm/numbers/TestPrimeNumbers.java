package org.javapearls.algorithm.numbers;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TestPrimeNumbers {

	@Test
	public void testPrimeUptoOne(){
		List<Integer> res = PrimeNumbers.findPrimes(1);
		assertTrue(res.isEmpty());
	}

	@Test
	public void testPrimeUptoTwo(){
		List<Integer> res = PrimeNumbers.findPrimes(2);
		assertTrue(res.size() == 1);
		assertTrue(res.get(0) == 2);
	}

	@Test
	public void testPrimeUptoSix(){
		List<Integer> res = PrimeNumbers.findPrimes(6);
		assertTrue(res.size() == 3);
		assertTrue(res.get(0) == 2);
		assertTrue(res.get(1) == 3);
		assertTrue(res.get(2) == 5);
	}

	@Test
	public void testPrimeUptoMiddle(){
		List<Integer> res = PrimeNumbers.findPrimes(14);
		for (int i : res){
			System.out.print(i + ",");
		}
	}

	@Test
	public void testPrimeUptoBig(){
		List<Integer> res = PrimeNumbers.findPrimes(1024);
		assertFalse(res.isEmpty());

		for (Integer i : res){
			System.out.print(i + ",");
		}
	}

	@Test
	public void testPrimeFactors2(){
		List<Integer> factors = PrimeNumbers.primeFactors(2);
		assertTrue(factors.size() == 1);
		assertTrue(factors.get(0) == 2);
	}

	@Test
	public void testPrimeFactors10(){
		int number = 10;
		List<Integer> factors = PrimeNumbers.primeFactors(number);
		System.out.print(number + " = ");
		for (Integer i : factors){
			System.out.print(i + "x");
		}
	}
	@Test
	public void testPrimeFactors100(){
		int number = 100;
		List<Integer> factors = PrimeNumbers.primeFactors(number);
		System.out.print(number + " = ");
		for (Integer i : factors){
			System.out.print(i + "x");
		}
	}

	@Test
	public void testPrimeFactorsBigNumber(){
		int number = Integer.MAX_VALUE/2000;
		List<Integer> factors = PrimeNumbers.primeFactors(number);
		System.out.print(number + " = ");
		for (Integer i : factors){
			System.out.print(i + "x");
		}
	}

}
