package com.designpatterns.behaviouralpatterns.statepattern.musicplayer.states;

import com.designpatterns.behaviouralpatterns.statepattern.musicplayer.ui.Player;

public abstract class State {
  Player player;

  public abstract String onLock();

  public abstract String onPlay();

  public abstract String onPrevious();

  public abstract String onNext();
}
