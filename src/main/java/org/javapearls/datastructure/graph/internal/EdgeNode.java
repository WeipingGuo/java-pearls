package org.javapearls.datastructure.graph.internal;

public class EdgeNode {

	private int x;			// start vertex
	private int y; 			// adjacency vertex
	private int weight; 	// edge weight
	private EdgeNode next;

	public EdgeNode(int x, int y){
		this(x, y, y, null);
	}
	public EdgeNode(int x, int y, int weight){
		this(x, y, weight, null);
	}
	public EdgeNode(int x, int y, int weight, EdgeNode next){
		this.x = x;
		this.y = y;
		this.weight = weight;
		this.next = next;
	}
	public void setNext(EdgeNode next){
		this.next = next;
	}
	public void setWeight(int weight){
		this.weight = weight;
	}
	public int getWeight(){
		return this.weight;
	}
	public EdgeNode getNext(){
		return this.next;
	}
	public int getAdjacency(){
		return this.y;
	}
	public int getStart(){
		return this.x;
	}

	public String toString(){
		return x + "--" + weight + "-->"  + y;
	}
}
