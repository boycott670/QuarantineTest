package com.training.hospital.reporter;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.training.hospital.state.State;

public final class DefaultQuarantineReporter implements QuarantineReporter
{

  @Override
  public String reportQuarantine(State[] states)
  {
    final Map<? super Character, Predicate<? super State>> filters = new LinkedHashMap<>();

    filters.put(State.FEVER_STATE_CHAR, State::isFever);
    filters.put(State.HEALTHY_STATE_CHAR, State::isHealthy);
    filters.put(State.DIABETICS_STATE_CHAR, State::isDiabetics);
    filters.put(State.TUBERCULOSIS_STATE_CHAR, State::isTuberculosis);
    filters.put(State.DEAD_STATE_CHAR, State::isDead);

    return filters.entrySet()
        .stream()
        .map(filterEntry -> String.format("%c:%d", filterEntry.getKey(), Arrays.stream(states)
            .filter(filterEntry.getValue())
            .count()))
        .collect(Collectors.joining(" "));
  }

}
