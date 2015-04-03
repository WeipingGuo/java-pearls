package org.javapearls.foundation;

import org.javapearls.foundation.Fruit;
import org.junit.Test;

public class TestEnumeration {

	@Test
	public  void testEnum() {
		Fruit f = Fruit.PEACH;
		System.out.println("name of peach:" + f.getName());


		for(Fruit t : Fruit.values()){
			System.out.println("name: " + t.getName());
		}

		//Fruit w = new Fruit("something else");
	}

}
