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
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private String firstName;
	private String lastName;
	private String userName;

	public User() {

	}

	public User(int id, String firstName, String lastName, String userName) {

		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
