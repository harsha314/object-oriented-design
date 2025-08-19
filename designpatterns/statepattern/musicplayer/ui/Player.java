package designpatterns.statepattern.musicplayer.ui;

import java.util.ArrayDeque;
import java.util.Queue;

import designpatterns.statepattern.musicplayer.states.ReadyState;
import designpatterns.statepattern.musicplayer.states.State;

public class Player {
  private State state;
  private boolean playing;
  private Queue<String> playlist;

  public Player() {
    this.state = new ReadyState();
    this.playing = false;
    this.playlist = new ArrayDeque<>();
    for (int i = 0; i < 10; ++i)
      this.playlist.add("track-" + i);
  }

  public void changeState(State state) {
    this.state = state;
  }

  public State getState() {
    return this.state;
  }

  public void setPlaying(boolean playing) {
    this.playing = playing;
  }

  public boolean getPlaying() {
    return this.playing;
  }

}
