package org.javapearls.cup.chapter9;

import java.util.Collections;
import java.util.List;


/**
 * A circus is designing a tower routine consisting of people standing
 * atop one another's shoulders. For practical and aesthetic reasons,
 * each person must be both shorter and lighter than the person below him or her.
 * Given the heights and weights of each person in the circus, write a method to
 * compute the largest possible number of people in such a tower.
 * EXAMPLE:
 * Input (ht, wt): (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
 * Output: The longest tower is length 6 and includes from top to bottom: (56, 90)
 * (60,95) (65,100) (68,110) (70,150) (75,190)
 *
 */
public class Question97 {

	public static List<Person> longestTower(List<Person> persons){

		Collections.sort(persons);

		return null;
	}



	public static class Person implements Comparable<Person>{

		int height;
		int weight;
		public Person(int h, int w){
			this.height = h;
			this.weight = w;
		}

		@Override
		public String toString(){
			return "(" + height + ","  + weight + ")";
		}

		@Override
		public int compareTo(Person o) {
			if (this.height == o.height){
				if (this.weight == o.weight){
					return 0;
				}else if (this.weight > o.weight){
					return 1;
				}else{
					return -1;
				}
			}
			if (this.height > o.height){
				return 1;
			}else{
				return -1;
			}
		}
	}

}
