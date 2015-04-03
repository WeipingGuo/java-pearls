package org.javapearls.cup.matrix;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestMatrix {

	@Test
	public void searchMatrix(){

		int[][] image = {{0, 1, 2}, {2, 3, 4}, {5, 6, 7}};

		MatrixUtil.Pair res = MatrixUtil.search(image, 5);
		assertTrue(res.row == 2 && res.column == 0);

		res = MatrixUtil.search(image, 4);
		assertTrue(res.row ==1 && res.column ==2);

	}

	@Test
	public void searchMatrixLongerColumns(){

		int[][] image = {{0, 1, 2, 3}, {2, 3, 4, 5}, {3, 4, 5, 6}};

		MatrixUtil.Pair res = MatrixUtil.search(image, 5);
		assertTrue(res.row == 1 && res.column == 3);

		res = MatrixUtil.search(image, 6);
		assertTrue(res.row == 2 && res.column == 3);

		assertTrue(MatrixUtil.search(image, 10) == null);
	}

	@Test
	public void searchMatrixLongerRows(){

		int[][] image = {{0, 10}, {2, 20}, {3, 30}, {4, 40}, {5, 50}, {6, 60}};

		MatrixUtil.Pair res = MatrixUtil.search(image, 40);
		assertTrue(res.row == 3 && res.column == 1);

		res = MatrixUtil.search(image, 6);
		assertTrue(res.row == 5 && res.column == 0);

		assertTrue(MatrixUtil.search(image, 100) == null);
	}



}
