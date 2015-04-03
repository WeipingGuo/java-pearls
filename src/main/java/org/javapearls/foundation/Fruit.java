package org.javapearls.foundation;

public enum Fruit {

	APPLE("apple"),
	PEACH("peach"),
	CHERRY("cherry");

	private final String name;

	// the constructor must be private
	Fruit(String name){
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
