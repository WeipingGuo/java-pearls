package org.javapearls.algorithm.backtracking;


/**
 * find all the subsets of (1, 2, ..., n) using
 * backtracking
 *
 * @author wguo
 *
 */
public class AllSubsets {

	
	/**
	 * check whether a given number belongs to the set
	 * or not
	 *
	 * @param n
	 */
	public static void generateSubsets(int n){
		int[] a = new int[n+1]; 	// skip a[0]
		backTrack(a, 0, n);
	}

	public static void backTrack(int[] a, int k, int n){
		if (isSolution(a, k, n)){
			processSolution(a, k, n);
		}else {
			k = k + 1;
			// find the candidates
			int[] candidates = constructCandidates(a, k, n);
			for (int i = 0; i < candidates.length; i++){
				a[k] = candidates[i];
				makeMove(a, k, n);
				backTrack(a, k, n);
				unMakeMove(a, k, n);
			}
		}
	}

	private static boolean isSolution(int[] a, int k, int n){
		return (k == n);
	}

	private static void processSolution(int[] a, int k, int n){

		System.out.print("{");
		for (int i = 1; i <= k; i++){
			if (a[i] == 1){
				System.out.print(" " + i);
			}
		}
		System.out.print("}\n");
	}

	private static int[] constructCandidates(int[] a, int k, int n){
		int[] result = new int[2];
		result[0] = 1;
		result[1] = 0;
		return result;
	}

	private static void makeMove(int[] a, int k, int n){

	}
	private static void unMakeMove(int[] a, int k, int n){

	}

}
