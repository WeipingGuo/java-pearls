package org.javapearls.algorithm.dp.basic;

/**
 * Given a list of N coins, values from V1, V2, ..., Vn, and the total sum S.
 * Find the minimum number of coins the sum of which is S or report that is
 * impossible to select coins in such a way that they sum up to S.
 * 
 * Calculate all the minimum coins for target 0, 1, ..., S.
 *  
 * @author wguo
 *
 */
public class CoinSum {

  public static int findCoinSum(int[] coins, int target){
    
    // sanity check 
    if (coins == null){
      throw new IllegalArgumentException("null coins set");
    }
    
    // use an array to record the minimum number of coins sum to i
    int[] min = new int[target + 1];
    for (int i = 0; i < min.length; i++){
      min[i] = Integer.MAX_VALUE;
    }
    min[0] = 0; // 0 coins which sum to 0
    
    // calculate all the minimum number of coins sum to 1, 2, ..., target
    for (int i = 1; i <= target; i++){
      for (int j = 0; j < coins.length; j++){
        int face = coins[j];
        if (face <= i && min[i - face] != Integer.MAX_VALUE && min[i - face] + 1 < min[i]){
          min[i] = min[i - face] + 1;
        }
      }
    }
    
    return min[target];
  }
}
