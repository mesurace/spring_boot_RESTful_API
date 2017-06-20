package com.disney.studios.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.disney.studios.AbstractTestController;
import com.disney.studios.model.Breed;
import com.disney.studios.model.DogImage;
import com.disney.studios.model.User;
import com.disney.studios.model.Vote;
import com.disney.studios.service.BreedService;
import com.disney.studios.service.DogImageService;
import com.disney.studios.service.VoteService;

/**
 * Unit tests for the ImageController using Mockito.
 * 
 * @author suresh adhikari
 */
public class ImageControllerUnitTest extends AbstractTestController {

	@Mock
	BreedService breedService;

	@Mock
	VoteService voteService;

	@Mock
	DogImageService dogImageService;

	@InjectMocks
	ImageController imageController;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		setUp(imageController);
	}

	// returns list of breed images, sample data for the tests
	private List<Breed> getSampleDataForGetPicturesGroupByBreed() {

		DogImage dogImage1 = new DogImage(1, "http://i.imgur.com/xX2AeDR.png", "data1");
		DogImage dogImage2 = new DogImage(2, "http://i.imgur.com/E5vBM5Z.png", "data2");
		DogImage dogImage3 = new DogImage(3, "http://i.imgur.com/zjgtrf9.png", "data3");

		List<DogImage> dogImages1 = new ArrayList<DogImage>();
		dogImages1.add(dogImage1);
		Breed breed1 = new Breed(1, "labrador", dogImages1);

		List<DogImage> dogImages2 = new ArrayList<DogImage>();
		dogImages2.add(dogImage2);
		dogImages2.add(dogImage3);
		Breed breed2 = new Breed(2, "pug", dogImages2);

		List<Breed> breeds = new ArrayList<>();
		breeds.add(breed1);
		breeds.add(breed2);
		return breeds;
	}

	private List<Breed> getSampleDataForGetListByBreed() {

		DogImage dogImage2 = new DogImage(2, "http://i.imgur.com/E5vBM5Z.png", "data2");
		DogImage dogImage3 = new DogImage(3, "http://i.imgur.com/zjgtrf9.png", "data3");

		List<DogImage> dogImages2 = new ArrayList<DogImage>();
		dogImages2.add(dogImage2);
		dogImages2.add(dogImage3);
		Breed breed2 = new Breed(2, "pug", dogImages2);

		List<Breed> breeds = new ArrayList<>();
		breeds.add(breed2);
		return breeds;
	}

	@Test
	public void testgetPicturesGroupByBreed() throws Exception {

		String uri = "/dogbreedapp/getPicsGroupByBreed";
		List<Breed> breedImagesList = getSampleDataForGetPicturesGroupByBreed();

		when(breedService.getPicturesGroupByBreed()).thenReturn(breedImagesList);
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))
				.andReturn();

		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();

		// getPicturesGroupByBreed() runs onces
		verify(breedService, times(1)).getPicturesGroupByBreed();

		// Perform standard JUnit assertions on the response
		Assert.assertEquals("expected true, HTTP status 200", 200, status);
		Assert.assertEquals(super.mapToJson(breedImagesList), content);
	}

	@Test
	public void testgetListByBreed() throws Exception {
		String uri = "/dogbreedapp/getAllByBreed?breed=pug";

		when(breedService.getPicturesByBreed("pug")).thenReturn(getSampleDataForGetListByBreed());
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))
				.andReturn();

		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();

		// getPicturesByBreed() runs onces
		verify(breedService, times(1)).getPicturesByBreed("pug");

		// Perform standard JUnit assertions on the response
		Assert.assertEquals("expected true, HTTP status 200", 200, status);

		Assert.assertEquals(super.mapToJson(getSampleDataForGetListByBreed()), content);

	}

	@Test
	public void voteDogPicture() throws Exception {

		String uri = "/dogbreedapp/voteDogPic";

		DogImage dogImage = new DogImage(1, "http://i.imgur.com/WDWK4nF.png", "labrador breed");
		User user = new User(1, "suresh", "adhikari", "suresh");
		Vote vote = new Vote(1, 2, 0, user, dogImage);

		when(voteService.isVoteExist("suresh")).thenReturn(false);
		when(voteService.voteDogPicture(any(Vote.class))).thenReturn(vote);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(super.mapToJson(vote))).andReturn();

		int status = result.getResponse().getStatus();

		verify(voteService, times(1)).isVoteExist("suresh");
		verify(voteService, times(1)).voteDogPicture(any(Vote.class));

		Assert.assertEquals("Exected http status 200", 200, status);
		Assert.assertFalse("If already done- yes vote : expected true", result.getResponse().isCharset());

	}

	@Test
	public void getPicDetails() throws Exception {

		String uri = "/dogbreedapp/getPicDetails?imageId=2";
		DogImage dogImage = new DogImage(2, "http://i.imgur.com/E5vBM5Z.png", "data2");

		when(dogImageService.getPicDetails(2)).thenReturn(dogImage);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))
				.andReturn();

		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();
		Assert.assertEquals("Exected http status 200", 200, status);
		Assert.assertNotNull("Null check", content);
		Assert.assertEquals(super.mapToJson(dogImage), content);
	}

}
