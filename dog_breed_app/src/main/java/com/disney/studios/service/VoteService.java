package com.disney.studios.service;

import com.disney.studios.model.Vote;

/**
 * @author suresh adhikari
 *
 */
public interface VoteService {

	public Vote voteDogPicture(Vote vote);

	public boolean isVoteExist(String username);

}
