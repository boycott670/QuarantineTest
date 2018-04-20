package com.training.hospital.parser;

import java.util.Arrays;

import com.training.hospital.state.State;
import com.training.hospital.state.StateFactory;

public final class DefaultQuarantineParser implements QuarantineParser
{

  @Override
  public State[] parseQuarantine(String quarantine)
  {
    return Arrays.stream(quarantine.split(","))
        .map(StateFactory::getState)
        .toArray(State[]::new);
  }

}
