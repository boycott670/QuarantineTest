package com.training.hospital;

import com.training.hospital.state.State;

final class Patient
{
  private State state;

  Patient(State state)
  {
    this.state = state;
  }

  void wait40Days()
  {
    state = state.wait40Days();
  }

  void aspirin() throws ParacetamolMixedWithAspirinException
  {
    state.aspirin();
  }

  void antibiotic()
  {
    state.antibiotic();
  }

  void insulin()
  {
    state.insulin();
  }

  void paracetamol() throws ParacetamolMixedWithAspirinException
  {
    state.paracetamol();
  }

  void kill()
  {
    state = State.deadState();
  }

  State getStateForReport()
  {
    return state.copyForReport();
  }
}
