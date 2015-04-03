package org.javapearls.algorithm.numbers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Numbers {


	/**
	 * Given an unsorted integer array, find the first missing positive integer.
	 * For example,
	 * Given [1,2,0] return 3,
	 * and [3,4,-1,1] return 2.
	 * Your algorithm should run in O(n) time and uses constant space.
	 */
	public static int firstMissingPositiveNumber(int[] array){

		if (array == null || array.length == 0){
			return -1;
		}

		BitSet bs = new BitSet();
		for (int i = 0; i < array.length; i++){
			if (array[i] < 0){
				continue;
			}
			bs.set(array[i]);
		}

		int missed = -1;
		for (int i = 1; i < bs.length(); i++){
			if (!bs.get(i)){
				missed = i;
				break;
			}
		}
		if (missed == -1){
			missed = bs.length();
		}

		return missed;
	}

	/**
	 * O(nlogn) solution
	 *
	 * @param array
	 * @return
	 */
	public static int firstMissingPositiveNumberBySort(int[] array){

		if (array == null || array.length == 0){
			return -1;
		}

		Arrays.sort(array);

		int missed = 1;
		for (int i = 0; i < array.length; i++){
			if (array[i] <= 0){
				continue;
			}
			if (array[i] == missed){
				missed++;
			}
		}

		return missed;
	}

	public static int firstMissingPositiveNumberConstant(int[] array){

		if (array == null || array.length == 0){
			return -1;
		}

		// put positive number into correct position
		for (int i = 0; i < array.length; i++){

			if (array[i] > 0 && array[i] < array.length)
            {
                if (array[i]-1 != i && array[array[i]-1] != array[i])
                {
                    int temp = array[array[i]-1];
                    array[array[i]-1] = array[i];
                    array[i] = temp;
                    --i;
                }
            }
		}

		for (int j=0; j<array.length; ++j)
            if (array[j]-1 != j)
               return j+1;

        return array.length+1;
	}

	/**
	 * An array contains integers, some appears multiple times,
	 * some appear once, find the first one which only appears once
	 *
	 * [2,4,5,4,2,-3, 10, 5, 6, 6, 5]
	 *
	 * answer is -3
	 *
	 * @param array
	 * @return
	 */
	public static int firstUniqueNumber(int[] array){

		if (array == null || array.length == 0){
			throw new IllegalArgumentException("empty array");
		}

		Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++){
			Integer c = counts.get(array[i]);
			if (c == null){
				counts.put(array[i], 1);
			}else{
				counts.put(array[i], ++c);
			}
		}

		// go through the list again
		for (int i = 0; i< array.length; i++){
			Integer c = counts.get(array[i]);
			if (c == 1){
				return array[i];
			}
		}

		throw new IllegalArgumentException("array does not contain unique number");
	}


	/**
	 * Given an array size of N, contains numbers 1 - N
	 * two numbers are set to 0, find those two numbers
	 *
	 * [2, 4, 0, 6, 7, 0, 3]
	 * answer: 1, 5
	 *
	 * @param array
	 * @return
	 */
	public static List<Integer> missingNumbers(int[] array){

		if (array == null || array.length == 0){
			throw new IllegalArgumentException("empty input array");
		}

		// bucket sort, a[i] should be place to a[a[i]-1]
		int i = 0;
		while (i < array.length){
			while (array[i] != (i+1) && array[i] != 0){
				swap(array, i, array[i] - 1);
			}
			i++;
		}

		print(array);

		List<Integer> result = new ArrayList<Integer>();
		// go through again to find out where 0 is located
		for (int j = 0; j < array.length; j++){
			if (array[j] == 0){
				result.add(j+1);
			}
		}

		return result;
	}


	public static BigDecimal squareRoot(int number, int precision){
		return newton(number, precision);
	}

	private static BigDecimal newton(int number, int precision){

		int i = 0;

		BigDecimal bigNumber  = new BigDecimal(number);
		BigDecimal two = new BigDecimal(2);
		BigDecimal start = new BigDecimal(number);
		while ( i < precision){

			System.out.println("precision = " + i);

			BigDecimal fx = start.multiply(start).subtract(bigNumber);
			System.out.println("fx = " + fx.toString());
			BigDecimal fxp = start.multiply(two);
			System.out.println("fxp = " + fxp.toString());

			BigDecimal res = start.subtract(fx.divide(fxp, fx.scale() + 1, 0));

			if (res.precision() >= precision){
				return res;
			}
			start = res;
			i = start.precision();
		}

		return start;
	}


	private static void print(int[] array){
		for (int i = 0; i < array.length; i++){
			System.out.print(array[i] + ",");
		}
		System.out.println();
	}

	private static void swap(int[] array, int i, int j){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

}
