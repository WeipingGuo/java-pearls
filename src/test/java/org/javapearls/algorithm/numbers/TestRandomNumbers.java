package org.javapearls.algorithm.numbers;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRandomNumbers {

	@Test
	public void testRandom() {

		for (int i = 0; i < 10000; i++){
			int a = RandomNumber.random(10);
			assertTrue(a >=0 && a < 10);
		}

	}

	@Test
	public void testRandom01() {

		int totalZero = 0;
		int totalOne = 0;

		for (int i = 0; i < 10000; i++) {
			int a = RandomNumber.random01();

			assertTrue(a == 0 || a == 1);
			if (a == 0){
				totalZero++;
			}else if (a == 1){
				totalOne++;
			}
		}
		System.out.println("total zero: " + totalZero + ",total one:" + totalOne);
	}

	@Test
	public void testRandomOrderedPair(){
		for (int i = 0; i < 50; i++){
			int[] pair = RandomNumber.randomOrderedPair(100);
			System.out.println("ordered pair: " + pair[0] + "," + pair[1]);
		}
	}

}
