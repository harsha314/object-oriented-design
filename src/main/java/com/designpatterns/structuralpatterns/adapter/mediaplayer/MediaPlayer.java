package com.designpatterns.structuralpatterns.adapter.mediaplayer;

public class MediaPlayer {
  private Mp3Player player;

  public MediaPlayer(Mp3Player player) {
    this.player = player;
  }

  public void playMusic(String fileName) {
    this.player.playMusic(fileName);
  }

  public void stopMusic() {
    this.player.stopMusic();
  }

  public void setPlayer(Mp3Player player) {
    this.player = player;
  }
}
