package com.disney.studios.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.disney.studios.AbstractTestController;
import com.disney.studios.model.DogImage;
import com.disney.studios.model.User;
import com.disney.studios.model.Vote;

/**
 * IntegrationTest for ImageController using JUnit and Mockito.
 * 
 * @author suresh adhikari
 */
public class ImageControllerIntegrationTest extends AbstractTestController {

	@Before
	public void setUp() {
		super.setUp();

	}

	@Test
	public void testgetPicturesGroupByBreed() throws Exception {
		String uri = "/dogbreedapp/getPicsGroupByBreed";

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))
				.andReturn();

		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();
		Assert.assertEquals("Exected http status 200", 200, status);
		Assert.assertNotNull("Null check", content);
		System.out.println(content);
	}

	@Test
	public void testgetListByBreed() throws Exception {
		String uri = "/dogbreedapp/getAllByBreed?breed=labrador";

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))
				.andReturn();

		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();
		Assert.assertEquals("Exected http status 200", 200, status);
		Assert.assertNotNull("Null check", content);
		System.out.println(content);
	}

	@Test
	public void voteDogPicture() throws Exception {
		String uri = "/dogbreedapp/voteDogPic";

		DogImage dogImage = new DogImage(1, "http://i.imgur.com/WDWK4nF.png", "labrador breed");
		User user = new User(1, "suresh", "adhikari", "suresh");
		Vote vote = new Vote(1, 2, 0, user, dogImage);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(super.mapToJson(vote))).andReturn();

		int status = result.getResponse().getStatus();
		Assert.assertEquals("Exected http status 200", 200, status);
		Assert.assertFalse("If already voted- no vote : expected false", result.getResponse().isCharset());

	}

	@Test
	public void getPicDetails() throws Exception {
		String uri = "/dogbreedapp/getPicDetails?imageId=2";

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))
				.andReturn();

		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();
		Assert.assertEquals("Exected http status 200", 200, status);
		Assert.assertNotNull("Null check", content);
		System.out.println(content);
	}

}
