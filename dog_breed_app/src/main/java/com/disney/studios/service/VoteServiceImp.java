package com.disney.studios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.disney.studios.model.Vote;
import com.disney.studios.repository.VoteRepo;

/**
 * @author suresh adhikari
 *
 */
@Service
@Transactional
public class VoteServiceImp implements VoteService {

	@Autowired
	VoteRepo voteRepo;

	@Override
	public Vote voteDogPicture(Vote vote) {

		return voteRepo.save(vote);
	}

	@Override
	public boolean isVoteExist(String username) {

		return voteRepo.existsByUser(username);
	}

}
