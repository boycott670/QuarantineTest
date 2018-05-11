package com.nespresso.quarantine;

final class DiabeticsState extends HealthState
{

  @Override
  HealthState wait40Days()
  {
    return !hasTakenInsulin() ? new DeadState() : this;
  }

}
