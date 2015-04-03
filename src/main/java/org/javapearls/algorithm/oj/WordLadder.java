package org.javapearls.algorithm.oj;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (start and end), and a dictionary, find the length of
 * shortest transformation sequence from start to end, such that:
 *
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 *
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 *
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 *
 * @author wguo
 *
 */
public class WordLadder {



	public static int transform(String start, String end, Set<String> dict){

		// track level and visited or not
		Map<String, Integer> levels = new HashMap<String, Integer>();
		levels.put(start, 0);

		// back tracking
		Map<String, String> parents = new HashMap<String, String>();
		parents.put(start, null);

		// elements in the current and next level
		Queue<String> currentLevel = new LinkedList<String>();
		Queue<String> nextLevel = new LinkedList<String>();
		currentLevel.add(start);

		// current level
		int i = 1;
		while (!currentLevel.isEmpty()){

			for (String s : currentLevel){

				for (String v : oneHopStrings(s)){
					if (v == end || v.equals(end)){
						return (i + 1);
					}
					if (!dict.contains(v)){
						continue;
					}
					// not visited yet
					if (!levels.containsKey(v)){
						levels.put(v, i);
						parents.put(v, s);
						nextLevel.add(v);
					}
				}
			}

			// current level is done
			Queue<String> tmp = currentLevel;
			tmp.clear();
			currentLevel = nextLevel;
			nextLevel = tmp;
			i++;
		}

		return 0;
	}

	/**
	 * BFS: the neighbors of each string are one edit away
	 *
	 * @param start
	 * @param end
	 * @param dictionay
	 * @return
	 */
	public static LinkedList<String> shortestTranform(String start, String end, Set<String> dictionay){

		// track the level
		Map<String, Integer> levels = new HashMap<String, Integer>();
		levels.put(start, 0);

		// back tracking
		Map<String, String> parents = new HashMap<String, String>();
		parents.put(start, null);

		Queue<String> currentLevel = new LinkedList<String>();
		Queue<String> nextLevel = new LinkedList<String>();
		currentLevel.add(start);

		// current level
		int i = 1;
		while (!currentLevel.isEmpty()){

			for (String s : currentLevel){

				for (String v : oneHopStrings(s)){

					if (v == end || v.equals(end)){
						parents.put(v, s);
						return backTrack(parents, end);
					}

					// if not in the directory, skip
					if (!dictionay.contains(v)){
						continue;
					}

					// if not visited
					if (!levels.containsKey(v)){
						levels.put(v, i);
						parents.put(v, s);
						nextLevel.add(v);
					}
				}
			}

			//swap two queues
			Queue<String> tmp = currentLevel;
			tmp.clear();
			currentLevel = nextLevel;
			nextLevel = tmp;
			i++; // go to next level
		}

		return null;
	}

	private static LinkedList<String> backTrack(Map<String, String> parents, String end){
		LinkedList<String> res = new LinkedList<String>();
		res.add(end);
		String parent = parents.get(end);
		while (parent != null){
			res.addFirst(parent);
			parent = parents.get(parent);
		}

		return res;
	}
	public static Set<String> oneHopStrings(String s){

		Set<String> res = new HashSet<String>();
		for (int i = 0; i < s.length(); i++){
			char[] charArray = s.toCharArray();
			// replace with 'a'-'z'
			for (char c = 'a'; c <= 'z'; c++){
				if (charArray[i] != c){
					charArray[i]= c;
					res.add(new String(charArray));
				}
			}
		}

		return res;
	}
}
