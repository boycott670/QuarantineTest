package com.training.hospital.state;

final class HealthyState extends State
{

  @Override
  public State wait40Days()
  {
    if (hasTakenInsulin() && hasTakenAntibiotic())
    {
      return new FeverState();
    }

    return this;
  }

  @Override
  State forReport()
  {
    return new HealthyState();
  }

}
