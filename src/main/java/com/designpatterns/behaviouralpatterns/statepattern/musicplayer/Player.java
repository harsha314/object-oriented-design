package com.designpatterns.behaviouralpatterns.statepattern.musicplayer;

import com.designpatterns.behaviouralpatterns.statepattern.musicplayer.states.State;
import com.designpatterns.behaviouralpatterns.statepattern.musicplayer.states.StateContext;

public class Player {

  private StateContext stateContext;
  private PlayerQueue queue;

  public Player() {
    this.stateContext = new StateContext();
  }

  public void playTrack(int trackId) {
    queue.playTrack(trackId);
    stateContext.setState(State.PLAYING_STATE);
  }

  public void pausePlayer() {
    if (!(stateContext.getState().equals(State.PLAYING_STATE))) {
      return;
    }
    stateContext.setState(State.PAUSED_STATE);
  }

  public void resumePlayer() {
    if (!(stateContext.getState().equals(State.PAUSED_STATE))) {
      return;
    }
    stateContext.setState(State.PLAYING_STATE);
  }

  public void lockPlayer() {
    if (!(stateContext.getState().equals(State.PLAYING_STATE))) {
      return;
    }
    stateContext.setState(State.LOCKED_STATE);
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
