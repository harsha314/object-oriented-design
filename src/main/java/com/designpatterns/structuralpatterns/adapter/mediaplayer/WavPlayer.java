package com.designpatterns.structuralpatterns.adapter.mediaplayer;

public class WavPlayer {
  public void playWav(String fileName) {
    System.out.println("Playing " + fileName + " song");
  }

  public void stopWav() {
    System.out.println("Stopped playing wav file");
  }
}
