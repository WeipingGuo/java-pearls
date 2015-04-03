package org.javapearls.algorithm.string;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.Test;

public class TestStrings {

	@Test
	public void testStringSearch(){
		String[] array = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
		int index = Strings.search(array, "ball");
		assertEquals(index, 4);

		String[] array2 = {"at", "", "", "", "ball", "car", "", "", "dad", "", ""};
		index = Strings.search(array2, "ballcar");
		assertEquals(index, -1);
	}

	@Test
	public void testPermutation(){

		Set<String> pu = Strings.permutation("abc");
		assertEquals(pu.size(), 6);
		for (String s : pu){
			System.out.print(s + ",");
		}
		System.out.print("\n");

		pu = Strings.permutation("ab");
		assertEquals(pu.size(), 2);
		for (String s : pu){
			System.out.print(s + ",");
		}
		System.out.print("\n");

		pu = Strings.permutation("abcd");
		assertEquals(pu.size(), 24);
		for (String s : pu){
			System.out.print(s + ",");
		}
		System.out.print("\n");

		pu = Strings.permutation("HELLO");
		assertEquals(pu.size(), 60);
		for (String s : pu){
			System.out.print(s + ",");
		}

	}

	@Test
	public void testPrintPar(){
		Strings.printPar(3);
	}

	@Test
	public void testStringMatch(){
		String a = "1??";
		List<String> all = Strings.match(a);
		assertEquals(all.size(), 4);

		for (String s : all){
			System.out.print(s + ",");
		}
		System.out.println();

		String b = "100?00?00?";
		all = Strings.match(b);
		assertEquals(all.size(), 8);
		for (String s : all){
			System.out.print(s + ",");
		}
		System.out.println();

		String c = "1000111";
		all = Strings.match(c);
		assertEquals(all.size(), 1);
	}


	@Test
	public void testConvert(){
		String orig = "abcde12345";
		String converted = Strings.convert(orig);
		System.out.println("converted string: " + converted);
	}
	
	@Test
	public void testStringTrim(){
	  String s = "         This is a good deal ...    ";
	  String trimed = Strings.trim(s);
	  System.out.println("trimed: " + trimed);
	  assertTrue(trimed.indexOf(' ') == -1);
	}
}
