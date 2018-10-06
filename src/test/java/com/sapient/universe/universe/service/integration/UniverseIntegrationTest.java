package com.sapient.universe.universe.service.integration;

import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.support.RestGatewaySupport;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class UniverseIntegrationTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	RestTemplate restTemplate;

	private MockRestServiceServer mockServer;

	@Before
	public void setup() {
		RestGatewaySupport gateway = new RestGatewaySupport();
		gateway.setRestTemplate(restTemplate);
		mockServer = MockRestServiceServer.createServer(gateway);
	}

	@Test
	public void shouldGetObjectWithStatusOk() throws Exception {

		expectRequestToVehicleApi();
		expectRequestToFilmsApi();

		this.mockMvc
				.perform(MockMvcRequestBuilders.get("/api/universe?name=Sand Crawler&type=VEHICLES")
						.accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Sand Crawler"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.count").value("1"));
	}

	@Test
	public void shouldGetObjectWithStatusBadRequest() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.get("/api/universe?name=Sand Crawler")
						.accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());

	}

	private void expectRequestToVehicleApi() {
		mockServer.expect(once(), requestTo("http://swapi.co/api/vehicles"))
				.andRespond(withSuccess("{\n" + "    \"count\": 39, \n" + "    \"next\": null, \n"
						+ "    \"previous\": null, \n" + "    \"results\": [\n" + "        {\n"
						+ "            \"name\": \"Sand Crawler\", \n" + "            \"model\": \"Digger Crawler\", \n"
						+ "            \"manufacturer\": \"Corellia Mining Corporation\", \n"
						+ "            \"cost_in_credits\": \"150000\", \n" + "            \"length\": \"36.8\", \n"
						+ "            \"max_atmosphering_speed\": \"30\", \n" + "            \"crew\": \"46\", \n"
						+ "            \"passengers\": \"30\", \n" + "            \"cargo_capacity\": \"50000\", \n"
						+ "            \"consumables\": \"2 months\", \n"
						+ "            \"vehicle_class\": \"wheeled\", \n" + "            \"pilots\": [], \n"
						+ "            \"films\": [\n" + "                \"https://swapi.co/api/films/5/\" \n"
						+ "            ], \n" + "            \"created\": \"2014-12-10T15:36:25.724000Z\", \n"
						+ "            \"edited\": \"2014-12-22T18:21:15.523587Z\", \n"
						+ "            \"url\": \"https://swapi.co/api/vehicles/4/\"\n" + "        }]}",
						MediaType.APPLICATION_JSON));
	}

	private void expectRequestToFilmsApi() {
		mockServer.expect(once(), requestTo("https://swapi.co/api/films/5/")).andRespond(withSuccess(
				"{\n" + "    \"count\": 39, \n" + "    \"next\": \"https://swapi.co/api/vehicles/?page=2\", \n"
						+ "    \"previous\": null, \n" + "    \"results\": [\n" + "        {\n"
						+ "            \"name\": \"Sand Crawler\", \n" + "            \"model\": \"Digger Crawler\", \n"
						+ "            \"manufacturer\": \"Corellia Mining Corporation\", \n"
						+ "            \"cost_in_credits\": \"150000\", \n" + "            \"length\": \"36.8\", \n"
						+ "            \"max_atmosphering_speed\": \"30\", \n" + "            \"crew\": \"46\", \n"
						+ "            \"passengers\": \"30\", \n" + "            \"cargo_capacity\": \"50000\", \n"
						+ "            \"consumables\": \"2 months\", \n"
						+ "            \"vehicle_class\": \"wheeled\", \n" + "            \"pilots\": [], \n"
						+ "            \"films\": [\n" + "                \"https://swapi.co/api/films/5/\" \n"
						+ "            ], \n" + "            \"created\": \"2014-12-10T15:36:25.724000Z\", \n"
						+ "            \"edited\": \"2014-12-22T18:21:15.523587Z\", \n"
						+ "            \"url\": \"https://swapi.co/api/vehicles/4/\"\n" + "        }]}",
				MediaType.APPLICATION_JSON));

	}
}
