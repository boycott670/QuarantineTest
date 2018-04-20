package com.training.hospital.parser;

import com.training.hospital.state.State;

public interface QuarantineParser
{
  State[] parseQuarantine(String quarantine);
}
