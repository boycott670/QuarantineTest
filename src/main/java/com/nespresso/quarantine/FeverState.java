package com.nespresso.quarantine;

final class FeverState extends HealthState
{

  @Override
  HealthState wait40Days()
  {
    return hasTakenAspirin() || hasTakenParacetamol() ? new HealthyState() : this;
  }

}
