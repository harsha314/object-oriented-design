package com.designpatterns.structuralpatterns.bridge.devicecontroller;

public class TV implements Device {

  private boolean enabled;
  private int volume;
  private int channel;

  @Override
  public boolean isEnabled() {
    return this.enabled;
  }

  @Override
  public void enable() {
    this.enabled = true;
  }

  @Override
  public void disable() {
    this.enabled = false;
  }

  @Override
  public int getVolume() {
    return this.volume;
  }

  @Override
  public void setVolume(int volume) {
    this.volume = volume;
  }

  @Override
  public int getChannel() {
    return this.channel;
  }

  @Override
  public void setChannel(int channel) {
    this.channel = channel;
  }

}
