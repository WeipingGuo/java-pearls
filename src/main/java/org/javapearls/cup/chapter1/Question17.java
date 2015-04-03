package org.javapearls.cup.chapter1;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0,
 * its entire row and column is set to 0.
 *
 * @author wguo
 *
 */
public class Question17 {


	/**
	 * 	1. Iterate over each row, if zero is found:
	 * 		a. reset corresponding row and column to zero.
	 * 		b. during reset, watch out the column value change.
	 * 			if we introduced zero, do not want to revisit this column later on.
	 * 			Add the column to the SkipSet
	 * 		c. skip the remaining of the current row.
	 *  2. Skip some column which we introduced zero
	 *
	 */
	public static void reset(int[][] a){

		Set<Integer> columnToSkip = new  HashSet<Integer>();
		for(int i = 0; i < a.length; i++){

			for (int j = 0; j < a[i].length; j++){

				// skip the column because newly introduced zero
				if (columnToSkip.contains(j)){
					continue;
				}

				if (a[i][j] == 0){
					reset(a,i,j, columnToSkip);
					// no need go through the remaining of the row
					break;
				}
			}
		}

	}

	/**
	 * reset given column and row to be zero
	 *
	 * @param a
	 * @param row
	 * @param column
	 */
	public static void reset(int[][] a, int row, int column, Set<Integer> skip){


		for (int i = 0; i < a[row].length; i++){
			a[row][i] = 0;
		}

		// for this column: skip in the later iteration only if we introduced zero
		boolean toSkip = true;
		for (int j = 0; j < a.length; j++){

			// column has zero and not the one we are visiting
			if (a[j][column] == 0 && j != row){
				toSkip = false;
				continue;
			}

			a[j][column] = 0;
		}
		if (toSkip == true){
			skip.add(column);
		}

	}

	/**
	 * scan twice: first record which row and column has zero.
	 * second: set the cell to zero if corresponding row or column has zero
	 *
	 * @param a
	 */
	public static void resetZero(int[][] a){

	    int[] zeroRow = new int[a.length];
	    int[] zeroColumn = new int[a[0].length];

	    // record which row and column has zero
	    for (int i = 0; i < a.length; i++){
	        for (int j = 0; j < a[i].length; j++){
	            if (a[i][j] == 0){
	                zeroRow[i] = 1;
	                zeroColumn[j] = 1;
	            }
	        }
	    }

	    // scan again and set cell to zero if corresponding
	    // row or column has zero
	    for (int i = 0; i < a.length; i++){
	        for (int j = 0; j < a[i].length; j++){
	            if (zeroRow[i] == 1 || zeroColumn[j] == 1){
	                a[i][j] = 0;
	            }
	        }
	    }

	}


}
