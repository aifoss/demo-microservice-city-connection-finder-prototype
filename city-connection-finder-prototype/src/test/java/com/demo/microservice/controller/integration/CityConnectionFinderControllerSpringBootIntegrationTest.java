package com.demo.microservice.controller.integration;

import static com.demo.microservice.util.TestUtil.getApiUri;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.microservice.app.CityConnectionFinderPrototypeApplication;
import com.demo.microservice.controller.CityConnectionFinderController;
import com.demo.microservice.service.CityConnectionFinderService;

/**
 * Integration test for {@link CityConnectionFinderController}.
 * 
 * @author sofia
 * @date 2019-01-19
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = WebEnvironment.RANDOM_PORT, 
		classes = CityConnectionFinderPrototypeApplication.class)
public class CityConnectionFinderControllerSpringBootIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@MockBean
	private CityConnectionFinderService cityConnectionFinderService;
	
	@Test
	public void test_returnsYesIfThereIsConnectionBetweenCities() {
		String origin = "Philadelphia";
		String destination = "Boston";
		
		given(cityConnectionFinderService.findConnection(origin, destination)).willReturn(true);
		
		String apiUri = getApiUri(origin, destination);
		
		ResponseEntity<String> response = restTemplate.getForEntity(apiUri, String.class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualTo("yes");		
	}

	@Test
	public void test_returnsNoIfThereIsNoConnectionBetweenCities() {
		String origin = "Philadelphia";
		String destination = "Albany";
		
		given(cityConnectionFinderService.findConnection(origin, destination)).willReturn(false);
		
		String apiUri = getApiUri(origin, destination);
		
		ResponseEntity<String> response = restTemplate.getForEntity(apiUri, String.class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualTo("no");		
	}
	
}
