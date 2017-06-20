package com.disney.studios.repository;

import org.springframework.data.repository.CrudRepository;

import com.disney.studios.model.DogImage;

/**
 * @author suresh adhikari
 *
 */
public interface DogImageRepo extends CrudRepository<DogImage, Integer> {

	DogImage findById(int imageId);

}
