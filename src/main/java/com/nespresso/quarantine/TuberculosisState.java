package com.nespresso.quarantine;

final class TuberculosisState extends HealthState
{

  @Override
  HealthState wait40Days()
  {
    return hasTakenAntibiotic() ? new HealthyState() : this;
  }

}
