package com.designpatterns.behaviouralpatterns.statepattern.musicplayer.states;

public abstract class State {

  public static State READY_STATE = new ReadyState();
  public static State PLAYING_STATE = new PlayingState();
  public static State PAUSED_STATE = new PausedState();
  public static State LOCKED_STATE = new LockedState();

  public abstract void lock();

  public abstract void play();

  public abstract void pause();

  public abstract void resume();
}
