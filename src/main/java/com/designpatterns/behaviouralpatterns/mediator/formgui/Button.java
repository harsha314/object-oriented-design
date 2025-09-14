package com.designpatterns.behaviouralpatterns.mediator.formgui;

public class Button extends UIComponent {
  private boolean enabled = false;

  public Button(String name, FormMediator mediator) {
    super(name, mediator);
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
    // this.changed();
    System.out.printf("%s is now %s%n", this.name, this.getState());
  }

  public boolean isEnabled() {
    return this.enabled;
  }

  @Override
  public void changed() {
    this.mediator.componentChanged(this);
  }

  @Override
  public String getState() {
    return String.valueOf(enabled);
  }

  @Override
  public void setState(String state) {
    this.enabled = Boolean.parseBoolean(state);
  }

}
