package org.javapearls.datastructure.graph;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGraph {

	@Test
	public void testShortestPath(){

		Vertex<String> a = new Vertex<String>("a");
		Vertex<String> s = new Vertex<String>("s");
		Vertex<String> z = new Vertex<String>("z");
		Vertex<String> x = new Vertex<String>("x");
		Vertex<String> d = new Vertex<String>("d");
		Vertex<String> c = new Vertex<String>("c");
		Vertex<String> f = new Vertex<String>("f");
		Vertex<String> v = new Vertex<String>("v");

		// add edges
		a.addNeighbor(s);
		a.addNeighbor(z);
		a.printNeighbors();

		s.addNeighbor(a);
		s.addNeighbor(x);
		s.printNeighbors();

		z.addNeighbor(a);
		z.printNeighbors();

		x.addNeighbor(s);
		x.addNeighbor(d);
		x.addNeighbor(c);
		x.printNeighbors();

		d.addNeighbor(x);
		d.addNeighbor(c);
		d.addNeighbor(f);
		d.printNeighbors();

		c.addNeighbor(x);
		c.addNeighbor(d);
		c.addNeighbor(f);
		c.addNeighbor(v);
		c.printNeighbors();

		f.addNeighbor(d);
		f.addNeighbor(c);
		f.addNeighbor(v);
		f.printNeighbors();

		v.addNeighbor(f);
		v.addNeighbor(c);
		v.printNeighbors();

		int shortestPath = Graphs.shortestPath(s, f);
		assertEquals(shortestPath, 3);
	}

}
