package org.javapearls.foundation;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
import java.nio.ByteOrder;

import org.junit.Ignore;
import org.junit.Test;


public class TestOperation {

	@Test
	public void testPrePostIncrement(){

		int k = 2;
		int value = ++k + ++k * ++k;
		assertTrue(value == (3 + 4*5));
		assertTrue(k == 5);

		value = k++ + k++ * k++;
		assertTrue(value == (5 + 6 * 7));
		assertTrue(k == 8);

		// Pre-post increment is the same as x = x + 1, but
		// x is only evaluated once.
		int[] a = {10,10,10};
		int i = 0;
		a[i++] = a[i++] + 1; //a[0] = a[1] + 1;
		assertTrue(a[0] == 11);
		assertTrue(i == 2);
	}

	@Test
	public void testBitOperator(){

//		assertTrue( (10 >> 1) == (10/2));
//		assertTrue( (10 << 3) == (10 * 8));
//		assertTrue( (10 << 1) == (10*2));
//		assertTrue( (11 >> 1) == 5);
//		assertTrue( (-10 >> 1) == -5);
//		assertTrue( (10 >>> 1) == (10/2));

		int length = Integer.MAX_VALUE;
		int middle = (2 + length)/2;
		System.out.println("middle = " + middle);

		int mid2 = (2 + length) >>> 1;
		System.out.println("mid2 = " + mid2);

		System.out.println("Integer.MAX_VALUE:" + Integer.MAX_VALUE);
		System.out.println("Integer.MAX_VALUE + 1: " + (Integer.MAX_VALUE + 1));

		// swap using ^
		int a = 100;
		int b = 10;
		a ^= b;
		b ^= a;
		a ^= b;
	}

	@Test
	public void testMinMaxValues(){
		System.out.println("CHAR MIN_VALUE:" + (int)Character.MIN_VALUE);
		System.out.println("CHAR MAX_VALUE:" + (int)Character.MAX_VALUE);
	}


	@Test
	public void testBitShift(){

		// Is bit shift faster than multiplication?
		int i = 0;
		int m = 1;
		long mstart = System.nanoTime();
		System.out.println("multiplcation start: " + System.nanoTime());
		while (i++ < 1000000){
			m = 50 * 100;
		}
		long mend = System.nanoTime();
		System.out.println("multiplcation used: " +  (mend - mstart) + " nsec");
		System.out.println("multiplication: m = " + m);

		System.out.println("shifting start: " + System.nanoTime());
		long sstart = System.nanoTime();
		i = 0;
		while (i++ < 1000000){
			m = (50<<6) + (50<<5) + (50<<2);
		}
		long send = System.nanoTime();
		System.out.println("shifting used: " +  (send - sstart) + " nsec");
		System.out.println("multiplication: m = " + m);

		assertTrue((mend - mstart) > (send - sstart));
	}


	@Test
	public void testInstanceOf(){

		int[] a = {10};
		assertTrue(a instanceof int[]);

		@SuppressWarnings("rawtypes")
		Class type = a.getClass();
		assertTrue(type.isArray());
	}

	@Test
	public void testCharArrays(){
		String s = "hello";
		char[] t = s.toCharArray();
		t[2] = '\u0000';
		t[3] = '\u0000';
		t[4] = '\u0000';

		System.out.println("Length of t: " + t.length);
	}

	@Test
	public void testBitReverse(){
		int x = 12345;

		String binary = BitwiseOperator.intInBinary(x);
		System.out.println("original integer in binary: " + binary);
		System.out.println("original integer in binary: " + BitwiseOperator.toBinary(x));

		x = BitwiseOperator.reverseBits(x);
		binary = BitwiseOperator.intInBinary(x);
		System.out.println("after reversing in binary: " + binary);
		System.out.println("after reversing in binary: " + BitwiseOperator.toBinary(x));
	}

	@Ignore
	@Test	
	public void testFinally(){
		// finally will NOT be executed if JVM exited inside try block.
		try{
			System.out.println("do nothing but call System.exit");
			System.exit(1);
		}finally{
			System.out.println("finally block is executed.");
		}
	}

	@Test
	public void testReflection(){
		try{
			Class<?> mapClass = Class.forName("java.util.HashMap");
			Method[] methods = mapClass.getMethods();

			for (Method m : methods){
				System.out.println(m.toString());
			}

		}catch(ClassNotFoundException e){

		}
	}

	@Test
	public void testBigEndian(){

		System.out.println("platform byte order: " + ByteOrder.nativeOrder());

		int a = 0x0AA0;
		System.out.println("integer: " + a + ", binary:" + Integer.toBinaryString(a));
		byte b0 = (byte)a;
		byte b1 = (byte)(a >> 8);
		byte b2 = (byte)(a >> 16);
		byte b3 = (byte)(a >> 24);

		System.out.println("b0 = " + b0 + ", b1 = " + b1 + ", b2 = " + b2 + ", b3 = " + b3);

		b0 = int0(a);
		b1 = int1(a);
		b2 = int2(a);
		b3 = int3(a);

		System.out.println("b0 = " + b0 + ", b1 = " + b1 + ", b2 = " + b2 + ", b3 = " + b3);

//		try {
//			Unsafe unsafe = Unsafe.getUnsafe();
//			long l = unsafe.allocateMemory(8);
//			unsafe.putLong(a, 0x0102030405060708L);
//			System.out.println("the long number: " + l);
//			byte b = unsafe.getByte(a);
//			System.out.println("the first byte: " + b);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	private static byte int3(int x) { return (byte)(x >> 24); }
	private static byte int2(int x) { return (byte)(x >> 16); }
	private static byte int1(int x) { return (byte)(x >>  8); }
	private static byte int0(int x) { return (byte)(x >>  0); }

}
