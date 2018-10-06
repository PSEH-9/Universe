package com.sapient.universe.universe.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.sapient.universe.universe.EntityResponse;
import com.sapient.universe.universe.EntityType;
import com.sapient.universe.universe.Film;
import com.sapient.universe.universe.Result;
import com.sapient.universe.universe.UniverseResponse;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class UniverseServiceTest {

	@InjectMocks
	private UniverseServiceImpl universeService;

	@Mock
	private RestTemplate restTemplate;

	@Mock
	private EntityResponse entityResponse;

	@Test
	public void testGetObject() {

		Mockito.when(restTemplate.getForObject("http://swapi.co/api/vehicles", EntityResponse.class)).thenReturn(prepareEntityResponse());
		UniverseResponse response = universeService.getObject(EntityType.VEHICLES, "Sand Crawler");
		assertEquals(1, response.getCount());
		assertEquals("Sand Crawler", response.getName());
		assertEquals(EntityType.VEHICLES.name(), response.getType());
		Mockito.verify(restTemplate,times(1)).getForObject("http://swapi.co/api/vehicles", EntityResponse.class);
		Mockito.verify(restTemplate,times(1)).getForObject("http://swapi.co/api/film/1", Film.class);
	}

	private EntityResponse prepareEntityResponse() {

		EntityResponse entityResponse = new EntityResponse();
		Result result = new Result();
		result.setName("Sand Crawler");
		List<String> films = new ArrayList<>();
		films.add("http://swapi.co/api/film/1");
		result.setFilms(films);
		List<Result> results = new ArrayList<>();
		results.add(result);
		entityResponse.setResults(results);
		return entityResponse;
	}
}
