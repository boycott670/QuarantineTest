package com.training.hospital.state;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public final class StateFactory
{
  public static State getState(final String state)
  {
    final Map<? super Character, Supplier<? extends State>> states = new HashMap<>();

    states.put(State.FEVER_STATE_CHAR, FeverState::new);
    states.put(State.HEALTHY_STATE_CHAR, HealthyState::new);
    states.put(State.DIABETICS_STATE_CHAR, DiabeticsState::new);
    states.put(State.TUBERCULOSIS_STATE_CHAR, TuberculosisState::new);

    return Optional.ofNullable(state)
        .filter(notNullState -> !notNullState.isEmpty())
        .map(notEmptyState -> notEmptyState.charAt(0))
        .map(states::get)
        .orElseThrow(IllegalArgumentException::new)
        .get();
  }
}
