package org.javapearls.algorithm.dp.basic;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLongestIncreasingSubsequence {

  @Test(expected=IllegalArgumentException.class)
  public void testComputeNullInput(){
    LongestIncreasingSubsequence.compute(null);
  }
  
  @Test
  public void testComputeEmptyArray(){
    int[] a = new int[0];
    int lis = LongestIncreasingSubsequence.compute(a);
    assertTrue(lis == 0);
  }
  
  @Test
  public void testComputeSingleElement(){
    int[] a = {1};
    int lis = LongestIncreasingSubsequence.compute(a);
    assertTrue(lis == 1);
  }
  
  @Test
  public void testComputeAllIncreasing(){
    int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
    int lis = LongestIncreasingSubsequence.compute(a);
    assertTrue(lis == a.length);
  }
  
  @Test
  public void testComputeAllDecreasing(){
    int[] a = {5, 4, 3, 2, 1};
    int lis = LongestIncreasingSubsequence.compute(a);
    assertTrue(lis == 1);
  }
  
  @Test
  public void testCompute() {
    int[] a = {2, 4, 3, 5, 1, 7, 6, 9, 8};
    int lis = LongestIncreasingSubsequence.compute(a);
    assertTrue(lis == 5);
  }

}
