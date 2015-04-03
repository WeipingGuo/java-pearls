package org.javapearls.cup.chapter1;



/**
 * Given an image represented by an NxN matrix,
 * where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees.
 * Can you do this in place?
 *
 * @author wguo
 *
 */
public class Question16 {

	/**
	 * Naive method: create a new matrix
	 *
	 * @param image
	 * @return
	 */
	public static int[][] rotate(int[][] image){

		int[][] newImage = new int[image.length][image.length];

		for (int i = 0; i < image.length; i++){
			for (int j = 0; j < image.length; j++){
				newImage[j][image.length-1 - i] = image[i][j];
			}
		}
		return newImage;
	}

	/**
	 * Using layer swapping
	 *
	 * MY HEAD IS REALLY SPINNING: JUST COULD NOT GET AROUND THE INDEX
	 *
	 * @param image
	 */
	public static void rotateLayered(int[][] image){

		int len = image.length;
		for (int layer = 0; layer < len/2; ++layer){

			// what to rotate
			int first = layer;
			int last = len - 1 - layer;

			for (int i = first; i < last; ++i){

				int offset = i - first;
				int top = image[first][i];

				// left -> top
				int left = image[last-offset][first];
				image[first][i] = left;

				// bottom -> left
				int bottom = image[last][last - offset];
				image[last-offset][first] = bottom;

				// right -> bottom
				int right = image[i][last];
				image[last][last - offset] = right;

				// top -> right
				image[i][last] = top; // right <- saved top

				System.out.println("after layer " + layer + " : " + i );
				print(image);
			}

			System.out.println("after layer "  + layer);
			print(image);

		}
	}

	private static void print(int[][] a){
		for (int i = 0; i < a.length; i++){
			for (int j = 0; j < a[i].length; j++){
				System.out.print(a[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

	/**
	 * Rotate by +90:
	 * Transpose
	 * Reverse each row
	 *
	 * Rotate by -90:
	 * Transpose
	 * Reverse each column
	 */



	/**
	 * Easy to understand solution: transpose and reverse each row
	 *
	 * @param matrix
	 */
	public static void rotateByTranspose(int[][] matrix){

		// transpose first
		transpose(matrix);

		// reverse each row
		for (int row = 0; row < matrix.length; row++){
			int i = 0;
			int j = matrix.length - 1;
			while (i < j){
				int tmp = matrix[row][i];
				matrix[row][i] = matrix[row][j];
				matrix[row][j] = tmp;
				i++;
				j--;
			}
		}
	}

	public static void transpose(int[][] matrix){
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < i; j++){
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
	}

}
