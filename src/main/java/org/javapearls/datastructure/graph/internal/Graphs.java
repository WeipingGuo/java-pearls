package org.javapearls.datastructure.graph.internal;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Graphs {


	public static void dfs(Graph g, int start){

		int totalVertexes = g.getTotalVertexes();

		TraversalBag bag = new TraversalBag(totalVertexes);

		int time = 0;

		dfs(g, start, bag, time);

		// debug
		for (int i = 1; i <= totalVertexes; i++){
			System.out.print(i + ":" + bag.parent[i] + "\t");
		}
		System.out.println();
		for (int i = 1; i <= totalVertexes; i++){
			System.out.print(i + ":" + bag.entry[i] + "," + bag.exit[i] + "\t");
		}
	}

	public static void bfs(Graph g, int start){

		int totalVertexes = g.getTotalVertexes();
		TraversalBag data = new TraversalBag(totalVertexes);

		EdgeNode[] edgeNodes = g.getEdges();

		// use queue to track to-do work
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		data.discovered[start] = true;
		while (!queue.isEmpty()){
			int vertex = queue.poll();
			processVertexEarly(vertex, data);
			EdgeNode p = edgeNodes[vertex];
			while (p != null){
				int adj = p.getAdjacency();
				if (!data.processed[adj] || g.isDirected()){
					processEdge(vertex, adj, data);
				}
				if (!data.discovered[adj]){
					data.discovered[adj] = true;
					data.parent[adj] = vertex;
					queue.add(adj);
				}
				p = p.getNext();
			}
			processVertexLate(vertex, data);
			data.processed[vertex] = true;
		}
	}

	public static void bfs(Graph g, int start, TraversalBag data){

		EdgeNode[] edgeNodes = g.getEdges();

		// use queue to track to-do work
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		data.discovered[start] = true;
		while (!queue.isEmpty()){
			int vertex = queue.poll();
			processVertexEarly(vertex, data);
			EdgeNode p = edgeNodes[vertex];
			while (p != null){
				int adj = p.getAdjacency();
				if (!data.processed[adj] || g.isDirected()){
					processEdge(vertex, adj, data);
				}
				if (!data.discovered[adj]){
					data.discovered[adj] = true;
					data.parent[adj] = vertex;
					queue.add(adj);
				}
				p = p.getNext();
			}
			processVertexLate(vertex, data);
			data.processed[vertex] = true;
		}
	}

	/**
	 * check the total number of connected components
	 *
	 * @param g
	 * @return
	 */
	public static int totalConnectedComponents(Graph g){

		int components = 0;

		int totalVertexes = g.getTotalVertexes();
		TraversalBag bag = new TraversalBag(totalVertexes);
		// bfs
		for (int i = 1; i <= totalVertexes; i++){
			if (bag.discovered[i]){
				continue;
			}
			components++;
			bfs(g, i, bag);
		}
		return components;
	}

	/**
	 * 1. for the original graph, bsf from 1, all the vertexes
	 *    have to be reachable
	 * 2. construct G', do bsf from 1
	 *
	 * @param g
	 * @return
	 */
	public static boolean isStronglyConnected(Graph g){

		if (!g.isDirected()){
			throw new IllegalArgumentException("strongly connected components are only for directed graph");
		}

		int totalVertexes = g.getTotalVertexes();
		TraversalBag bag = new TraversalBag(totalVertexes);
		bfs(g, 1, bag);
		for (int i = 1; i <= totalVertexes; i++){
			if (!bag.discovered[i]){
				return false;
			}
		}

		// construct G'
		Graph graph = reflect(g);
		graph.print();
		TraversalBag newBag = new TraversalBag(totalVertexes);
		bfs(graph, 1, newBag);
		for (int i = 1; i <= totalVertexes; i++){
			if (!newBag.discovered[i]){
				return false;
			}
		}

		return true;
	}


	/**
	 * construct a reflection of a graph. reverse the original edge.
	 *
	 * @param g
	 * @return
	 */
	public static Graph reflect(Graph g){

		int totalVertexes = g.getTotalVertexes();
		Graph newGraph = new Graph(totalVertexes, g.directed);

		EdgeNode[] edgeNodes = g.getEdges();
		for (int i = 1; i <= totalVertexes; i++){
			EdgeNode p = edgeNodes[i];
			while (p != null){
				newGraph.addEdge(p.getAdjacency(), i, p.getWeight());
				p = p.getNext();
			}
		}
		return newGraph;
	}



	/**
	 * toplogical sort on DAG
	 *
	 * @param g
	 */
	public static void topSort(Graph g){

		// sanity check
		if (!g.isDirected()){
			throw new IllegalArgumentException("cannot perform topological sort on undirected graph");
		}

		int totalVertexes = g.getTotalVertexes();
		TraversalBag bag = new TraversalBag(totalVertexes);
		int time = 0;

		// go through each vertex
		for (int i = 1; i <= totalVertexes; i++){
			if (bag.discovered[i]){
				continue;
			}
			dfs(g, i, bag, time);
		}

		// print out the topological sorting order
		while (!bag.sorted.isEmpty()){
			System.out.print(bag.sorted.pop() + "-->");
		}

	}

	/**
	 * minimum spanning tree: Prim Alg
	 *
	 * @param g
	 * @param start
	 */
	public static void mstPrim(Graph g, int start){

		int totalVertexes = g.getTotalVertexes();

		// keep track whether each vertex is in tree or not
		boolean[] intree = new boolean[totalVertexes + 1];

		// distance to add the vertex
		int[] distance = new int[totalVertexes + 1];

		// parent of each vertex
		int[] parent = new int[totalVertexes + 1];

		// init
		for (int i = 1; i <= totalVertexes; i++){
			intree[i] = false;
			distance[i] = Integer.MAX_VALUE;
			parent[i] = -1;
		}

		int v = start; 		// current the vertex
		int w;				// candidate of next vertex
		int weight;			// edge weight
		int dist;			// best distance from the start

		// start from 'start'
		distance[v] = 0;
		while (!intree[v]){
			System.out.println("adding " + v + " to the tree.");
			intree[v] = true;
			EdgeNode p = g.getEdges()[v];
			while (p != null){
				weight = p.getWeight();
				w = p.getAdjacency();
				if (distance[w] > weight && !intree[w]){
					distance[w] = weight;
					parent[w] = v;
				}
				p = p.getNext();
			}

			// select the next vertex
			dist = Integer.MAX_VALUE;
			for (int i = 1; i <= totalVertexes; i++){
				if (!intree[i] && dist > distance[i]){
					dist = distance[i];
					v = i;
				}
			}
		}

		// print out the parent
		for (int i = 1; i <= totalVertexes; i++){
			if (parent[i] == -1) continue;
			System.out.println(parent[i] + "--" + i);
		}
	}

	public static void mstKruskal(Graph g, int start){

		int totalVertexes = g.getTotalVertexes();

		// sort the edge based on its weight
		PriorityQueue<EdgeNode> queue =
			new PriorityQueue<EdgeNode>(totalVertexes, new EdgeNodeComparator());
		EdgeNode[] edgeNodes = g.getEdges();
		for (int i = 1; i <= totalVertexes; i++){
			EdgeNode p = edgeNodes[i];
			while (p != null){
				queue.add(p);
				p = p.getNext();
			}
		}

		SetUnion union = new SetUnion(totalVertexes);
		while (!queue.isEmpty()){
			EdgeNode edgeNode = queue.poll();
			int x = edgeNode.getStart();
			int y = edgeNode.getAdjacency();
			if (!union.sameComponents(x, y)){
				System.out.println(edgeNode.toString() + " is part of MST");
				union.union(x, y);
			}
		}
	}

	/**
	 * the shortest paths
	 *
	 * @param g
	 * @param start
	 */
	public static void dijkstra(Graph g, int start, int end){

		int totalVertexes = g.getTotalVertexes();

		// keep track whether each vertex is in tree or not
		boolean[] intree = new boolean[totalVertexes + 1];

		// distance to add the vertex
		int[] distance = new int[totalVertexes + 1];

		// parent of each vertex
		int[] parent = new int[totalVertexes + 1];

		// init
		for (int i = 1; i <= totalVertexes; i++){
			intree[i] = false;
			distance[i] = Integer.MAX_VALUE;
			parent[i] = -1;
		}

		int v = start; 		// current the vertex
		int w;				// candidate of next vertex
		int weight;			// edge weight
		int dist;			// best distance from the start

		// start from 'start'
		distance[v] = 0;
		while (!intree[v]){
			System.out.println("adding " + v + " to the tree.");
			intree[v] = true;
			EdgeNode p = g.getEdges()[v];
			while (p != null){
				weight = p.getWeight();
				w = p.getAdjacency();
				if (distance[w] > distance[v] + weight){
					distance[w] = distance[v] + weight;
					parent[w] = v;
				}
				p = p.getNext();
			}

			// select the next vertex
			dist = Integer.MAX_VALUE;
			for (int i = 1; i <= totalVertexes; i++){
				if (!intree[i] && dist > distance[i]){
					dist = distance[i];
					v = i;
				}
			}
		}

		// print out the parent
		for (int i = 1; i <= totalVertexes; i++){
			if (parent[i] == -1) continue;
			System.out.println(parent[i] + "--" + i);
		}

		// find the actual path
		Stack<Integer> stack = new Stack<Integer>();
		int k = end;
		while (k != start){
			stack.push(k);
			k = parent[k];
		}
		stack.push(k);

		// print out the path
		System.out.println("the shorted path from " + start + " to " + end);
		while (!stack.isEmpty()){
			System.out.print(stack.pop() + "--");
		}

	}

	public static void flod(AdjMatrix g){

		int totalVertexes = g.getTotalVertexes();
		int throughK = Integer.MAX_VALUE;

		for (int k = 1; k <= totalVertexes; k++) { // how many intermediate node
			for (int i = 1; i <= totalVertexes; i++){
				for (int j = 1; j <= totalVertexes; j++){
					throughK = g.adj[i][k] + g.adj[k][j];
					if (throughK < g.adj[i][j]){
						g.adj[i][j] = throughK;
					}
				}
			}
		}


	}


	private static class AdjMatrix{
		private final int totalVertexes;
		public int[][] adj;

		@SuppressWarnings("unused")
		public AdjMatrix(int totalVertexes){
			this.totalVertexes = totalVertexes;
			adj = new int[totalVertexes + 1][totalVertexes  +1];
			for (int i = 1; i <= totalVertexes; i++){
				for (int j = 1; i <= totalVertexes; j++){
					adj[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		@SuppressWarnings("unused")
		public void addEdge(int x, int y, int weight){
			if (x > totalVertexes || y > totalVertexes || x <= 0 || y <= 0){
				throw new IllegalArgumentException("invalid vertex");
			}
			adj[x][y] = weight;
		}

		public int getTotalVertexes(){
			return this.totalVertexes;
		}
	}

	private static class EdgeNodeComparator implements Comparator<EdgeNode> {

		@Override
		public int compare(EdgeNode e1, EdgeNode e2) {
			int w1 = e1.getWeight();
			int w2 = e2.getWeight();
			if (w1 > w2){
				return 1;
			} else if (w1 < w2){
				return -1;
			} else {
				return 0;
			}
		}

	}


	private static int dfs(Graph g, int start, TraversalBag bag, int time){

		bag.discovered[start] = true;
		time++;
		bag.entry[start] = time;
		processVertexEarly(start, bag);

		EdgeNode[] edgeNodes = g.getEdges();
		EdgeNode p = edgeNodes[start];
		while (p != null){

			// find its adj
			int adj = p.getAdjacency();

			if (!bag.discovered[adj]){
				bag.parent[adj] = start;
				processEdge(start, adj, bag);
				time = dfs(g, adj, bag, time);
			}else if (!bag.processed[adj] || g.isDirected()){
				processEdge(start, adj, bag);
			}

			p = p.getNext();
		}

		processVertexLate(start, bag);
		time++;
		bag.exit[start]= time;
		bag.processed[start] = true;

		return time;

	}

	@SuppressWarnings("unused")
	private static int dfs(Graph g, int start, boolean[] discovered, boolean[] processed,
			int[] entry, int[] exit, int[] parent, int time){

		discovered[start] = true;
		time++;
		entry[start] = time;
		processVertexEarly(start);

		EdgeNode[] edgeNodes = g.getEdges();
		EdgeNode p = edgeNodes[start];
		while (p != null){

			// find its adj
			int adj = p.getAdjacency();

			if (!discovered[adj]){
				parent[adj] = start;
				processEdge(start, adj, parent);
				time = dfs(g, adj, discovered, processed, entry, exit, parent, time);
			}else if (!processed[adj] || g.isDirected()){
				processEdge(start, adj, parent);
			}

			p = p.getNext();
		}

		processVertexLate(start);
		time++;
		exit[start]= time;
		processed[start] = true;

		return time;
	}



	protected static void processVertexEarly(int vertex, TraversalBag bag){
		System.out.println("process vertex early: " + vertex);
	}

	protected static void processEdge(int u, int v, TraversalBag bag){

		Graph.EdgeType type = classify(u, v, bag);
		System.out.println("processing " + u + "--" + v + ", this is a " + type.toString());
	}

	protected static void processVertexLate(int vertex, TraversalBag bag){
		System.out.println("process vertex late: " + vertex);

		// for toplogical sort
		bag.sorted.push(vertex);
	}


	protected static Graph.EdgeType classify(int u, int v, TraversalBag bag){

		if (bag.parent[v] == u){
			return Graph.EdgeType.TREE;
		}
		if (bag.discovered[v] && !bag.processed[v]){
			return Graph.EdgeType.BACK;
		}
		if (bag.processed[v] && (bag.entry[v] > bag.entry[u])){
			return Graph.EdgeType.FORWARD;
		}
		if (bag.processed[v] && (bag.entry[v] < bag.entry[u])){
			return Graph.EdgeType.CROSS;
		}

		return Graph.EdgeType.NOT_DEFINED;
	}


	protected static void processVertexEarly(int vertex){
		System.out.println("process vertex early: " + vertex);
	}

	// TODO: HOW TO DETERMINE THE BACK EDGE
	protected static void processEdge(int u, int v, int[] parent){
		System.out.println("process edge: " + u + "--" + v);

		if (parent[v] != u && parent[v] != -1){
			System.out.println("found a cycle: " + v + "------" + u);
		}

	}
	protected static void processVertexLate(int vertex){
		System.out.println("process vertex late: " + vertex);
	}

}
