package com.designpatterns.behaviouralpatterns.mediator.formgui;

public class Checkbox extends UIComponent {
  private boolean checked = false;

  public Checkbox(String name, FormMediator mediator) {
    super(name, mediator);
  }

  public void setChecked(boolean checked) {
    this.checked = checked;
    this.changed();
  }

  public boolean isChecked() {
    return this.checked;
  }

  @Override
  public void changed() {
    this.mediator.componentChanged(this);
  }

  @Override
  public String getState() {
    return String.valueOf(checked);
  }

  public void setState(String state) {
    this.checked = Boolean.parseBoolean(state);
  }

}
