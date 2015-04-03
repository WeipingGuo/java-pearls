package org.javapearls.datastructure.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


/**
 *
 * BFS applications:
 * 1. web crawling
 * 2. social networking: friends of friends
 * 3. network broadcast
 * 4. garbage collection
 * 5. model checking
 * 6. check mathematics conj
 * 7. solve puzzles and games
 *
 * @author wguo
 *
 */
public class Graphs {

	/**
	 * find the shortest path from a to b
	 *
	 * @param a
	 * @param b
	 * @return
	 */
	public static int shortestPath(Vertex<String> source, Vertex<String> dest){

		// levels keeps track which level are we
		Map<Vertex<String>, Integer> levels =
			new HashMap<Vertex<String>, Integer>();
		// source is at level 0
		levels.put(source, 0);

		// parents for back tracking
		Map<Vertex<String>, Vertex<String>> parents =
			new HashMap<Vertex<String>, Vertex<String>>();
		// source has no parent
		parents.put(source, null);

		// current level
		int i = 1;

		// frontier: current vertex
		Queue<Vertex<String>> frontier = new LinkedList<Vertex<String>>();
		frontier.add(source);

		// next level
		Queue<Vertex<String>> next = new LinkedList<Vertex<String>>();

		while (!frontier.isEmpty()){

			// for level i
			for (Vertex<String> v : frontier){
				// go through each neighbor
				for (Vertex<String> n : v.getNeighbors()){
					// not visited
					if (levels.get(n) == null){
						levels.put(n, i);
						parents.put(n, v);
						next.add(n);
					}
				}
			}

			// swap it
			Queue<Vertex<String>> tmp = frontier;
			tmp.clear();
			frontier = next;
			next = tmp;
			i++; // go to next level
		}

		// output the path from the parents
		System.out.print(dest.toString() + "<--");
		Vertex<String> v = parents.get(dest);
		while (v != null){
			System.out.print(v.toString() + "<--");
			v = parents.get(v);
		}

		return levels.get(dest);
	}

}
