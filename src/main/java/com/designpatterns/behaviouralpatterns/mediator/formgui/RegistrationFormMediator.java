package com.designpatterns.behaviouralpatterns.mediator.formgui;

import java.util.HashMap;
import java.util.Map;

public class RegistrationFormMediator implements FormMediator {
  private Map<String, UIComponent> components = new HashMap<>();
  private TextField usernameField;
  private TextField emailField;
  private Checkbox termsCheckbox;
  private Button submitButton;

  @Override
  public void registerComponent(UIComponent component) {
    this.components.put(component.getName(), component);
    System.out.println(component.getName());
    switch (component.getName()) {
      case "username":
        this.usernameField = (TextField) component;
        break;
      case "email":
        this.emailField = (TextField) component;
        break;
      case "terms":
        this.termsCheckbox = (Checkbox) component;
        break;
      case "submit":
        this.submitButton = (Button) component;
        break;
    }
  }

  @Override
  public void componentChanged(UIComponent component) {
    this.validateForm();
  }

  private void validateForm() {
    boolean isValid = !this.usernameField.isEmpty() &&
        !this.emailField.isEmpty() &&
        this.termsCheckbox.isChecked();

    submitButton.setEnabled(isValid);
  }

}
