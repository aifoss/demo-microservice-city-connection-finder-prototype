package com.demo.microservice.controller.mvc;

import static com.demo.microservice.util.TestUtil.getApiUri;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.microservice.controller.CityConnectionFinderController;
import com.demo.microservice.service.CityConnectionFinderService;

/**
 * MVC test for {@link CityConnectionFinderController} using mock MVC with context.
 * 
 * @author sofia
 * @date 2019-01-19
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CityConnectionFinderController.class)
@ContextConfiguration(classes = CityConnectionFinderController.class)
public class CityConnectionFinderControllerMockMvcWithContextTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private CityConnectionFinderService cityConnectionFinderService;
	
	@Test
	public void test_withContext_givenCityConnectionFinderServiceWillReturnTrue_returnsYes() throws Exception {
		String origin = "Philadelphia";
		String destination = "Boston";
		
		given(cityConnectionFinderService.findConnection(origin, destination)).willReturn(true);
		
		String apiUri = getApiUri(origin, destination);
		
		MockHttpServletResponse response = mvc.perform(get(apiUri)).andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString()).isEqualTo("yes");			
	}
	
	@Test
	public void test_withContext_givenCityConnectionFinderServiceWillReturnFalse_returnsNo() throws Exception {
		String origin = "Philadelphia";
		String destination = "Albany";
		
		given(cityConnectionFinderService.findConnection(origin, destination)).willReturn(false);
		
		String apiUri = getApiUri(origin, destination);
		
		MockHttpServletResponse response = mvc.perform(get(apiUri)).andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString()).isEqualTo("no");			
	}
		
}
