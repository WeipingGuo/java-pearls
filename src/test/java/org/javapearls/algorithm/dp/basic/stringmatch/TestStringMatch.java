package org.javapearls.algorithm.dp.basic.stringmatch;

import org.javapearls.algorithm.dp.basic.stringmatch.StringMatch;
import org.junit.Test;

public class TestStringMatch {
  
  @Test
  public void testStringMatch(){
    int distance = StringMatch.match("abcd", "this is a long string abcd");
    System.out.println("distance is : " + distance);
  }
  
  @Test
  public void testStringMatchDP(){
    
    int distance = StringMatch.stringMatchDp("abcd", "this is a long string abcd");
    System.out.println("distance: " + distance);
    
    distance = StringMatch.stringMatchDp("abc", "abc");
    System.out.println("distance: " + distance);
    
    distance = StringMatch.stringMatchDp("abc", "adc");
    System.out.println("distance: " + distance);
  }
  
  @Test
  public void testStringMatchDPSimple(){
    int distance = StringMatch.stringMatchDp("abc", "adc");
    System.out.println("distance: " + distance);
    
    distance = StringMatch.stringMatchDp("ab", "abc");
    System.out.println("distance: " + distance);
  }

}
