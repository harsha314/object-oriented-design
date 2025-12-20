package com.questions.onlinemovieticketbookingsystem;

enum State {
  INIT, PENDING, SUCCESSFUL, ABORTED
};

public class PaymentsService {
  private State state = State.INIT;

}
