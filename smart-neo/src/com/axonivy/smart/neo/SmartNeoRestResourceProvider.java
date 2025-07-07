package com.axonivy.smart.neo;

import java.util.Set;

import ch.ivyteam.ivy.engine.rest.service.Context;
import ch.ivyteam.ivy.engine.rest.service.RestResourcesProvider;

public class SmartNeoRestResourceProvider implements RestResourcesProvider {

  @Override
  public Set<Class<?>> securityContext(Context context) {
    return Set.of(SmartNeoResource.class);
  }
}
