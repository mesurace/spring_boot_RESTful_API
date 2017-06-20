# Dog Breed App : Back-end (RESTful API) using SpringBoot

This is a cloud friendly production grade RESTful API that could be used to manage a list of dog images.

This project uses Spring Boot framework for development, Maven for builds, JPA/Hibernate for persistence, Spring Data for data access, MySQL  for database.

Junit and Mockito frameworks are used for Unit and Integration testing.

Used Spring Tool Suit(STS) for IDE.

# Features 

	List all of the available dog pictures grouped by breed
	List all of the available dog pictures of a particular breed
	Vote up and down a dog picture -- each user is allowed to vote once for any particular dog picture.
	The details associated with a dog picture
	All responses are in JSON.
  
  Note:  	Dependency Injection is highly used, followed OO principles and design patterns (Separation of concerns, Abstraction 
  		Polymorphism,Prefer composition over Inheritance) to make loosely coupled, maintable and testable product. 
  							
 # Set UP

	1. Download-> Unzip file
	2. Open STS -> Import as Existing Maven Projects -> Run as Spring Boot App

# Testing

Spring Boot allows to externalize  configuration so we can work with the same application code in different environments.More details  about [externalize  configuration](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html)
			
			For Dev, needs to create application-dev.properties
			For QA, needs to create application-test.properties
			For production, needs to create application-prod.properties

For Unit Testing:

	1. Import project as a maven project
	2. Run the ImageControllerUnitTest class which is inside src/test/java/ folder and 
	   com.disney.studios.controller package as JUnit 

For Integration testing(in dev environment):

	A. Set up:
		1. run MySQl
		2. config the properties in application.properties file. 
	B. Run as a Spring Boot Project
	C. Run the ImageControllerIntegrationTest as JUnit Test
	
For deployment, 
 
    Two options, jar or war. 
 
 :) :) :)
 
