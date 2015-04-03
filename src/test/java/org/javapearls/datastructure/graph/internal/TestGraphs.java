package org.javapearls.datastructure.graph.internal;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGraphs {


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

		Graphs.dfs(g1, 1);
	}

	@Test
	public void testDfsUnDirected(){
		Graph g1 = new Graph(6, false);
		g1.addEdge(1, 2, 0);
		g1.addEdge(1, 5, 0);
		g1.addEdge(1, 6, 0);
		g1.addEdge(2, 3, 0);
		g1.addEdge(2, 5, 0);
		g1.addEdge(3, 4, 0);
		g1.addEdge(4, 5, 0);
		g1.print();

		Graphs.dfs(g1, 1);
	}

	@Test
	public void testTopologicalSort(){
		Graph g1 = new Graph(6, true);
		g1.addEdge(1, 2, 0);
		g1.addEdge(1, 5, 0);
		g1.addEdge(1, 6, 0);
		g1.addEdge(2, 3, 0);
		g1.addEdge(2, 5, 0);
		g1.addEdge(3, 4, 0);
		g1.addEdge(4, 5, 0);
		g1.print();

		Graphs.topSort(g1);
	}

	@Test
	public void testConnectedComponents(){
		Graph g1 = new Graph(6, false);
		g1.addEdge(1, 2, 0);
		g1.addEdge(1, 5, 0);
		g1.addEdge(1, 6, 0);
		g1.addEdge(2, 3, 0);
		g1.addEdge(2, 5, 0);
		g1.addEdge(3, 4, 0);
		g1.addEdge(4, 5, 0);
		assertTrue(Graphs.totalConnectedComponents(g1) == 1);

		Graph g3 = new Graph(6, true);
		g3.addEdge(1, 2, 0);
		g3.addEdge(1, 5, 0);
		g3.addEdge(1, 6, 0);
		g3.addEdge(3, 4, 0);
		assertTrue(Graphs.totalConnectedComponents(g3) == 2);
	}

	@Test
	public void testStronglyConnected(){
		Graph g = new Graph(8, true);
		g.addEdge(1, 2, 0);
		g.addEdge(2, 3, 0);
		g.addEdge(2, 4, 0);
		g.addEdge(2, 5, 0);
		g.addEdge(3, 1, 0);
		g.addEdge(4, 1, 0);
		g.addEdge(4, 8, 0);
		g.addEdge(4, 6, 0);
		g.addEdge(8, 6, 0);
		g.addEdge(6, 7, 0);
		g.addEdge(7, 5, 0);
		g.addEdge(5, 6, 0);

		g.print();
		assertFalse(Graphs.isStronglyConnected(g));

		Graph g2 = new Graph(3, true);
		g2.addEdge(1, 2, 0);
		g2.addEdge(2, 3, 0);
		g2.addEdge(3, 1, 0);
		assertTrue(Graphs.isStronglyConnected(g2));
	}


	@Test
	public void testMinSpanningTreePrim(){

		Graph g = new Graph(7, false);
		g.addEdge(1, 2, 5);
		g.addEdge(1, 3, 7);
		g.addEdge(1, 4, 12);
		g.addEdge(2, 7, 7);
		g.addEdge(2, 3, 9);
		g.addEdge(4, 3, 4);
		g.addEdge(4, 5, 7);
		g.addEdge(5, 6, 2);
		g.addEdge(5, 7, 2);
		g.addEdge(5, 3, 3);
		g.addEdge(6, 7, 5);
		g.addEdge(7, 3, 4);

		System.out.println("total edges: " + g.getNumEdges());
		g.print();

		Graphs.mstPrim(g, 1);
	}

	@Test
	public void testMinSpanningTreeKruskal(){

		Graph g = new Graph(7, false);
		g.addEdge(1, 2, 5);
		g.addEdge(1, 3, 7);
		g.addEdge(1, 4, 12);
		g.addEdge(2, 7, 7);
		g.addEdge(2, 3, 9);
		g.addEdge(4, 3, 4);
		g.addEdge(4, 5, 7);
		g.addEdge(5, 6, 2);
		g.addEdge(5, 7, 2);
		g.addEdge(5, 3, 3);
		g.addEdge(6, 7, 5);
		g.addEdge(7, 3, 4);

		System.out.println("total edges: " + g.getNumEdges());
		Graphs.mstKruskal(g, 1);
	}

	@Test
	public void testShortedPathDijkstra(){

		Graph g = new Graph(7, false);
		g.addEdge(1, 2, 5);
		g.addEdge(1, 3, 7);
		g.addEdge(1, 4, 12);
		g.addEdge(2, 7, 7);
		g.addEdge(2, 3, 9);
		g.addEdge(4, 3, 4);
		g.addEdge(4, 5, 7);
		g.addEdge(5, 6, 2);
		g.addEdge(5, 7, 2);
		g.addEdge(5, 3, 3);
		g.addEdge(6, 7, 5);
		g.addEdge(7, 3, 4);

		Graphs.dijkstra(g, 1, 7);
		Graphs.dijkstra(g, 1, 6);
	}

}
