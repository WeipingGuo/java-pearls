package org.javapearls.algorithm.dp.basic.stringmatch;


public class StringMatch {
  
  public static int match(String pattern, String text){
    return match(pattern, text, pattern.length() - 1, text.length() - 1);
  }
  
  private static int match(String pattern, String text, int i, int j){
    
    if (i == 0) { return j * indel(' '); }
    if (j == 0) { return i * indel(' '); }
    
    int[] opt = new int[3];
    opt[0] = match(pattern, text, i - 1, j - 1) + match(pattern.charAt(i), text.charAt(j));
    opt[1] = match(pattern, text, i, j - 1) + indel(text.charAt(j));
    opt[2] = match(pattern, text, i - 1, j) + indel(pattern.charAt(i));
    
    return Math.min(opt[0], Math.min(opt[1], opt[2]));
  }
  
  /**
   * penalty cost for insert/delete
   * 
   * @param t
   * @return
   */
  private static int indel(char t){
    return 1;
  }
  
  /**
   * penalty cost for two string. if matched, cost is 0;
   * otherwise the cost to replace one is 1
   * 
   * @param s
   * @param t
   * @return
   */
  private static int match(char s, char t){
    if (s == t){
      return 0;
    } else {
      return 1;
    }
  }    
  
  public static enum OPS{
    match(0),
    insert(1),
    delete(2),
    none(-1);
    
    private int value;
    private OPS(int value){
      this.value = value;
    }
    public int getValue(){
       return this.value;
    }
    
  }
  
  public static class Cell{
    public int cost;                    // cost to reach this cell
    public OPS action = OPS.none;      // action to reach this cell
  }
  
  public static int stringMatchDp(String pattern, String text){
    
    // cell is store the min cost 
    int len = Math.max(pattern.length(), text.length());
    Cell[][] m = new Cell[len + 1][len + 1];
    for (int i = 0; i < len + 1; i++){
      for (int j = 0; j < len + 1; j++){
        m[i][j] = new Cell();
      }
    }
    
    // init row and column
    for (int i = 0; i < len; i++){
      initRow(m, i);
      initColumn(m, i);
    }
    
    int[] opt = new int[3];    
    for (int i = 1; i <= pattern.length(); i++) {
      for (int j = 1; j <= text.length(); j++) {
        
        opt[OPS.match.value] = m[i-1][j-1].cost + match(pattern.charAt(i-1), text.charAt(j-1));
        opt[OPS.insert.value] = m[i][j-1].cost + indel(text.charAt(j-1));
        opt[OPS.delete.value] = m[i-1][j].cost + indel(pattern.charAt(i-1));
        
        // find the min
        m[i][j].cost = opt[OPS.match.value];
        m[i][j].action = OPS.match;
        
        if (m[i][j].cost > opt[OPS.insert.value]){
          m[i][j].cost = opt[OPS.insert.value];
          m[i][j].action = OPS.insert;
        }
        
        if (m[i][j].cost > opt[OPS.delete.value]){
          m[i][j].cost = opt[OPS.delete.value];
          m[i][j].action = OPS.delete;
        }
      }
    }
    
    constructPath(pattern, text, m, pattern.length() - 1, text.length() - 1);    
    return m[pattern.length()][text.length()].cost;
  }
  
  // FIXME: still missing one of indexes, see the simple test case
  private static void constructPath(String pattern, String text, Cell[][] m, int i, int j){
    
    // base case, no more way to trace back
    if (m[i][j].action == OPS.none) return;
    
    // match
    if (m[i][j].action == OPS.match){
      constructPath(pattern, text, m, i-1, j-1);
      matchOut(pattern, text, i, j);
      return;
    }

    // insert
    if (m[i][j].action == OPS.insert){
      constructPath(pattern, text, m, i, j-1);
      insertOut(pattern, text, i, j);
      return;
    }
    
    // delete
    if (m[i][j].action == OPS.delete){
      constructPath(pattern, text, m, i-1, j);
      deleteOut(pattern, text, i, j);
      return;
    }
    
  }
  
  
  private static void matchOut(String p, String t, int i, int j){
    System.out.print(p.charAt(i) + " vs. " + t.charAt(j) + "==>");
    if (p.charAt(i) == t.charAt(j)){
      System.out.print("M");
    } else {
      System.out.print("S");
    }
    System.out.println();
  }
  
  private static void insertOut(String p, String t, int i, int j){
    System.out.println(p.charAt(i) + " vs. " + t.charAt(j) + "==>I");
  }
  
  private static void deleteOut(String p, String t, int i, int j){
    System.out.println(p.charAt(i) + " vs. " + t.charAt(j) + "==>D");
  }
  
  
  /**
   * compare an empty string against length-i string
   * 
   * @param m
   * @param i
   */
  private static void initRow(Cell[][] m, int i){
    
    m[0][i].cost = i;
    
    if (i > 0){
      m[0][i].action = OPS.insert;      
    } else {
      m[0][i].action = OPS.none;
    }
  }
  
  /**
   * compare a length-i string to an empty string 
   * 
   * @param m
   * @param i
   */
  private static void initColumn(Cell[][] m, int i){
    
    m[i][0].cost = i;
    if (i > 0) {
      m[i][0].action = OPS.delete;
    } else {
      m[i][0].action = OPS.none;
    }
  }

}
