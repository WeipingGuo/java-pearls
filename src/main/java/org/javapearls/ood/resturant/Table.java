package org.javapearls.ood.resturant;

public class Table {

	private int id;
	private int capacity;

	public Table(int id, int capacity){
		this.id = id;
		this.capacity = capacity;
	}

	public int getId(){
		return this.id;
	}
	public int getCapacity(){
		return this.capacity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacity;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Table other = (Table) obj;
		if (capacity != other.capacity)
			return false;
		if (id != other.id)
			return false;
		return true;
	}

}
