package com.training.hospital.state;

final class FeverState extends State
{

  @Override
  public State wait40Days()
  {
    if (hasTakenAspirin() || hasTakenParacetamol())
    {
      return new HealthyState();
    }

    return this;
  }

  @Override
  State forReport()
  {
    return new FeverState();
  }

}
