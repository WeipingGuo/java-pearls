package org.javapearls.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;


/**
 * Calculate the permutation of given string using backtrack
 * The basic steps for backtracking:
 *  1. check whether a solution is found, process the solution if found
 *  2. construct the candidates
 *  3. for each candidate, backtrack 
 *
 * @author wguo
 *
 */
public class Permutation {

	public static void permutate(String s){

		int[] a = new int[s.length() + 1];
		for (int i = 0; i < a.length; i++){
			a[i] = -1;
		}
		backTrack(a, 0, s);
	}

	public static void backTrack(int[] a, int k, String s){
		if (isSolution(a, k, s)){
			processSolution(a, k, s);
		}else {
			k++;
			Integer[] candidates = constructCandidates(a, k, s);
			for (int i = 0; i < candidates.length; i++){
				a[k] = candidates[i];
				backTrack(a, k, s);
				a[k] = -1;
			}
		}
	}

	/**
	 * whether we find a permutation or not
	 *
	 * @param a
	 * @param k
	 * @param s
	 * @return
	 */
	public static boolean isSolution(int[] a, int k, String s){
		return (k == s.length());
	}

	public static void processSolution(int[] a, int k, String s){
		for (int i = 1; i < a.length; i++){
			if (a[i] != -1){
				System.out.print(s.charAt(a[i]));
			}
		}
		System.out.println();
	}

	public static Integer[] constructCandidates(int[] a, int k, String s){

		// whether char at s[i] is in permutation or not
		boolean[] inPerm = new boolean[s.length() + 1];
		for (int i = 1; i < a.length; i++){
			if (a[i] != -1){
				inPerm[a[i] + 1] = true;
			}
		}

		List<Integer> result = new ArrayList<Integer>();
		for (int i = 1; i < inPerm.length; i++){
			if (!inPerm[i]){
				result.add(i-1);
			}
		}

		Integer[] res = new Integer[result.size()];
		result.toArray(res);
		return res;
	}


}
