package org.javapearls.datastructure.graph.internal;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * Adjacency list to represent a graph
 *
 * Each vertex is assigned with unique id, from 1 to NUM_VERTEX
 *
 * @author wguo
 *
 */
public class Graph {

	protected final int totalVertexes;
	protected EdgeNode[] edges;			// array contains adjacency list for each vertex
	protected int[] degrees;			// degree info for each vertex
	protected int numEdges = 0;			// current count of number of edges
	protected boolean directed;			// whether the graph is directed or not

	/**
	 * constructor
	 *
	 * @param totalVertexes	total number of vertexes
	 * @param directed directed graph or not
	 */
	public Graph(int totalVertexes, boolean directed){
		this.totalVertexes = totalVertexes;
		this.directed = directed;
		init(totalVertexes);
	}

	/**
	 * add an edge from x to y
	 * @param x	start vertex
	 * @param y	adjacency vertex
	 * @param weight edge weight
	 */
	public void addEdge(int x, int y, int weight){
		if (x < 1 || y < 1 || x > totalVertexes || y > totalVertexes){
			throw new IllegalArgumentException("invalid vertex id");
		}
		this.addEdge(x, y, weight, this.directed);
	}

	/**
	 * Breadth-first search
	 *
	 * @param start starting vertex
	 * @return
	 */
	public int[] bfs(int start){

		// state of each vertex, init to false
		boolean[] processed = new boolean[totalVertexes + 1];
		boolean[] discovered = new boolean[totalVertexes + 1];
		int[] parents = new int[totalVertexes + 1];
		for (int i = 1; i <= totalVertexes; i++){
			processed[i] = discovered[i] = false;
			parents[i] = -1;
		}

		// use queue to store the to-do work
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		discovered[start] = true;

		while (!queue.isEmpty()){
			int u = queue.remove();
			processVertexEarly(u);
			EdgeNode p = this.edges[u];
			while (p != null){
				int v = p.getAdjacency();

				if (!processed[v] || this.directed){
					processEdge(u, v);
				}
				// first time visit the vertex v
				if (!discovered[v]){
					discovered[v] = true;
					queue.add(v);
					parents[v] = u;
				}
				p = p.getNext();
			}
			processVertexLate(u);
			processed[u] = true;
		}
		return parents;
	}

	/**
	 * whether the graph is connected or not
	 */
	public boolean isConnected(){
		return false;
	}

	/**
	 * the number of connected components that this graph contains
	 *
	 * @return
	 */
	public Map<Integer, List<Integer>> connectedComponents(){

		int totalComponents = 0;
		boolean[] discovered = new boolean[totalVertexes + 1];
		Queue<Integer> queue = new LinkedList<Integer>();

		// component map
		Map<Integer, List<Integer>> components = new HashMap<Integer, List<Integer>>();

		for (int i = 1; i <= totalVertexes; i++){
			if (discovered[i]){
				continue;
			}

			totalComponents++;

			// component map
			List<Integer> list = new LinkedList<Integer>();
			components.put(totalComponents, list);

			// bsf traversal
			queue.add(i);
			discovered[i] = true;
			while (!queue.isEmpty()){
				int vertex = queue.poll();
				list.add(vertex);
				EdgeNode p = edges[vertex];
				while (p != null){
					int adj = p.getAdjacency();
					if (!discovered[adj]){
						discovered[adj] = true;
						queue.add(adj);
					}
					p = p.getNext();
				}
			}

		}

		return components;
	}

	public boolean isBipartite(){

		// color: R or B
		char[] colors = new char[totalVertexes + 1];
		boolean[] discovered = new boolean[totalVertexes  + 1];
		boolean[] processed = new boolean[totalVertexes + 1];
		Queue<Integer> queue = new LinkedList<Integer>();

		// BSF starting from 1
		for (int i = 1; i <= totalVertexes; i++){
			if (discovered[i]){
				continue;
			}
			queue.add(i);
			discovered[i] = true;
			colors[i] = 'R';
			while (!queue.isEmpty()){
				int u = queue.poll();
				EdgeNode p = edges[u];
				while (p != null){
					int v = p.getAdjacency();

					// process edge
					if (!processed[v] || directed){
						if (colors[u] == colors[v]){
							return false;
						}
						if (colors[u] == 'R'){
							colors[v] = 'B';
						}else{
							colors[v] = 'R';
						}
					}

					if (!discovered[v]){
						discovered[v] = true;
						queue.add(v);
					}
					p = p.getNext();
				}
				processed[u] = true;
			}
		}
		return true;
	}

	/**
	 * DFS
	 * @param start
	 */
	public void dfs(int start){

		boolean[] discovered = new boolean[totalVertexes + 1];
		boolean[] processed = new boolean[totalVertexes + 1];
		int[] parent = new int[totalVertexes + 1];

		// entry and exit time
		int time = 0;
		int[] entry = new int[totalVertexes + 1];
		int[] exit = new int[totalVertexes + 1];

		// use stack to track the vertex to be processed
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(start);
		discovered[start] = true;

		while (!stack.isEmpty()){

			int vertex = stack.pop();
			entry[vertex] = time++;
			processVertexEarly(vertex);

			EdgeNode p = edges[vertex];
			while (p != null){

				int adj = p.getAdjacency();

				// process edge if needed
				if (!processed[adj] || directed){
					processEdge(vertex, adj);
				}

				if (!discovered[adj]){
					discovered[adj] = true;
					stack.push(adj);
					parent[adj] = vertex;
				}

				p = p.getNext();
			}

			processVertexLate(vertex);
			processed[vertex] = true;
			exit[vertex] = time++;
		}

		// debug
		for (int i = 1; i <= totalVertexes; i++){
			System.out.print(i + ":" + parent[i] + "\t");
		}
		System.out.println();
		for (int i = 1; i <= totalVertexes; i++){
			System.out.print(i + ":" + entry[i] + "," + exit[i] + "\t");
		}
	}


	/**
	 * find path
	 * @param start	starting vertex
	 * @param end	ending vertex
	 * @param parents
	 * @param queue
	 */
	public void findPath(int start, int end, int[] parents, Queue<Integer> queue){
		if (start == end || end == -1){
			queue.add(start);
		}else{
			findPath(start, parents[end], parents, queue);
			queue.add(end);
		}
	}

	public void findPath(int start, int end, int[] parents){
		if (start == end || end == -1){
			System.out.println(start + "\t");
		}else{
			findPath(start, parents[end], parents);
			System.out.println(end + "\t");
		}
	}

	public void findPath(int start, int end, int[] parents, Stack<Integer> stack){
		while (start != end && end != -1){
			stack.add(end);
			end = parents[end];
		}
		stack.add(start);
	}

	protected void processVertexEarly(int vertex){
		System.out.println("processing vertex: " + vertex);

	}
	protected void processVertexLate(int vertex){

	}
	protected void processEdge(int u, int v){
		System.out.println("processing edge:" + u + "->" + v);
	}
	@SuppressWarnings("unused")
	private void processEdge(EdgeNode edge){
		System.out.println("processing edge:" + edge.getStart() + "->" + edge.getAdjacency());
	}

	/**
	 * print out the graph
	 */
	public void print(){
		for (int i = 1; i <= totalVertexes; i++){
			EdgeNode p = edges[i];
			while (p != null){
				System.out.println(p.getStart() + "->" + p.getAdjacency());
				p = p.getNext();
			}
		}
	}

	/**
	 * the total number of edges
	 *
	 * @return
	 */
	public int getNumEdges(){
		return this.numEdges;
	}

	public EdgeNode[] getEdges() {
		return edges;
	}

	public boolean isDirected() {
		return directed;
	}

	public int getTotalVertexes() {
		return totalVertexes;
	}

	/**
	 * the total degree of given vertex
	 *
	 * @param vertex
	 * @return
	 */
	public int getDegree(int vertex){
		if (vertex <1 || vertex > totalVertexes){
			throw new IllegalArgumentException("invalid vertex id");
		}
		return degrees[vertex];
	}

	private void addEdge(int x, int y, int weight, boolean directed){

		EdgeNode edgeNode = new EdgeNode(x, y, weight);
		edgeNode.setNext(this.edges[x]);
		this.edges[x] = edgeNode;
		this.degrees[x]++;

		if (!directed){
			addEdge(y, x, weight, true);
		}else{
			this.numEdges++;
		}
	}


	private void init(int totalVertexes){

		this.edges = new EdgeNode[totalVertexes + 1]; // skip 0
		this.degrees = new int[totalVertexes + 1];
		for (int i = 0; i <= totalVertexes; i++){
			edges[i] = null;
			degrees[i] = 0;
 		}
	}

	public static enum EdgeType{
		TREE("TREE EDGE"),
		BACK("BACK EDGE"),
		FORWARD("FORWARD EDGE"),
		CROSS("CROSS EDGE"),
		NOT_DEFINED("NOT_DEFINED");

		private String name;
		private EdgeType(String name){
			this.name = name;
		}

		public String toString(){
			return this.name;
		}
	}
}
