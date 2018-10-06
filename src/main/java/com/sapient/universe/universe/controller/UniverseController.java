package com.sapient.universe.universe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.universe.universe.EntityType;
import com.sapient.universe.universe.UniverseResponse;
import com.sapient.universe.universe.service.UniverseService;

@RestController

public class UniverseController {

	@Autowired
	private UniverseService universeService;

	@GetMapping("/api/universe")
	public UniverseResponse getResponseForType(@RequestParam(value = "type", required = true) String type,
			@RequestParam(value = "name", required = true) String name) {

		return universeService.getObject(EntityType.valueOf(type.toUpperCase()), name);
	}

}
