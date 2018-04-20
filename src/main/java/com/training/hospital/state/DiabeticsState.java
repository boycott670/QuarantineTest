package com.training.hospital.state;

final class DiabeticsState extends State
{

  @Override
  public State wait40Days()
  {
    if (!hasTakenInsulin())
    {
      return new DeadState();
    }

    return this;
  }

  @Override
  State forReport()
  {
    return new DiabeticsState();
  }

}
