package org.javapearls.algorithm.dp.basic;

import org.javapearls.algorithm.dp.basic.UniquePaths;
import org.junit.Test;

public class TestUniquePaths {

	@Test
	public void testUniquePaths(){

		int[][] a = {{1,2,3,},{4,5,6}};
		int totalPaths = UniquePaths.paths(a, a.length - 1, a[0].length - 1);
		System.out.println("total unique paths: " + totalPaths);
		System.out.println("dp solutions:" + UniquePaths.uniquePaths(a));

		int[][] b = {{1,2,3,},{4,5,6}, {7,8,9}};
		totalPaths = UniquePaths.paths(b, b.length - 1, b[0].length - 1);
		System.out.println("total unique paths: " + totalPaths);

		totalPaths = UniquePaths.uniquePaths(b);
		System.out.println("dp solutions: " + totalPaths);

		totalPaths = UniquePaths.uniquePathsCompact(b);
		System.out.println("dp compact solutions: " + totalPaths);
	}

}
