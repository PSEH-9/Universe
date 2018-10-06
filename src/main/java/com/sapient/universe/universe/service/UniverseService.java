package com.sapient.universe.universe.service;

import com.sapient.universe.universe.EntityType;
import com.sapient.universe.universe.UniverseResponse;

public interface UniverseService {

	public UniverseResponse getObject(EntityType type, String name);
}
