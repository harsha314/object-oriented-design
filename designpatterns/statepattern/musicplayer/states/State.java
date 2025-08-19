package designpatterns.statepattern.musicplayer.states;

import designpatterns.statepattern.musicplayer.ui.Player;

public abstract class State {
  Player player;

  public abstract String onLock();

  public abstract String onPlay();

  public abstract String onPrevious();

  public abstract String onNext();
}
