package org.javapearls.foundation.jdk7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {
  
  /**
   * resource can be closed automatically
   * 
   * @param args
   */
  public static void main(String[] args){
    
    try (BufferedReader in = new BufferedReader(new FileReader("in.tet"));
        BufferedWriter out = new BufferedWriter(new FileWriter("out.text"))        
        ){
      
      int charRead;
      while ((charRead = in.read()) != -1){
        out.write(charRead);
      }
      
    }catch (IOException e ){
      System.out.println(e.getMessage());      
    }
  }

}
