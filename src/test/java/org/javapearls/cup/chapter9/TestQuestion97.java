package org.javapearls.cup.chapter9;

import java.util.ArrayList;
import java.util.List;

import org.javapearls.cup.chapter9.Question97.Person;
import org.junit.Test;


public class TestQuestion97 {

	@Test
	public void testSorting(){
		Person p1 = new Person(65,100);
		Person p2 = new Person(70,150);
		Person p3 = new Person(56,90);
		Person p4 = new Person(75,190);
		Person p5 = new Person(60,95);
		Person p6 = new Person(65,100);

		List<Person> pList = new ArrayList<Person>();
		pList.add(p1);
		pList.add(p2);
		pList.add(p3);
		pList.add(p4);
		pList.add(p5);
		pList.add(p6);

		for (Person p : pList){
			System.out.print(p.toString() + " ");
		}
		System.out.print("\n");

		Question97.longestTower(pList);

		for (Person p : pList){
			System.out.print(p.toString() + " ");
		}
		System.out.print("\n");

	}


}