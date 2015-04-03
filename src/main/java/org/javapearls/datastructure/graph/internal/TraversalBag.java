package org.javapearls.datastructure.graph.internal;

import java.util.Stack;

public class TraversalBag {

	private final int totalVertexes;
	public final boolean[] discovered;
	public final boolean[] processed;
	public final int[] parent;
	public final int[] entry;
	public final int[] exit;
	public final Stack<Integer> sorted;

	public TraversalBag(int totalVertexes){
		this.totalVertexes = totalVertexes;
		discovered = new boolean[totalVertexes + 1];
		processed = new boolean[totalVertexes + 1];
		parent = new int[totalVertexes + 1];
		entry = new int[totalVertexes + 1];
		exit = new int[totalVertexes + 1];
		sorted = new Stack<Integer>();
		init();
	}
	private void init(){
		for (int i = 1; i <= totalVertexes; i++){
			parent[i] = -1;
		}
	}
	public int getTotalVertexes(){
		return this.totalVertexes;
	}

}
