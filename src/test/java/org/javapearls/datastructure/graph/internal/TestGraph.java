package org.javapearls.datastructure.graph.internal;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

public class TestGraph {

	@Test(expected=IllegalArgumentException.class)
	public void testAdjacencyListInvalidParameter(){
		Graph graph = new Graph(10, true);
		graph.addEdge(0, 2, 0);
	}

	@Test
	public void testAdjacencyList(){

		Graph graph = new Graph(10, true);
		graph.addEdge(1, 2, 0);
		graph.addEdge(8, 2, 0);
		graph.addEdge(3, 6, 0);
		graph.addEdge(7, 8, 0);
		graph.addEdge(1, 5, 0);
		graph.addEdge(3, 7, 0);
		graph.addEdge(1, 3, 0);

		assertTrue(graph.getNumEdges() == 7);
		assertTrue(graph.getDegree(1) == 3);
		assertTrue(graph.getDegree(2) == 0);
		assertTrue(graph.getDegree(3) == 2);
		graph.print();
		int[] parent = graph.bfs(1);
		graph.findPath(1, 8, parent);

		System.out.println("=================");
		Graph g2 = new Graph(10, false);
		g2.addEdge(1, 2, 0);
		g2.addEdge(8, 2, 0);
		g2.addEdge(3, 6, 0);
		g2.addEdge(7, 8, 0);
		g2.addEdge(1, 5, 0);
		g2.addEdge(3, 7, 0);
		g2.addEdge(1, 3, 0);
		assertTrue(g2.getNumEdges() == 7);
		assertTrue(g2.getDegree(1) == 3);
		assertTrue(g2.getDegree(2) == 2);
		assertTrue(g2.getDegree(3) == 3);
		g2.print();
		int[] parents = g2.bfs(1);
		g2.findPath(1, 8, parents);
		g2.findPath(1, 3, parents);

		System.out.println("shortest path 1 --> 8");
		Queue<Integer> queue = new LinkedList<Integer>();
		g2.findPath(1, 8, parents, queue);
		while(!queue.isEmpty()){
			System.out.print(queue.poll() + "\t");
		}

		Stack<Integer> stack = new Stack<Integer>();
		g2.findPath(1, 8, parents, stack);
		while (!stack.isEmpty()){
			System.out.print(stack.pop() + "--");
		}

	}

	@Test
	public void testBfs(){
		Graph g1 = new Graph(6, false);
		g1.addEdge(1, 2, 0);
		g1.addEdge(1, 5, 0);
		g1.addEdge(1, 6, 0);
		g1.addEdge(2, 3, 0);
		g1.addEdge(2, 5, 0);
		g1.addEdge(3, 4, 0);
		g1.addEdge(4, 5, 0);
		g1.print();
		int[] parents = g1.bfs(1);
		g1.findPath(1, 4, parents);
		assertTrue(g1.getNumEdges() == 7);
		assertFalse(g1.isBipartite());

		Graph g2 = new Graph(6, true);
		g2.addEdge(1, 2, 0);
		g2.addEdge(1, 5, 0);
		g2.addEdge(1, 6, 0);
		g2.addEdge(2, 3, 0);
		g2.addEdge(2, 5, 0);
		g2.addEdge(3, 4, 0);
		g2.addEdge(5, 4, 0);
		g2.print();
		int[] parent = g2.bfs(1);
		g2.findPath(1, 4, parent);
		assertTrue(g2.getNumEdges() == 7);
		Map<Integer, List<Integer>> components = g2.connectedComponents();
		assertTrue(components.size() == 1);
		print(components);

		Graph g3 = new Graph(6, true);
		g3.addEdge(1, 2, 0);
		g3.addEdge(1, 5, 0);
		g3.addEdge(1, 6, 0);
		g3.addEdge(3, 4, 0);
		assertTrue(g3.getNumEdges() == 4);
		assertTrue(g3.isBipartite());

		// no edges
		Graph g4 = new Graph(100, true);
		assertTrue(g4.getNumEdges() == 0);
		assertTrue(g4.isBipartite());
	}

	@Test
	public void testDfs(){

		Graph g1 = new Graph(6, false);
		g1.addEdge(1, 2, 0);
		g1.addEdge(1, 5, 0);
		g1.addEdge(1, 6, 0);
		g1.addEdge(2, 3, 0);
		g1.addEdge(2, 5, 0);
		g1.addEdge(3, 4, 0);
		g1.addEdge(4, 5, 0);
		g1.print();

		g1.dfs(1);
	}

	private void print(Map<Integer, List<Integer>> map){
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
			System.out.print(entry.getKey() + ":");
			for (Integer i : entry.getValue()){
				System.out.print(i + "\t");
			}
		}
	}

}
