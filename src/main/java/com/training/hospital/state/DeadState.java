package com.training.hospital.state;

final class DeadState extends State
{

  @Override
  public State wait40Days()
  {
    return this;
  }

  @Override
  State forReport()
  {
    return new DeadState();
  }

}
