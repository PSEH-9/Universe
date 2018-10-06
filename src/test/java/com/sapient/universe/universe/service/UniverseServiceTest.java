package com.sapient.universe.universe.service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.sapient.universe.universe.EntityResponse;


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
		
		
//		Mockito.when(restTemplate.getForObject(any(URI.class), any(Class.class))).thenReturn(new EntityResponse());
//		universeService.getObject(EntityType.VEHICLES, "Sand Crawler");
	}


}
