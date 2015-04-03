package org.javapearls.datastructure.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Vertex represents a vertex in a graph.
 * Its neighbors are stored in a set
 *
 * @author wguo
 *
 * @param <K>
 */
public class Vertex<K extends Comparable<K>> {

	private K data;
	private Set<Vertex<K>> neighbors;

	public Vertex(K data){
		this.data = data;
		neighbors = new HashSet<Vertex<K>>();
	}

	/**
	 * add vertex to be the new neighbor
	 *
	 * @param next
	 */
	public void addNeighbor(Vertex<K> next){
		this.neighbors.add(next);
	}

	/**
	 * data associated with the Verex
	 *
	 * @return
	 */
	public K getData(){
		return this.data;
	}

	/**
	 * all its neighbors
	 *
	 * @return
	 */
	public Set<Vertex<K>> getNeighbors(){
		return this.neighbors;
	}

	public void printNeighbors(){
		System.out.print(this.toString() + "-->");
		for (Vertex<K> v : neighbors){
			System.out.print(v.toString() + ",");
		}
		System.out.println();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
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
		@SuppressWarnings("unchecked")
		Vertex<K> other = (Vertex<K>) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (data.compareTo(other.data) != 0)
			return false;
		return true;
	}

	@Override
	public String toString(){
		return data.toString();
	}
}
