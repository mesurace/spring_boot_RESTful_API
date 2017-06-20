package com.disney.studios.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.disney.studios.model.Vote;

/**
 * @author suresh adhikari
 *
 */
public interface VoteRepo extends CrudRepository<Vote, Integer> {

	Vote save(Vote vote);

	@Query("select count(v)>0 from Vote v where v.voter.userName=:userName")
	boolean existsByUser(@Param("userName") String userName);

}
