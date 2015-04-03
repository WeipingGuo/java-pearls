package org.javapearls.algorithm.greedy;

import static org.junit.Assert.*;

import org.javapearls.algorithm.greedy.MinimumChanges;
import org.junit.Test;

public class TestMinimumChanges {
  
  @Test(expected=IllegalArgumentException.class)
  public void testNullCoinSet(){
    MinimumChanges.makeChanges(null, 10);
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testEmptyCoinSet(){
    int[] a = new int[0];
    MinimumChanges.makeChanges(a, 10);
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testNotPossibleChanges(){
    int[] a = {5, 10, 25};
    MinimumChanges.makeChanges(a, 3);   
  }

  @Test
  public void testMakeExactChanges() {
    int[] coins = {1};
    int changes = MinimumChanges.makeChanges(coins, 100);
    assertTrue(changes == 100);
    
    int[] a = {5, 10, 25};
    changes = MinimumChanges.makeChanges(a, 75);
    assertTrue(changes == 3);
  }
  
  @Test
  public void testMakeChanges() {
    int[] coins = {1, 10, 5, 25};
    int changes = MinimumChanges.makeChanges(coins, 60);
    assertTrue(changes == 3);
    
    changes = MinimumChanges.makeChanges(coins, 55);
    assertTrue(changes == 3);
    
    changes = MinimumChanges.makeChanges(coins, 74);
    assertTrue(changes == 8);
  }
  
  
  

}
