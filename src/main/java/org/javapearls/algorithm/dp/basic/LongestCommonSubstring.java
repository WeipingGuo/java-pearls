package org.javapearls.algorithm.dp.basic;

/**
 * longest common substring problem is to find the longest string
 * (or strings) that is a substring (or are substrings) of two or more strings.
 *
 * @author wguo
 *
 */
public class LongestCommonSubstring {


	public static String lcsubstr(String a, String b){
		if (a == null || a.isEmpty() || b== null || b.isEmpty()){
			return null;
		}

		if (a.equals(b)){
			return a;
		}

		return lcsubstr(a.toCharArray(), b.toCharArray());
	}


	/**
		 function LCSubstr(S[1..m], T[1..n])
	    L := array(1..m, 1..n)
	    z := 0
	    ret := {}
	    for i := 1..m
	        for j := 1..n
	            if S[i] == T[j]
	                if i == 1 or j == 1
	                    L[i,j] := 1
	                else
	                    L[i,j] := L[i-1,j-1] + 1
	                if L[i,j] > z
	                    z := L[i,j]
	                    ret := {S[i-z+1..i]}
	                elif L[i,j] == z
	                    ret := ret ∪ {S[i-z+1..i]}
	            else L[i,j]=0;
	    return ret
	 * @param a
	 * @param b
	 * @param i
	 * @param j
	 * @return
	 */

	public static String lcsubstr(char[] a, char[] b){

		if (a.length == 0 || b.length == 0){
			return "";
		}

		int[][] track = new int[a.length + 1][b.length + 1];
		int z = 0;
		String ret = "";

		for (int i = 1; i <= a.length; i++){
			for (int j = 1; j <= b.length; j++){

				if (a[i-1] == b[j-1]){
					if (i == 1 || j == 1){
						track[i][j] = 1;
					}else{
						track[i][j] = track[i-1][j-1] + 1;
					}

					if (track[i][j] > z){
						z = track[i][j];
						ret = new String(a, i-z,z);
					}else if (track[i][j] == z){
						ret = ret + new String(a, i-z, z);
					}else{
						ret = "";
					}

				}else{
					track[i][j] = 0;
				}

			}
		}

		return ret;
	}


}
