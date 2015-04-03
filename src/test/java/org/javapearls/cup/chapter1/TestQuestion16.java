package org.javapearls.cup.chapter1;

import org.junit.Test;

public class TestQuestion16 {

	@Test
	public void testImageRotate(){

		int[][] image = {{0, 1, 2}, {2, 3, 4}, {5, 6, 7}};
		print(image);

		System.out.println(">>>>>> 90 degree rotation ...");

		int[][] newImage = Question16.rotate(image);
		print(newImage);
	}

	@Test
	public void testImageRotateLayed(){
		int[][] image = {{0, 1, 2}, {2, 3, 4}, {5, 6, 7}};
		print(image);

		System.out.println(">>>>>> 90 degree rotation ...");
		Question16.rotateLayered(image);
		print(image);
	}

	@Test
	public void testImageRotateLayed2(){
		System.out.println("rotate using layer ...");
		int[][] image = {{1, 1, 1, 1, 1}, {2, 2, 2, 2, 2}, {3, 3, 3, 3, 3}, {8, 8, 8, 8, 8}, {9, 9, 9, 9, 9}};
		print(image);


		Question16.rotateLayered(image);
		System.out.println(">>>>>> 90 degree rotation ...");
		print(image);
	}

	@Test
	public void testTranspose(){
		System.out.println("rotate using layer ...");
		int[][] image = {{1, 1, 1, 1, 1}, {2, 2, 2, 2, 2}, {3, 3, 3, 3, 3}, {8, 8, 8, 8, 8}, {9, 9, 9, 9, 9}};
		print(image);

		Question16.transpose(image);
		System.out.println(">>> transpose ...");
		print(image);
	}

	@Test
	public void testRotationByTranspose(){
		System.out.println("rotate using layer ...");
		int[][] image = {{1, 1, 1, 1, 1}, {2, 2, 2, 2, 2}, {3, 3, 3, 3, 3}, {8, 8, 8, 8, 8}, {9, 9, 9, 9, 9}};
		print(image);

		Question16.rotateByTranspose(image);
		System.out.println(">>> 90 degree rotation ...");
		print(image);
	}

	@Test
	public void testRotationByTranspose2(){
		int[][] image = {{0, 1, 2}, {2, 3, 4}, {5, 6, 7}};
		print(image);

		System.out.println(">>>>>> 90 degree rotation ...");
		Question16.rotateByTranspose(image);
		print(image);
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
