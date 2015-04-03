package org.javapearls.algorithm.oj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab",
 * Return
 *  [
 *  	 ["aa","b"],
 *  	 ["a","a","b"]
 *	]
 *
 * @author wguo
 *
 */
@SuppressWarnings("unused")
public class PalindromePartitioning {

	public static List<LinkedList<String>> partition(String s){
		List<LinkedList<String>> res = new  ArrayList<LinkedList<String>>();
		List<String> current = new ArrayList<String>();
		partition(s, 0, res, current);
		return res;
	}

	private static void partition(String orig, int start, List<LinkedList<String>> result, List<String> current){

		if (start >= orig.length()){
			result.add(new LinkedList<String>(current));
			return;
		}

		for (int i = start; i < orig.length(); i++){
			 if (isPalindrome(orig, start, i)) {
				 current.add(orig.substring(start, i + 1));
				 partition(orig, i + 1, result, current);
				 current.remove(current.size() - 1);
	        }
		}

	}

	private static boolean isPalindrome(String s, int start, int end){
		while (start < end){
			if (s.charAt(start) != s.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

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



	private static Set<String> subPali(String s){
		Set<String> set = new HashSet<String>();
		char[] array = s.toCharArray();
		for (int i = 0; i < array.length; i++){
			if (isPalindrome(array, 0, i)){
				set.add(new String(array, 0, i + 1));
			}
		}
		return set;
	}

	private static boolean isPalindrome(char[] array, int start, int end){
		// only one element
		if (start == end){
			return true;
		}

		while (start <= end){
			if (array[start++] != array[end--]){
				return false;
			}
		}
		return true;
	}
}
