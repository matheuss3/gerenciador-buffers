/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ordenacaoexterna;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author matheus
 */
public class Buffer {

  /**
   * @return the freeSpace
   */
  public int getFreeSpace() {
    return freeSpace;
  }

  private File file;
  private FileReader fr;
  private BufferedReader br;
  public boolean fileEnd;
  private int readValues;

  private ArrayList<Integer> buffer;
  private int freeSpace;

  public Buffer(String fileName, int length) throws IOException {
    file = new File(fileName);
    if (!file.exists()) {
      throw new IOException("Arquivo inexistente!");
    }

    readValues = 0;
    freeSpace = length;
    fileEnd = false;
    fr = new FileReader(file);
    br = new BufferedReader(fr);

    buffer = new ArrayList<>();
  }

  private void load() {
    try {
      String line = br.readLine();
      while (line != null && containsSpace()) {
        insertValueOnBuffer(Integer.parseInt(line));
        if (!containsSpace()) {
          break;
        }
        line = br.readLine();
      }

      if (line == null) {
        fileEnd = true;
        fr.close();
        br.close();
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  private void insertValueOnBuffer(int value) {
    buffer.add(value);
    freeSpace--;
    readValues++;
  }
  
  public Integer peek() {
    if (buffer.isEmpty() && !fileEnd) {
      load();
    }
    
    if (isEnd()) {
      return null;
    }
    
    return buffer.get(0);
  }
  
  public Integer readValueOnBuffer() {
    if (buffer.isEmpty() && !fileEnd) {
      load();
    }
    
    if (isEnd()) {
      return null;
    }
    
    freeSpace++;
    int value = buffer.remove(0);
    return value;
  }

  public boolean containsSpace() {
    return freeSpace > 0;
  }
  
  public boolean isEnd() {
    return fileEnd && buffer.isEmpty();
  }

}
