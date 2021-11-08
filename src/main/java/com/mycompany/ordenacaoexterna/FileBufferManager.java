/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ordenacaoexterna;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

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
    Buffer bufferWithMinValue = buffers.get(0);
    
    for(Buffer buffer : buffers) {
      Integer value = buffer.peek();
      if(!buffer.isEnd()) {
        if(value < bufferWithMinValue.peek()) {
          bufferWithMinValue = buffer;
        }
      }
    }
    
    Integer minValue = bufferWithMinValue.peek();
    
    for(Buffer buffer : buffers) {
      Integer value = buffer.peek();
      if(!buffer.isEnd()) {
        if(minValue == value) {
          buffer.readValueOnBuffer();
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
