package com.disney.studios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.disney.studios.model.DogImage;
import com.disney.studios.repository.DogImageRepo;

/**
 * @author suresh adhikari
 *
 */
@Service
@Transactional
public class DogImageServiceImp implements DogImageService {

	@Autowired
	DogImageRepo dogImageRepo;

	@Override
	public DogImage getPicDetails(int imageId) {
		return dogImageRepo.findById(imageId);
	}

}
