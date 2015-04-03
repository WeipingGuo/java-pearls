package org.javapearls.algorithm.ordering;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Reservoir sampling is a family of randomized algorithms for
 * randomly choosing a sample of k items from a list S containing n items,
 * where n is either a very large or unknown number.
 * Typically n is large enough that the list doesn't fit into main memory.
 *
 */
public class ReservoirSampling {

	/**
	 * select K elements from a list of S
	 *
	 * @param s
	 * @param k
	 * @return
	 */
	public static String[] randomElement(String[] all, int k){

		String[] result = new String[k];
		for (int i = 0; i < all.length; i++){
			String s = all[i];

			// init result for the first k element
			if (i < k){
				result[i] = s;
			}else{
				// replace it with random selected element
				int j = random(i);
				if (j < k){
					result[j] = s;
				}
			}
		}
		return result;
	}


	public static String[] randomKElement(String[] all, int k){

		String[] result = new String[k];

		// randomly generated k element between 0 -- all.length() -1
		Set<Integer> set = new HashSet<Integer>();
		while (set.size() < k){
			int index = random(all.length) - 1;
			if (set.contains(index)){
				continue;
			}else{
				set.add(index);
			}
		}

		// go through the list, if the index belongs
		// to the randomly generated set
		int index = 0;
		for (int i = 0; i < all.length; i++){
			if (set.contains(i)){
				result[index++] = all[i];
			}
		}

		return result;
	}


	/**
	 * randomly generate a number between (1, max) (inclusive)
	 * Choose an integer between 0 and index (inclusive)
	 *
	 * @param max
	 * @return
	 */
	public static int random(int range){
		return (int)(Math.random()* (range + 1));
	}

}
