package org.javapearls.cup.chapter1;

import org.junit.Test;

public class TestQuestion17 {

	@Test
	public void testMatrixReset(){

		int[][] a = { {1,2,3,4}, {1,0,5,6}, {0,20,6,8}};

		print(a);

		Question17.reset(a);
		System.out.println("After resetting...");
		print(a);
	}


	@Test
	public void restResetZero(){
		int[][] a = { {1,2,3,4}, {1,0,5,6}, {0,3,6,8}};

		print(a);

		Question17.resetZero(a);
		System.out.println("After resetting...");
		print(a);
	}

	private void print(int[][] a){
		for (int i = 0; i < a.length; i++){
			for (int j = 0; j < a[i].length; j++){
				System.out.print(a[i][j] + " ");
			}
			System.out.print("\n");
		}
	}




}
