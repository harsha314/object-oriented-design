package com.designpatterns.behaviouralpatterns.statepattern.musicplayer;

import java.util.ArrayList;
import java.util.List;

public class PlayerQueue {
  private List<Integer> queue = new ArrayList<>();
  private int currentlyPlayingIndex = -1;

  public void playTrack(int trackId) {
    queue.add(trackId);
    this.clearQueue();
    currentlyPlayingIndex = queue.size() - 1;
  }

  private void clearQueue() {
    for (int i = queue.size() - 1; i > currentlyPlayingIndex; --i) {
      queue.remove(i);
    }
  }

  public void playNext() {
    if (currentlyPlayingIndex >= queue.size() - 1) {
      return;
    }
    ++currentlyPlayingIndex;
    System.out.println("Playing Next : " + queue.get(currentlyPlayingIndex));
  }

  public void playPrevious() {
    if (currentlyPlayingIndex == 0) {
      return;
    }
    --currentlyPlayingIndex;
    System.out.println("Playing Previous : " + queue.get(currentlyPlayingIndex));
  }

  public void addToFirst(int trackId) {
    queue.add(currentlyPlayingIndex + 1, trackId);
  }

  public void addToLast(int trackId) {
    queue.add(trackId);
  }
}
