package com.nespresso.quarantine;

final class DeadState extends HealthState
{

  @Override
  HealthState wait40Days()
  {
    return this;
  }

}
