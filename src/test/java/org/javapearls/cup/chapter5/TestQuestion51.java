package org.javapearls.cup.chapter5;


import org.junit.Test;

public class TestQuestion51 {

	@Test(expected=IllegalArgumentException.class)
	public void testIntSubStringIllegalIndex() {
		Question51.intSubString(1234, 23, 42, 5);
	}


	@Test
	public void testIntSubString(){
		int n = 123456;
		int m = 34;
		int s = Question51.intSubString(n, m, 2, 6);

		System.out.println("n=" + Integer.toBinaryString(n));
		System.out.println("m=" + Integer.toBinaryString(m));
		System.out.println("s=" + Integer.toBinaryString(s));

		int w = Question51.updateBits(n, m, 2,6);
		System.out.println("w=" + Integer.toBinaryString(w));
	}

	@Test
	public void testUpdateBits(){

		int n = Integer.parseInt("10000000000", 2);
		int m = Integer.parseInt("10101", 2);
		int s = Question51.intSubString(n, m, 2, 6);

		System.out.println("n=" + Integer.toBinaryString(n));
		System.out.println("m=" + Integer.toBinaryString(m));
		System.out.println("s=" + Integer.toBinaryString(s));

		int w = Question51.updateBits(n, m, 2,6);
		System.out.println("w=" + Integer.toBinaryString(w));
	}

}
