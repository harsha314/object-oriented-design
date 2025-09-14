package com.designpatterns.behaviouralpatterns.mediator.formgui;

public interface FormMediator {
  void componentChanged(UIComponent component);

  void registerComponent(UIComponent component);
}
