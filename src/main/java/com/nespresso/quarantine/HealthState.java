package com.nespresso.quarantine;

abstract class HealthState
{
  private boolean hasTakenAspirin = false;
  private boolean hasTakenAntibiotic = false;
  private boolean hasTakenInsulin = false;
  private boolean hasTakenParacetamol = false;
  
  final boolean hasTakenAspirin()
  {
    return hasTakenAspirin;
  }
  
  final boolean hasTakenAntibiotic()
  {
    return hasTakenAntibiotic;
  }
  
  final boolean hasTakenInsulin()
  {
    return hasTakenInsulin;
  }
  
  final boolean hasTakenParacetamol()
  {
    return hasTakenParacetamol;
  }
  
  final HealthState aspirin()
  {
    hasTakenAspirin = true;
    
    if (hasTakenParacetamol())
    {
      return new DeadState();
    }
    
    return this;
  }
  
  final HealthState antibiotic()
  {
    hasTakenAntibiotic = true;
    
    return this;
  }
  
  final HealthState insulin()
  {
    hasTakenInsulin = true;
    
    return this;
  }
  
  final HealthState paracetamol()
  {
    hasTakenParacetamol = true;
    
    if (hasTakenAspirin())
    {
      return new DeadState();
    }
    
    return this;
  }
  
  abstract HealthState wait40Days();
}
