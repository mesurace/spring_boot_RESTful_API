package com.disney.studios.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/** 
 * @author suresh adhikari
 *
 */
@Entity
public class Breed {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	private Collection<DogImage> imageList = new ArrayList<>();

	public Breed() {

	}

	public Breed(int id, String name, Collection<DogImage> imageList) {

		this.id = id;
		this.name = name;
		this.imageList = imageList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<DogImage> getImageList() {
		return imageList;
	}

	public void setImageList(Collection<DogImage> imageList) {
		this.imageList = imageList;
	}

}
