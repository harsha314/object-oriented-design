package com.designpatterns.behaviouralpatterns.mediator.formgui;

public class TextField extends UIComponent {
  private String text = "";

  public TextField(String name, FormMediator mediator) {
    super(name, mediator);
  }

  public void setText(String text) {
    this.text = text;
    this.changed();
  }

  public boolean isEmpty() {
    return text.trim().isEmpty();
  }

  @Override
  public void changed() {
    mediator.componentChanged(this);
  }

  @Override
  public String getState() {
    return this.text;
  }

  @Override
  public void setState(String state) {
    this.text = state;
  }
}
