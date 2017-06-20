package com.disney.studios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.disney.studios.controller.BaseController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This is for webapplicationcontext and mockmvc instance
 * 
 * @author suresh adhikari
 */
@WebAppConfiguration
public abstract class AbstractTestController extends AbstractTest {

	protected MockMvc mockMvc;

	@Autowired
	WebApplicationContext webApplicationContext;

	// this is for integration test
	protected void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	// this method provides a ability to register a controller with mockito
	protected void setUp(BaseController baseController) {
		mockMvc = MockMvcBuilders.standaloneSetup(baseController).build();
	}

	// convert object to Json string
	protected String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

}
