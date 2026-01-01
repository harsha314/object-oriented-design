package com.designpatterns.behaviouralpatterns.statepattern.musicplayer.states;

public class StateContext {
  private State state;

  public StateContext() {
    this.state = new ReadyState();
  }

  public State getState() {
    return this.state;
  }

  public void setState(State state) {
    this.state = state;
  }
}
