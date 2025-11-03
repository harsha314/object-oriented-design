package com.designpatterns.structuralpatterns.adapter.mediaplayer;

public class AudioAdapter implements Mp3Player {
  private WavPlayer wavPlayer;

  public AudioAdapter(WavPlayer wavPlayer) {
    this.wavPlayer = wavPlayer;
  }

  @Override
  public void playMusic(String fileName) {
    this.wavPlayer.playWav(fileName);
  }

  @Override
  public void stopMusic() {
    this.wavPlayer.stopWav();
  }
}
