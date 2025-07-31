package designpatterns.statepattern.states;

import designpatterns.statepattern.ui.Player;

public abstract class State {
  Player player;

  public abstract String onLock();

  public abstract String onPlay();

  public abstract String onPrevious();

  public abstract String onNext();
}
