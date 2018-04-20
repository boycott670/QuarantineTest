package com.training.hospital.state;

import com.training.hospital.ParacetamolMixedWithAspirinException;

public abstract class State
{
  public static final char FEVER_STATE_CHAR = 'F';
  public static final char HEALTHY_STATE_CHAR = 'H';
  public static final char DIABETICS_STATE_CHAR = 'D';
  public static final char TUBERCULOSIS_STATE_CHAR = 'T';
  public static final char DEAD_STATE_CHAR = 'X';

  private static final State DEAD_STATE = new DeadState();

  private boolean takenAspirin = false;
  private boolean takenAntibiotic = false;
  private boolean takenInsulin = false;
  private boolean takenParacetamol = false;

  public static State deadState()
  {
    return DEAD_STATE;
  }

  public static boolean isFever(final State state)
  {
    return state instanceof FeverState;
  }

  public static boolean isHealthy(final State state)
  {
    return state instanceof HealthyState;
  }

  public static boolean isDiabetics(final State state)
  {
    return state instanceof DiabeticsState;
  }

  public static boolean isTuberculosis(final State state)
  {
    return state instanceof TuberculosisState;
  }

  public static boolean isDead(final State state)
  {
    return state instanceof DeadState;
  }

  State()
  {

  }

  final boolean hasTakenAspirin()
  {
    return takenAspirin;
  }

  final boolean hasTakenAntibiotic()
  {
    return takenAntibiotic;
  }

  final boolean hasTakenInsulin()
  {
    return takenInsulin;
  }

  final boolean hasTakenParacetamol()
  {
    return takenParacetamol;
  }

  public final void aspirin() throws ParacetamolMixedWithAspirinException
  {
    if (hasTakenParacetamol())
    {
      throw new ParacetamolMixedWithAspirinException();
    }

    takenAspirin = true;
  }

  public final void antibiotic()
  {
    takenAntibiotic = true;
  }

  public final void insulin()
  {
    takenInsulin = true;
  }

  public final void paracetamol() throws ParacetamolMixedWithAspirinException
  {
    if (hasTakenAspirin())
    {
      throw new ParacetamolMixedWithAspirinException();
    }

    takenParacetamol = true;
  }

  public final State copyForReport()
  {
    return forReport();
  }

  public abstract State wait40Days();

  abstract State forReport();
}
