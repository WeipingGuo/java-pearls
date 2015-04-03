package org.javapearls.algorithm.sorting;

/**
 *
 * @author wguo
 *
 */
public class RadixSort {

	/**
	 * Sort an array using Radix sort: least significant digit first
	 *
	 * @param a
	 * @param totalDigit
	 */
	public static void sort(int[] a, int totalDigit){

		for (int i = 0; i < totalDigit; i++){
			// sort on digit i
			sortByDigit(a, i);
		}
	}

	/**
	 * Sort array based on particular position
	 *
	 * @param a
	 * @param position
	 */
	public static void sortByDigit(int[] a, int position){

		// allocate storage for final output and counting
		int[] b = new int[a.length];
		int[] c = new int[10];	// 0 - 9

		for (int i = 0; i <= a.length - 1; i++){
			int digit = getDigit(a[i], position);
			c[digit]++;
		}

		for (int i = 1; i <= c.length - 1; i++){
			c[i] = c[i - 1] + c[i];
		}

		// find the position of a[j]
		// since c[i] contains the number of elements <= i,
		// the final position of a[j] should be c[a[j]] - 1
		for (int j = b.length - 1; j >= 0; j--){
			int digit = getDigit(a[j], position);
			b[c[digit] - 1] = a[j];
			c[digit]--;
		}

		// copy back
		for (int i = 0; i < a.length; i++){
			a[i] = b[i];
		}
	}


	/**
	 * Get the corresponding digit at position of position
	 *
	 *	Number: 		7	8	9	2	5
	 *	Posistion:		4	3	2	1	0
	 *
	 * @param x
	 * @param position
	 * @return
	 */
	public static int getDigit(int x, int position){
		int div = x / (int)Math.pow(10, position);
		return div % 10;
	}

	/**
	 * Find how many digits an integer has
	 *
	 * @param x
	 * @return
	 */
	public static int totalDigit(int x){

		if (x == 0){
			return 1;
		}

		if (x < 0){
			x = -x;
		}

		int total = 0;
		while (x != 0){
			total++;
			x /= 10;
		}
		return total;
	}

}
