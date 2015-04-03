package org.javapearls.algorithm.dp.basic;

public class LongestCommonSequence {

	/**
	 * longest common subsequence
	 */
	 public static int lcsLen(String x, String y){

		 if (x == null || x.isEmpty() || y == null || y.isEmpty()){
	         return 0;
	     }
	     if (x.equals(y)){
	         return x.length();
	     }

	     int[][] counts = lcsLen(x.toCharArray(), y.toCharArray());

	     return counts[counts.length - 1][counts[0].length - 1];
	 }

	 public static int[][] lcsLen(char[] a, char[] b){

		 int rows = a.length + 1 , columns = b.length + 1;
	     int[][] counts = new int[rows][columns];
	     for (int i = 1; i < rows; i++){
	    	 for (int j = 1; j < columns; j++){
	    		 if (a[i-1] == b[j-1]){
	    			 counts[i][j] = counts[i-1][j-1] + 1;
	    		 } else {
	    			 counts[i][j] = Math.max(counts[i-1][j], counts[i][j-1]);
	    		 }
	    	 }
	     }

	     print(counts);
	     return counts;
	 }

	 public static String lcsBackTrack(String x, String y){

		 char[] a = x.toCharArray(), b = y.toCharArray();

		int[][] counts = lcsLen(a, b);
		return lcsBackTrack(counts, a, b, a.length - 1, b.length - 1);
	 }

	 public static String lcsBackTrack(int[][] counts, char[] a, char[] b, int i, int j){

		 if (i < 0 || j < 0){
			 return "";
		 }

		 if (a[i] == b[j]){
			 return lcsBackTrack(counts, a, b, i-1, j-1) + a[i];
		 }else if (counts[i][j+1] > counts[i+1][j]){
			 return lcsBackTrack(counts, a, b, i-1, j);
		 }else {
			 return lcsBackTrack(counts, a, b, i, j-1);
		 }

	 }


	 /**
	  * space is reduce to 2 * min(m,n)
	  *
	  * @param x
	  * @param y
	  * @return
	  */
	 public static int lcsLenCompact(String x, String y){

		 if (x == null || x.isEmpty() || y == null || y.isEmpty()){
	         return 0;
	     }
	     if (x.equals(y)){
	         return x.length();
	     }

	     // let x always be the shorter one
	     if (x.length() > y.length()){
	    	 String tmp = y;
	    	 y = x;
	    	 x = tmp;
	     }

	     int len = Math.min(x.length(), y.length()) + 1;
	     int[] m = new int[len], n = new int[len];
	     for (int i = 1; i <= y.length(); i++){
	    	 for (int j = 1; j <= x.length(); j++){
	    		 if (y.charAt(i-1) == x.charAt(j-1)){
	    			 n[j] = m[j-1] + 1;
	    		 } else {
	    			 n[j] = Math.max(n[j-1], m[j]);
	    		 }
	    	 }
	    	 System.out.println("after row " + (i-1));
	    	 print(m);
	    	 print(n);

	    	 if (i < y.length()){
	    		 // swap m and n
		    	 int[] tmp = m;
		    	 m = n;
		    	 n = tmp;
	    	 }
	     }
	     return n[len-1];
	 }

	 public static void print(int[] a){
		 for (int i = 0; i < a.length; i++){
	    	 System.out.print(a[i] + " ");
	     }
		 System.out.print("\n");
	 }

	 public static void print(int[][] a){
		 // print out the matrix
	     for (int i = 0; i < a.length; i++){
	    	 for (int j = 0 ; j < a[0].length; j++){
	    		 System.out.print(a[i][j] + " ");
	    	 }
	    	 System.out.print("\n");
	     }
	 }

}
