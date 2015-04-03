package org.javapearls.foundation;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestArrayClone {
  
  @Test
  public void testArrayClone(){
    
    // array clone
    int[] a = {10, 11, 30, 500};
    int[] b = a.clone();
    
    assertFalse(a == b);
    assertTrue(a.length == b.length);
    assertArrayEquals(a, b);
  }
}
