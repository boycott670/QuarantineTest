package com.nespresso.quarantine;

final class HealthyState extends HealthState
{

  @Override
  HealthState wait40Days()
  {
    return hasTakenInsulin() && hasTakenAntibiotic() ? new FeverState() : this;
  }

}
