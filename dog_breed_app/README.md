# Set UP

	1. Download-> Unzip file(or can clone directly from url)
	2. Open STS -> Import as Existing Maven Projects -> Run as Spring Boot App

# Testing

Spring Boot allows to externalize  configuration so we can work with the same application code in different environments.More details [here](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html)
			
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
    
