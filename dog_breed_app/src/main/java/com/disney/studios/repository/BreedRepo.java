package com.disney.studios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.disney.studios.model.Breed;

/**
 * @author suresh adhikari
 *
 */
public interface BreedRepo extends CrudRepository<Breed, String> {

//	@Query("Select b from Breed b left join Vote v where b.imageList.id= v.image.id order by v.upVote-v.downVote")
	List<Breed> findAll();

	List<Breed> findByName(String name);

}
