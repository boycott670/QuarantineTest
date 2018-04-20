package com.training.hospital;

import java.util.Arrays;

import com.training.hospital.parser.DefaultQuarantineParser;
import com.training.hospital.parser.QuarantineParser;
import com.training.hospital.reporter.DefaultQuarantineReporter;
import com.training.hospital.reporter.QuarantineReporter;
import com.training.hospital.state.State;

final class Quarantine
{
  private final QuarantineParser parser = new DefaultQuarantineParser();
  private final QuarantineReporter reporter = new DefaultQuarantineReporter();
  private final Patient[] patients;

  Quarantine(final String quarantine)
  {
    patients = Arrays.stream(parser.parseQuarantine(quarantine))
        .map(Patient::new)
        .toArray(Patient[]::new);
  }

  void wait40Days()
  {
    Arrays.stream(patients)
        .forEach(Patient::wait40Days);
  }

  void aspirin()
  {
    Arrays.stream(patients)
        .forEach(patient ->
        {
          try
          {
            patient.aspirin();
          } catch (ParacetamolMixedWithAspirinException e)
          {
            patient.kill();
          }
        });
  }

  void antibiotic()
  {
    Arrays.stream(patients)
        .forEach(Patient::antibiotic);
  }

  void insulin()
  {
    Arrays.stream(patients)
        .forEach(Patient::insulin);
  }

  void paracetamol()
  {
    Arrays.stream(patients)
        .forEach(patient ->
        {
          try
          {
            patient.paracetamol();
          } catch (ParacetamolMixedWithAspirinException e)
          {
            patient.kill();
          }
        });
  }

  String report()
  {
    return reporter.reportQuarantine(Arrays.stream(patients)
        .map(Patient::getStateForReport)
        .toArray(State[]::new));
  }
}
