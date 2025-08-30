package com.designpatterns.structuralpatterns.bridge.devicecontroller;

public class AdvancedRemote extends Remote {

  public AdvancedRemote(Device device) {
    super(device);
  }

  public void mute() {
    this.device.setVolume(0);
    System.out.println("Device muted");
  }

  public void quickSwitch(int channel) {
    this.device.setChannel(channel);
    System.out.println("Switched to channel : " + channel);
  }

}
