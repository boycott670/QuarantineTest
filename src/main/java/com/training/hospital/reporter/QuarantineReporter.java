package com.training.hospital.reporter;

import com.training.hospital.state.State;

public interface QuarantineReporter
{
  String reportQuarantine(final State[] states);
}
