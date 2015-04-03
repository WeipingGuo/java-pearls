package org.javapearls.cup.matrix;

public class MatrixUtil {

	public static class Pair{
		public final int row;
		public final int column;

		public Pair(int row, int column){
			this.row = row;
			this.column = column;
		}
	}

	/**
	 * Given a matix in which each row and each column is sorted,
	 * find an element in it
	 *
	 * Algorithm: start from [0,n-1], adjust row and column correspondingly
	 */
	public static Pair search(int[][] a, int target){

		if (a == null || a.length == 0 || a[0].length == 0){
			return null;
		}

		int row = 0, col = a[0].length - 1;

		while (row < a.length && col >= 0){
			if (a[row][col] == target){
				return new Pair(row, col);
			} else if (a[row][col] < target){
				row++;
			} else {
				col--;
			}
		}

		return null;
	}

	public static void setZeros(int[][] matrix){

	    if (matrix == null) return;

	    int rows = matrix.length;
	    int columns = matrix[0].length;

	    // record which row or column has zero
	    int[] zeroRows = new int[rows];
	    int[] zeroColumns = new int[columns];
	    for (int i = 0; i < rows; i++){
	        for (int j = 0; j < columns; j++){
	            if (matrix[i][j] == 0){
	                zeroRows[i] = 1;
	                zeroColumns[j] =1;
	            }
	        }
	    }

	    // go through again, set the element to zero
	    // if its row or column has zero
	    for (int i = 0; i < rows; i++){
	        for (int j = 0; j < columns; j++){
	            if (zeroRows[i] == 1 || zeroColumns[j] ==1){
	                matrix[i][j] = 0;
	            }
	        }
	    }
	}

}
