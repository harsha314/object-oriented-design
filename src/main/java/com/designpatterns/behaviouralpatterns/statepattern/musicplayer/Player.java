package com.designpatterns.behaviouralpatterns.statepattern.musicplayer;

import com.designpatterns.behaviouralpatterns.statepattern.musicplayer.states.StateContext;

public class Player {

  private StateContext stateContext;
  private PlayerQueue queue;

  public Player() {
    this.stateContext = new StateContext();
    this.queue = new PlayerQueue();
  }

  public void playTrack(int trackId) {
    queue.playTrack(trackId);
    stateContext.play();
  }

  public void pausePlayer() {
    stateContext.pause();
  }

  public void resumePlayer() {
    stateContext.resume();
  }

  public void lockPlayer() {
    stateContext.lock();
  }

  public void playNext() {
    queue.playNext();
  }

  public void playPrevious() {
    queue.playPrevious();
  }

  public void addToQueueFirst(int trackId) {
    queue.addToFirst(trackId);
  }

  public void addToQueueLast(int trackId) {
    queue.addToLast(trackId);
  }
}
