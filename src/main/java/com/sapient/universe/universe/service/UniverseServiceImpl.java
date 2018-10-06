package com.sapient.universe.universe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sapient.universe.universe.EntityResponse;
import com.sapient.universe.universe.EntityType;
import com.sapient.universe.universe.Film;
import com.sapient.universe.universe.UniverseResponse;

@Service
public class UniverseServiceImpl implements UniverseService {

	@Autowired
	private RestTemplate restTemplate;

	public UniverseResponse getObject(EntityType type, String name) {

		UniverseResponse response = new UniverseResponse();
		List<Film> films = new ArrayList<>();
		String pageUrl = "http://swapi.co/api" + type.getUrl();
		response.setName(name);
		response.setType(type.name());
		while (pageUrl != null) {
			EntityResponse entityResponse = restTemplate.getForObject(pageUrl, EntityResponse.class);

			entityResponse.getResults().parallelStream().filter(result -> result.getName().equals(name)).forEach(r -> {
				response.setCount(response.getCount() + 1);
				r.getFilms().parallelStream().forEach(

						url -> {

							Film film = restTemplate.getForObject(url, Film.class);
							films.add(film);
						}

				);
				response.setFilms(films);
			});

			pageUrl = entityResponse.getNext();
		}

		return response;

	}

}
