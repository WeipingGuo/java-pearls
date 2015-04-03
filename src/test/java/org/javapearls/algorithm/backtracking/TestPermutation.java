package org.javapearls.algorithm.backtracking;

import org.junit.Test;

public class TestPermutation {
  
  @Test
  public void testPermutation(){
      System.out.println("permutations of abc:");
      Permutation.permutate("abc");

      System.out.println("permutations of abcdefg:");
      Permutation.permutate("abcdefg");  
  }

}
