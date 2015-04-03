package org.javapearls.algorithm.backtracking;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSubsetSum {
  
  @Test(expected=IllegalArgumentException.class)
  public void testNullArray(){
    SubsetSum.foundSubsetSum(null, 100);
  }

  @Test
  public void testEmptyArray(){
    int[] a = new int[0];
    assertFalse(SubsetSum.foundSubsetSum(a, 10));
    assertTrue(SubsetSum.foundSubsetSum(a, 0));
    assertFalse(SubsetSum.foundSubsetSum(a, -1));
  }

  @Test
  public void testSingleElementArray(){
    int[] a = {10};
    assertFalse(SubsetSum.foundSubsetSum(a, 5));
    assertTrue(SubsetSum.foundSubsetSum(a, 10));
    assertTrue(SubsetSum.foundSubsetSum(a, 0));
    assertFalse(SubsetSum.foundSubsetSum(a, -1));
  }
  
  @Test
  public void testGeneralCase(){
    int[] a = {1, 5, 8, 2, 4};
    
    assertTrue(SubsetSum.foundSubsetSum(a, 0));
    assertTrue(SubsetSum.foundSubsetSum(a, 1));
    assertTrue(SubsetSum.foundSubsetSum(a, 5));
    assertTrue(SubsetSum.foundSubsetSum(a, 8));
    assertTrue(SubsetSum.foundSubsetSum(a, 2));
    assertTrue(SubsetSum.foundSubsetSum(a, 4));
    
    // two elements
    assertTrue(SubsetSum.foundSubsetSum(a, 6));
    assertTrue(SubsetSum.foundSubsetSum(a, 9));
    assertTrue(SubsetSum.foundSubsetSum(a, 12));
    
    // three elements
    assertTrue(SubsetSum.foundSubsetSum(a, 14));
    assertTrue(SubsetSum.foundSubsetSum(a, 11));
    
    // four elements
    assertTrue(SubsetSum.foundSubsetSum(a, 16));
    assertTrue(SubsetSum.foundSubsetSum(a, 19));
    
    // five elements
    assertTrue(SubsetSum.foundSubsetSum(a, 20));
  }
  
}
