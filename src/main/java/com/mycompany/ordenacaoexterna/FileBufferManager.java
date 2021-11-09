/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ordenacaoexterna;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author matheus
 */
public class FileBufferManager {
  int numberBuffers;
  ArrayList<Buffer> buffers;

  public FileBufferManager(ArrayList<String> filesNames, 
          int lengthBuffers) throws IOException {

    numberBuffers = filesNames.size();
    buffers = new ArrayList<>();
    
    for (String fileName : filesNames) {
      Buffer buffer = new Buffer(fileName, lengthBuffers);
      buffers.add(buffer);
    }
  }
  
  
  public Integer readBufferMinValue() {
    Integer minValue = null;
    
    for(Buffer buffer : buffers) {
      Integer value = buffer.peek();
      if(!buffer.isEnd()) {
        if(minValue == null || minValue.compareTo(value) > 0) {
          minValue = value;
        }
      }
    }
    
    if (minValue == null) return minValue;
    
    boolean flag = true;
    int i = 0;
    while (flag) {
      flag = false;
      
      for(Buffer buffer : buffers) {
        Integer value = buffer.peek();
        if(!buffer.isEnd()) {
          if(minValue.equals(value)) {
            /*if (minValue == 128) {
              System.out.println(minValue);
              System.out.println(++i);
            }*/
            buffer.readValueOnBuffer();
            flag = true;
          }
        }
      }
    
    
    }
    
    return minValue;
  }
  
  public boolean allBuffersEnds() {
    for(Buffer buffer : buffers) {
      if(!buffer.isEnd()) return false;
    }
    
    return true;
  }
}
