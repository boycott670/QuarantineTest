package com.nespresso.quarantine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Quarantine
{
  private static final Map<Character, Supplier<? extends HealthState>> codeToHealthStateSupplier;
  
  private static final Map<Class<? extends HealthState>, Character> healthStateToCode;
  
  static
  {
    codeToHealthStateSupplier = new HashMap<>();
    
    codeToHealthStateSupplier.put('F', FeverState::new);
    codeToHealthStateSupplier.put('H', HealthyState::new);
    codeToHealthStateSupplier.put('D', DiabeticsState::new);
    codeToHealthStateSupplier.put('T', TuberculosisState::new);
    
    healthStateToCode = new HashMap<>();
    
    healthStateToCode.put(FeverState.class, 'F');
    healthStateToCode.put(HealthyState.class, 'H');
    healthStateToCode.put(DiabeticsState.class, 'D');
    healthStateToCode.put(TuberculosisState.class, 'T');
    healthStateToCode.put(DeadState.class, 'X');
  }
  
  private HealthState[] states;
  
  public Quarantine(final String healthStates)
  {
    states = Arrays.stream(healthStates.split(","))
        .map(state -> state.charAt(0))
        .map(codeToHealthStateSupplier::get)
        .map(Supplier::get)
        .toArray(HealthState[]::new);
  }
  
  private void applyTransition(final UnaryOperator<HealthState> transition)
  {
    states = Arrays.stream(states)
        .map(transition)
        .toArray(HealthState[]::new);
  }
  
  public void wait40Days()
  {
    applyTransition(HealthState::wait40Days);
  }
  
  public void aspirin()
  {
    applyTransition(HealthState::aspirin);
  }
  
  public void antibiotic()
  {
    applyTransition(HealthState::antibiotic);
  }
  
  public void insulin()
  {
    applyTransition(HealthState::insulin);
  }
  
  public void paracetamol()
  {
    applyTransition(HealthState::paracetamol);
  }
  
  public String report()
  {
    return Stream
        .<Class<? extends HealthState>>of(FeverState.class, HealthyState.class, DiabeticsState.class,
            TuberculosisState.class, DeadState.class)
        .map(state -> String.format("%c:%d", healthStateToCode.get(state), Arrays.stream(states)
            .map(Object::getClass)
            .filter(state::isAssignableFrom)
            .count()))
        .collect(Collectors.joining(" "));
  }
}
