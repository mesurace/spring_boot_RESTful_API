
package com.disney.studios.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/** 
 * @author suresh adhikari
 *
 */
@Entity
public class DogImage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String imageUrl;
	private String description;

	public DogImage() {

	}

	public DogImage(int id, String imageUrl, String description) {

		this.id = id;
		this.imageUrl = imageUrl;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
