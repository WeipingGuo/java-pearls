package org.javapearls.algorithm.backtracking;

/**
 * Given a set X of positive integers and target integer T, is there
 * a subset of elements in X that add up to T?
 *  
 * @author wguo
 *
 */
public class SubsetSum {
  
  public static boolean foundSubsetSum(int[] a, int target){
    if (a == null){
      throw new IllegalArgumentException("null array");
    }
    return subsetSum(a, a.length - 1, target);
  }
  
  /**
   * is a subset in a[0 ... n] which sum to target?
   * 
   * @param a
   * @param n
   * @param target
   * @return
   */
  private static boolean subsetSum(int[] a, int n, int target){
    
    // the sum for empty set is zero
    if (target == 0){
      return true;
    }
    if (target < 0){
      return false;
    }
    if (n < 0){
      return false;
    }

    // either include a[n] or not
    boolean notIncluded = subsetSum(a, n-1, target);
    boolean included = subsetSum(a, n-1, target - a[n]);  
    return (notIncluded || included);
  }

}
