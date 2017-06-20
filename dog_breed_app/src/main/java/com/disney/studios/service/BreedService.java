package com.disney.studios.service;

import java.util.List;

import com.disney.studios.model.Breed;

/**
 * @author suresh adhikari
 *
 */
public interface BreedService {

	public List<Breed> getPicturesGroupByBreed();

	public List<Breed> getPicturesByBreed(String breed);

}
