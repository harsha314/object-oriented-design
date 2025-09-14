package com.designpatterns.behaviouralpatterns.mediator.formgui;

public abstract class UIComponent {
  protected FormMediator mediator;
  protected String name;

  public UIComponent(String name, FormMediator mediator) {
    this.name = name;
    this.mediator = mediator;
    this.mediator.registerComponent(this);
  }

  public abstract void changed();

  public abstract String getState();

  public abstract void setState(String state);

  public String getName() {
    return this.name;
  }
}
