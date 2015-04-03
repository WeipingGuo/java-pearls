package org.javapearls.algorithm.numbers;

public class RandomNumber {


	/**
	 * Known a random function generating number 0 - 1,
	 * using this function to randomly generate number between
	 * 0 - n
	 *
	 * Use random01 to determine each bit.
	 *
	 */
	public static int random(int n){

		while (true){
			int res = 0;
			int t = n;
			while (t > 0){
				res = ((res<<1)| random01());
				t >>>= 1;
			}

			if (res < n){
				return res;
			}
		}

	}

	public static int random01(){
		return (int)(Math.random()*2);
	}


	/**
	 * generate n^2 ordered pair randomly
	 *
	 * @param n
	 * @return
	 */
	public static int[] randomOrderedPair(int n){
		int i = Integer.MIN_VALUE, j = Integer.MIN_VALUE;
		do{
			i = (int)(Math.random() * (n + 1));
			j = (int)(Math.random() * (n + 1));

			// swap i and j
			if (i > j){
				int temp = i;
				i = j;
				j = temp;
			}

		}while (i == j);

		return new int[]{i, j};
	}

}
