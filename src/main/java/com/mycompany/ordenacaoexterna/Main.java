/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.ordenacaoexterna;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author matheus
 */
public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here
    try {
      FileWriter fw = new FileWriter("test-file");
      BufferedWriter bw = new BufferedWriter(fw);
      
      ArrayList<String> files = new ArrayList<>();
      files.add("V1");
      files.add("V2");
      files.add("V3");


      FileBufferManager fbm = new FileBufferManager(files, 100);
      Integer value = fbm.readBufferMinValue();
      while (!fbm.allBuffersEnds()) {        
        bw.write(value + "\n");
        value = fbm.readBufferMinValue();
      }
      
      bw.close();
      fw.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
      
    
  }
  
}
