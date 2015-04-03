package org.javapearls.foundation;

public class LabelBranch {
  
  
  public static void demo(int[] a, int b){
    
    search:
      for (int i = 0; i < a.length; i++){
        if (a[i] == b){
          break search;
        }
      }
  }

}
