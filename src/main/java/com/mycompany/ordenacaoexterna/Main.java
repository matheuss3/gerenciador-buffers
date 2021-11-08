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
      FileWriter fw = new FileWriter("tests/test-file");
      BufferedWriter bw = new BufferedWriter(fw);
      
      ArrayList<String> files = new ArrayList<>();
      files.add("tests/V1");
      files.add("tests/V2");
      files.add("tests/V3");


      FileBufferManager fbm = new FileBufferManager(files, 1);
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
