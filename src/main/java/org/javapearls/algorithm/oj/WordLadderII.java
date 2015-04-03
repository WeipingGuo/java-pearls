package org.javapearls.algorithm.oj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


/**
 * Given two words (start and end), and a dictionary,
 * find all shortest transformation sequence(s) from start to end, such that:
 *
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 *
 * For example,
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 *
 * Return
 *
 *[
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * Note:
 *
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * @author wguo
 *
 */
public class WordLadderII {

	public static List<LinkedList<String>> transform(String start, String end, Set<String> dict){

		// levels track whether an element is visited or also the level
		Map<String, Integer> levels = new HashMap<String,Integer>();
		levels.put(start, 0);

		// back tracking: one vertex could have multiple parents
		Map<String, Set<String>> parents = new HashMap<String, Set<String>>();
		parents.put(start, null);

		// track current level and next level elements
		Queue<String> currentLevel = new LinkedList<String>();
		Queue<String> nextLevel = new LinkedList<String>();
		currentLevel.add(start);

		// which level
		int i = 1;
		boolean done = false;
		while (!done){

			// go through each element in the current level
			while (!currentLevel.isEmpty()){

				String s = currentLevel.poll();
				for (String v : WordLadder.oneHopStrings(s)){

					// end string, could have multiple parents
					// do not stop until this level is done
					if (v == end || v.equals(end)){
						addToParent(parents, s, v);
						done = true;
					}

					// not in the dictionary
					if (!dict.contains(v)){
						continue;
					}

					// if not visited yet
					if (!levels.containsKey(v)){
						addToParent(parents, s, v);
						levels.put(v, i);
						nextLevel.add(v);
					}
				}
			}

			// go to next level
			Queue<String> tmp = currentLevel;
			currentLevel = nextLevel;
			nextLevel = tmp;
			i++;
		}

		System.out.println("parents lists: ");
		print(parents);

		// all done calculate the paths using parents
		List<LinkedList<String>> res = new ArrayList<LinkedList<String>>();
		LinkedList<String> first = new LinkedList<String>();
		first.add(end);

		DFS(parents, end, res, first);
		return res;
	}

	/**
	 * DFS to construct all the paths
	 *
	 * @param parents
	 * @param child
	 * @param paths
	 * @param currentPath
	 */
	public static void DFS(Map<String, Set<String>> parents, String child, List<LinkedList<String>> paths,
			LinkedList<String> currentPath){

		Set<String> parent = parents.get(child);

		// find one path, add to the result
		if (parent == null || parent.isEmpty()){
			paths.add(new LinkedList<String>(currentPath));
			return;
		}

		// go through each parent
		for (String s : parent){
			currentPath.addFirst(s);
			DFS(parents, s, paths, currentPath);
			currentPath.removeFirst();
		}
	}


	/**
	 * generate all paths from backtracking.
	 * This solution works, but the above DFS works better
	 *
	 * @param parents
	 * @param end
	 * @param partial
	 * @return
	 */
	@SuppressWarnings("unused")
	private static List<LinkedList<String>> generate(Map<String, Set<String>> parents, String end,
			List<LinkedList<String>> partial){

		// find the parents
		Set<String> parent = parents.get(end);
		if (parent == null || parent.isEmpty()){
			return duplicate(partial);
		}

		if (parent.size( ) == 1){
			for (String s  : parent){
				for (LinkedList<String> list : partial){
					list.addFirst(s);
				}
				return generate(parents, s, partial);
			}
		}

		List<LinkedList<String>> res = new ArrayList<LinkedList<String>>();
		for (String s : parent){
			List<LinkedList<String>> tmp = duplicate(partial);
			for (LinkedList<String> list : tmp){
				list.addFirst(s);
			}
			res.addAll(generate(parents, s, tmp));
		}
		return res;
	}

	private static List<LinkedList<String>> duplicate(List<LinkedList<String>> orig){
		List<LinkedList<String>> dup = new ArrayList<LinkedList<String>>();
		for (LinkedList<String> list : orig){
			dup.add(new LinkedList<String>(list));
		}
		return dup;
	}


	private static void addToParent(Map<String, Set<String>> parents, String parent, String child){
		Set<String> parentList = parents.get(child);
		if (parentList == null){
			parentList = new HashSet<String>();
			parentList.add(parent);
			parents.put(child, parentList);
		}else{
			parentList.add(parent);
		}
	}

	public static void print(Map<String, Set<String>> parents){
		for (Map.Entry<String, Set<String>> entry: parents.entrySet()){
			System.out.print(entry.getKey() + "->");
			Set<String> values = entry.getValue();
			if (values != null){
				for (String s : values){
					System.out.print(s + "," );
				}
			}
			System.out.println();
		}
	}

}
