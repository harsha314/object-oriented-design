package com.designpatterns.behaviouralpatterns.mediator.formgui;

public class Demo {
  public static void main(String[] args) {
    FormMediator mediator = new RegistrationFormMediator();

    TextField username = new TextField("username", mediator);
    TextField email = new TextField("email", mediator);
    Checkbox terms = new Checkbox("terms", mediator);
    Button submit = new Button("submit", mediator);

    System.out.println("\nInitial State:");
    System.out.println("Submit button is disabled");

    System.out.println("\nFilling username...");
    username.setText("john_doe");

    System.out.println("\nFilling email");
    email.setText(("john@example.com"));

    System.out.println("\nChecking terms");
    terms.setChecked(true);

    System.out.println("\nUnchecking terms");
    terms.setChecked(false);

    System.out.println("\nChecking terms again...");
    terms.setChecked(true);
  }
}
