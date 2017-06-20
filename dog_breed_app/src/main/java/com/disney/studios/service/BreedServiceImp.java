package com.disney.studios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.disney.studios.model.Breed;
import com.disney.studios.repository.BreedRepo;

/**
 * @author suresh adhikari
 *
 */
@Service
@Transactional
public class BreedServiceImp implements BreedService {

	@Autowired
	BreedRepo breedRepo;

	@Override
	public List<Breed> getPicturesGroupByBreed() {

		return breedRepo.findAll();
	}

	@Override
	public List<Breed> getPicturesByBreed(String breed) {

		return breedRepo.findByName(breed);
	}

}
