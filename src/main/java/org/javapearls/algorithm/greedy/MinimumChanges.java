package org.javapearls.algorithm.greedy;

import java.util.Arrays;


/**
 * Given a set of coin denominators, find the minimum number of coins to make a
 * certain amount of change.
 * 
 * @author wguo
 *
 */
public class MinimumChanges {
  
  
  public static int makeChanges(int[] coins, int target){
    if (coins == null){
      throw new IllegalArgumentException("null coin set");
    }
    if (coins.length == 0 && target > 0){
      throw new IllegalArgumentException("empty coin set");
    }
    
    // let's sort coins
    Arrays.sort(coins);
    if (coins[0] > target){
      throw new IllegalArgumentException("cannot make changes");
    }
    
    // record the number of coins for each denominators
    // try the biggest one first
    int[] counts = new int[coins.length]; 
    int index = coins.length - 1;
    while (target > 0 && index >= 0){
      if (target >= coins[index]){
        counts[index] = (target/coins[index]);
        target %= coins[index];        
      }
      index--;      
    }
    
    // calculate the total
    int total = 0;
    for (int i = 0; i < counts.length; i++){
      total += counts[i];
      System.out.print(coins[i] + ":" + counts[i] + ", ");
    }
    System.out.println();
    
    return total;
  }

}
