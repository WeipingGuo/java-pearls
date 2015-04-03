package org.javapearls.datastructure.array;

public class SubArray {


	/**
	 * Find a sub-array which sum is the maximum among for the sub-array
	 *
	 * Similar question: stock purchase, maximum the profit.
	 * difference between daily prices
	 *
	 * @param a
	 * @return
	 */
	public SubSum findMaxSubArray(int[] a, int left, int right){

		if (left == right){
			return new SubSum(left, right, a[left]);
		}

		int middle = left + (right - left)/2;
		SubSum leftSubSum = findMaxSubArray(a, left, middle);
		SubSum rightSubSum = findMaxSubArray(a, middle + 1, right);
		SubSum crossSubSum = findMaxCrossArray(a, left, middle, right);

		System.out.println(leftSubSum.sum + "," + rightSubSum.sum + "," + crossSubSum.sum);

		if (leftSubSum.sum >= rightSubSum.sum && leftSubSum.sum >= crossSubSum.sum){
			return leftSubSum;
		}
		if (rightSubSum.sum >= leftSubSum.sum && rightSubSum.sum >= crossSubSum.sum){
			return rightSubSum;
		}
		return crossSubSum;
	}


	public SubSum findMaxCrossArray(int[] a, int left, int middle, int right){

		int leftMax = a[middle];
		int leftSum = a[middle];
		int leftMaxIndex = middle;
		for(int i = middle - 1; i >= left; i--){
			leftSum += a[i];

			if (leftSum > leftMax){
				leftMax = leftSum;
				leftMaxIndex = i;
			}
		}

		int rightMax = a[middle + 1];
		int rightSum = a[middle + 1];
		int rightMaxIndex = middle + 1;
		for (int j = middle + 2; j <= right; j++){
			rightSum += a[j];
			if (rightSum > rightMax){
				rightMax = rightSum;
				rightMaxIndex = j;
			}
		}

		return new SubSum(leftMaxIndex, rightMaxIndex, leftMax + rightMax);
	}

	class SubSum {
		int from;
		int to;
		int sum;
		public SubSum(int from, int to, int sum){
			this.from = from;
			this.to = to;
			this.sum = sum;
		}
	}

}
