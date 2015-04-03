package org.javapearls.algorithm.dp.basic;

import java.util.Deque;
import java.util.LinkedList;


/**
 * define Li as the longest increasing subsequence for element at i
 * then Li = max (Lj + 1) for 0<=j<i & Sj < Si
 * 
 * @author wguo
 *
 */
public class LongestIncreasingSubsequence {
  
  public static int compute(int[] a){
    
    if (a == null){
      throw new IllegalArgumentException("null array");
    }
    if (a.length == 0){
      return 0;
    }
    
    // an array to store steps and init it
    Cell[] cells = new Cell[a.length];
    for (int i = 0; i < cells.length; i++){
      cells[i] = new Cell(i, 1, -1);
    }
    
    // track the max LIS
    Cell maxCell = cells[0];
    for (int i = 0; i < a.length; i++){
      
      // find the max lis up to Si-1 
      Cell localMax = null;
      for (int j = 0; j < i; j++){
        if (a[j] < a[i] && (localMax == null || localMax.getLis() < cells[j].getLis())){
          localMax = cells[j];          
        }
      }      
      if (localMax != null){
        cells[i].setLis(localMax.getLis()  + 1 );
        cells[i].setPred(localMax.getIndex());
      }
      
      // update the max cell if needed
      if (cells[i].getLis() > maxCell.getLis()){
        maxCell = cells[i];
      }
      
    }
    
    // backtracking
    backTracking(cells, maxCell, a);
    return maxCell.lis;
  }
  
  
  private static void backTracking(Cell[] cells, Cell maxCell, int[] a){
    
    Cell cell = maxCell;
    Deque<Integer> stack = new LinkedList<Integer>();
    while (true){
      stack.push(a[cell.index]);
      if (cell.getPred() == -1){
        break;
      }
      cell = cells[cell.pred];
    }
    
    while (!stack.isEmpty()){
      System.out.print(stack.pop() + ",");
    }
    System.out.println();
  }

private static class Cell {
  private int index;             // Si
  private int lis = 1;           // the LIS at Si
  private int pred = -1;         // precedence  
  
  public Cell(int index, int lis, int pred){
    this.index = index;
    this.lis = lis;
    this.pred = pred;
  }
  public int getIndex() {
    return index;
  }
  public int getLis() {
    return lis;
  }
  public void setLis(int lis) {
    this.lis = lis;
  }
  public int getPred() {
    return pred;
  }
  public void setPred(int pred) {
    this.pred = pred;
  }
}

}
