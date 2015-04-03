package org.javapearls.cup.chapter5;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestQuestion52 {

	@Test
	public void testToBinaryStringDouble() {

		System.out.println("10.05 = "  + Question52.toBinaryString(10.05));
		System.out.println("100 =" + Question52.toBinaryString(100d));
		System.out.println(Double.MAX_VALUE + "=" + Question52.toBinaryString(Double.MAX_VALUE));
		System.out.println(Double.MIN_VALUE + "=" + Question52.toBinaryString(Double.MIN_VALUE));

		System.out.println("10.05 = "  + Question52.toBinaryString("10.05"));
		System.out.println("10.05 = "  + Question52.printBinary("10.05"));

		System.out.println("3.72 = "  + Question52.printBinary("3.72"));

		System.out.println("3.72 = "  + Question52.doubleToBinaryString(3.72));
		System.out.println("3.72 = "  + Question52.toBinaryString(3.72));

	}

	@Test
	public void testToBinaryStringInt() {

		int value = 9090;
		System.out.println( value + " =: " + Question52.toBinaryString(value));
		System.out.println( value + " =: " + Integer.toBinaryString(value));

		value = -9090;
		System.out.println( value + " =: " + Question52.toBinaryString(value));
		System.out.println( value + " =: " + Integer.toBinaryString(value));

		String jdkWay = Question52.toBinaryStringJDK(value);
		assertEquals(jdkWay, Integer.toBinaryString(value));
	}

}
