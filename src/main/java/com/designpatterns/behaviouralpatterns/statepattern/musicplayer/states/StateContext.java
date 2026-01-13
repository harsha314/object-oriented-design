package com.designpatterns.behaviouralpatterns.statepattern.musicplayer.states;

public class StateContext {
  private State state;

  private static State READY_STATE = new ReadyState();
  private static State PLAYING_STATE = new PlayingState();
  private static State PAUSED_STATE = new PausedState();
  private static State LOCKED_STATE = new LockedState();

  public StateContext() {
    this.state = new ReadyState();
  }

  public State getState() {
    return this.state;
  }

  public void setState(State state) {
    this.state = state;
  }

  public void play() {
    if (!READY_STATE.equals(this.state)) {
      return;
    }
    this.state = PLAYING_STATE;
  }

  public void pause() {
    this.state = PAUSED_STATE;
  }

  public void resume() {
    if (!PAUSED_STATE.equals(this.state)) {
      return;
    }
    this.state = PLAYING_STATE;
  }

  public void lock() {
    if (!PLAYING_STATE.equals(this.state)) {
      return;
    }
    this.state = LOCKED_STATE;
  }
}
