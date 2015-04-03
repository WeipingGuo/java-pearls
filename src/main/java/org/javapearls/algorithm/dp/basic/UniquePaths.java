package org.javapearls.algorithm.dp.basic;


/**
 *  robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *  The robot can only move either down or right at any point in time.
 *  The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * @author wguo
 *
 */
public class UniquePaths {

	public static int paths(int[][] matrix, int i, int j){

		if (i == 0 && j == 0){
			return 1;
		}

		if (i == 0){
			return paths(matrix, i, j-1);
		}
		if (j == 0){
			return paths(matrix, i-1, j);
		}
		return paths(matrix, i-1, j) + paths(matrix, i, j-1);
	}


	public static int uniquePaths(int[][] matrix){

		int rows = matrix.length;
		int columns = matrix[0].length;

		int[][] res = new int[rows][columns];

		for (int i = 0; i < rows; i++){
			for (int j = 0; j < columns; j++){
				if (i ==0 || j == 0){
					res[i][j] = 1;
				} else {
					res[i][j] = res[i-1][j] + res[i][j-1];
				}
			}
		}
		return res[rows-1][columns-1];
	}

	public static int uniquePathsCompact(int[][] matrix){

		int rows = matrix.length;
		int columns = matrix[0].length;

		int[] m = new int[columns], n = new int[columns];

		// init m = 1
		for (int i = 0; i < m.length; i++){
			m[i] = 1;
		}
		n[0] = 1;

		for (int i = 1; i < rows; i++){
			for (int j = 1; j < columns; j++){
				n[j] = m[j] + n[j-1];
			}
			System.out.println("after row " + i);
			print(m);
			print(n);

			// swap n and m
			if ((i+1) < rows){
				int[] tmp = n;
				n = m;
				m = tmp;
			}
		}
		return n[columns - 1];
	}

	 public static void print(int[] a){
		 for (int i = 0; i < a.length; i++){
	    	 System.out.print(a[i] + " ");
	     }
		 System.out.print("\n");
	 }

}
