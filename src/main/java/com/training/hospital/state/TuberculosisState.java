package com.training.hospital.state;

final class TuberculosisState extends State
{

  @Override
  public State wait40Days()
  {
    if (hasTakenAntibiotic())
    {
      return new HealthyState();
    }

    return this;
  }

  @Override
  State forReport()
  {
    return new TuberculosisState();
  }

}
