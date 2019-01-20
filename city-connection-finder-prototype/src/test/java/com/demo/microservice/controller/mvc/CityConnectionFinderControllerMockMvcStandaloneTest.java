package com.demo.microservice.controller.mvc;

import static com.demo.microservice.util.TestUtil.getApiUri;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.demo.microservice.controller.CityConnectionFinderController;
import com.demo.microservice.service.CityConnectionFinderService;

/**
 * MVC test for {@link CityConnectionFinderController} using standalone mock MVC.
 * 
 * @author sofia
 * @date 2019-01-19
 */
@RunWith(MockitoJUnitRunner.class)
public class CityConnectionFinderControllerMockMvcStandaloneTest {

	@InjectMocks
	private CityConnectionFinderController cityConnectionFinderController;
	
	@Mock
	private CityConnectionFinderService cityConnectionFinderService;

	private MockMvc mvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.standaloneSetup(cityConnectionFinderController).build();
	}
	
	@Test
	public void test_givenCityConnectionFinderServiceWillReturnTrue_returnsYes() throws Exception {
		String origin = "Philadelphia";
		String destination = "Boston";
		
		given(cityConnectionFinderService.findConnection(origin, destination)).willReturn(true);
		
		String apiUri = getApiUri(origin, destination);
		
		MockHttpServletResponse response = mvc.perform(get(apiUri)).andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString()).isEqualTo("yes");			
	}
	
	@Test
	public void test_givenCityConnectionFinderServiceWillReturnFalse_returnsNo() throws Exception {
		String origin = "Philadelphia";
		String destination = "Albany";
		
		given(cityConnectionFinderService.findConnection(origin, destination)).willReturn(false);
		
		String apiUri = getApiUri(origin, destination);
		
		MockHttpServletResponse response = mvc.perform(get(apiUri)).andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString()).isEqualTo("no");			
	}
	
}
