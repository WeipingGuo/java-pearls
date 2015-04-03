package org.javapearls.algorithm.dp.basic;

public class BinomialCoefficient {
	
	/**
	 * 
	 * @param n total number of elements
	 * @param k	number of elements to choose
	 * @return
	 */
	public static int binoCoeff(int n, int k){
		
		int[][] co = new int[n + 1][n + 1];
		
		for (int i = 0; i <= n; i++){
			co[i][0] = 1;
		}
		for (int i = 0; i <= n; i++){
			co[i][i] = 1;
		}
		for (int i = 1; i <= n;  i++){
			for (int j = 1; j < i; j++){
				co[i][j] = co[i - 1][j - 1] + co[i - 1][j];
			}
		}
		
		return co[n][k];
	}

}
