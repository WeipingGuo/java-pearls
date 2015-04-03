package org.javapearls.datastructure.graph.internal;


public class BipartiteGraph extends Graph {

	private char[] colors = null;
	private boolean isBipartite = true;

	public BipartiteGraph(int totalVertexes, boolean directed) {
		super(totalVertexes, directed);
		colors = new char[totalVertexes + 1];
	}

	public boolean isBipartite(){
		return isBipartite;
	}
	
	public char[] getColors(){
	  return this.colors;
	}

	@Override
	protected void processVertexEarly(int vertex) {
		super.processVertexEarly(vertex);
	}

	@Override
	protected void processVertexLate(int vertex) {
		super.processVertexLate(vertex);
	}

	@Override
	protected void processEdge(int u, int v) {
		super.processEdge(u, v);
	}

}
