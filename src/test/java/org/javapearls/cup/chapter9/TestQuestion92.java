package org.javapearls.cup.chapter9;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestQuestion92 {

	@Test
	public void testAnagramSort(){

		List<String> list = new ArrayList<String>();
		list.add("Arrigo Boito");
		list.add("Glen Duncan");
		list.add("Ray Adverb");
		list.add("Declan Gunn");
		list.add("Tobia Gorrio");
		list.add("Dave Barry");

		for (String s : list){
			System.out.print(s  + "\t");
		}
		System.out.print("\n");

		Question92.sort(list);
		for (String s : list){
			System.out.print(s  + "\t");
		}
		System.out.print("\n");
	}

	@Test
	public void testAnagrams(){
		assertTrue(Question92.isAnagrams("Arrigo Boito", "Tobia Gorrio"));

		System.out.println("MAX INT: " + Integer.MAX_VALUE);
	}

}
