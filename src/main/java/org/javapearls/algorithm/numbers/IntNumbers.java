package org.javapearls.algorithm.numbers;

import java.math.BigInteger;
import java.util.BitSet;

public class IntNumbers {

	public static void main(String[] args){
		BigInteger number = new BigInteger("+12345678911234567890");
		System.out.println("big integer: " + number.toString());
		System.out.println("bit count: " + number.bitCount());
		System.out.println("bit length:" + number.bitLength());

		BitSet bs = new BitSet();
		bs.set(100);

		System.out.println("100>>6 = " + (100>>6));
		long value = (1L<<100);
		System.out.println("1L<<100 = " + value);
		System.out.println("1L<<100 = " + Long.toBinaryString(value));
		System.out.println("1L<<36  = " + Long.toBinaryString(1L<<36));
		System.out.println("100<<6  = " + (100<<6));
		System.out.println("1L<<101 = " + Long.toBinaryString(1L<<101));
		System.out.println("1L<<37  = " + Long.toBinaryString(1L<<37));

		System.out.println("MAX LONG: " + Long.MAX_VALUE);
		System.out.println("MAX LONG: " + Long.toBinaryString(Long.MAX_VALUE));
		System.out.println("MIN LONG: " + Long.toBinaryString(Long.MIN_VALUE));

		System.out.println("10 = " + int2Binary(10));
		System.out.println("MAX INT = " + int2Binary(Integer.MAX_VALUE));
		System.out.println("MIN INT = " + int2Binary(Integer.MIN_VALUE));
	}

	private static final char[] digits = {'0', '1'};
	public static String int2Binary(int i){

		if (i == 0) return new String("0");

		char[] buf = new char[32];
		int bufPos = 32;
		do{
			buf[--bufPos] = digits[1 & i];
			i >>>= 1;
		}while (i != 0);

		return new String(buf, bufPos, (32-bufPos));
	}

}
