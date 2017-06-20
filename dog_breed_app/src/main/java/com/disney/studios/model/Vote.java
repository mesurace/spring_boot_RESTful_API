package com.disney.studios.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/** 
 * @author suresh adhikari
 *
 */
@Entity
public class Vote {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int upVote;
	private int downVote;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User voter;

	@ManyToOne
	@JoinColumn(name = "image_id")
	private DogImage image;

	public Vote() {

	}

	public Vote(int id, int upVote, int downVote, User voter, DogImage image) {

		this.id = id;
		this.upVote = upVote;
		this.downVote = downVote;
		this.voter = voter;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUpVote() {
		return upVote;
	}

	public void setUpVote(int upVote) {
		this.upVote = upVote;
	}

	public int getDownVote() {
		return downVote;
	}

	public void setDownVote(int downVote) {
		this.downVote = downVote;
	}

	public User getVoter() {
		return voter;
	}

	public void setVoter(User voter) {
		this.voter = voter;
	}

	public DogImage getImage() {
		return image;
	}

	public void setImage(DogImage image) {
		this.image = image;
	}

}
