package com.disney.studios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.disney.studios.model.Breed;
import com.disney.studios.model.DogImage;
import com.disney.studios.model.Vote;
import com.disney.studios.service.BreedService;
import com.disney.studios.service.DogImageService;
import com.disney.studios.service.VoteService;

/**
 * This is the controller for breed images which is mapped with /dogbreedapp uri
 * to call API methods
 * @author suresh adhikari
 *
 */
@RestController
@RequestMapping("/dogbreedapp")
public class ImageController extends BaseController {

	@Autowired
	BreedService breedService;

	@Autowired
	VoteService voteService;

	@Autowired
	DogImageService dogImageService;

	// List all of the available dog pictures grouped by breed
	@RequestMapping(value = "/getPicsGroupByBreed", method = RequestMethod.GET)
	public List<Breed> getPicturesGroupByBreed() {
		return breedService.getPicturesGroupByBreed();
	}

	// List all of the available dog pictures of a particular breed
	@RequestMapping(value = "/getAllByBreed", method = RequestMethod.GET)
	public List<Breed> getListByBreed(@RequestParam("breed") String breed) {
		return breedService.getPicturesByBreed(breed);
	}

	// Vote up and down a dog picture -- each user is allowed to vote once for
	// any particular dog picture.
	@RequestMapping(value = "/voteDogPic", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean voteDogPicture(@RequestBody Vote vote) {

		// check user is already exist or not; if exist return false otherwise
		// do vote
		if (voteService.isVoteExist(vote.getVoter().getUserName())) {
			return false;
		}
		voteService.voteDogPicture(vote);
		return true;
	}

	// The details associated with a dog picture
	@RequestMapping(value = "/getPicDetails", method = RequestMethod.GET)
	public DogImage getPicDetails(@RequestParam("imageId") int imageId) {
		return dogImageService.getPicDetails(imageId);

	}

}
