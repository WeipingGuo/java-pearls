package org.javapearls.algorithm.dp.basic;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCoinsSum {
  
  @Test(expected=IllegalArgumentException.class)
  public void testNullCoinsSet(){
    CoinSum.findCoinSum(null, 0);
  }
  
  @Test
  public void testEmptyCoinSet(){
    
    int[] coins = new int[0];    
    assertTrue(CoinSum.findCoinSum(coins, 0) == 0);
    assertTrue(CoinSum.findCoinSum(coins, 1) == Integer.MAX_VALUE);
  }
  
  @Test
  public void testSingleCoin(){
    int[] coins = {5};
    assertTrue(CoinSum.findCoinSum(coins, 5) == 1);
    assertTrue(CoinSum.findCoinSum(coins, 10) == 2);
    assertTrue(CoinSum.findCoinSum(coins, 1) == Integer.MAX_VALUE); 
    assertTrue(CoinSum.findCoinSum(coins, 6) == Integer.MAX_VALUE); 
  }
  
  @Test
  public void testGeneral(){
    int[] coins = {1, 3, 5};
    assertTrue(CoinSum.findCoinSum(coins, 1) == 1);
    assertTrue(CoinSum.findCoinSum(coins, 2) == 2);
    assertTrue(CoinSum.findCoinSum(coins, 3) == 1);
    assertTrue(CoinSum.findCoinSum(coins, 4) == 2);
    assertTrue(CoinSum.findCoinSum(coins, 5) == 1);
    assertTrue(CoinSum.findCoinSum(coins, 6) == 2);
    assertTrue(CoinSum.findCoinSum(coins, 7) == 3);
    assertTrue(CoinSum.findCoinSum(coins, 8) == 2);
    assertTrue(CoinSum.findCoinSum(coins, 9) == 3);
    assertTrue(CoinSum.findCoinSum(coins, 10) == 2);
    assertTrue(CoinSum.findCoinSum(coins, 11) == 3);
  }
  
}
