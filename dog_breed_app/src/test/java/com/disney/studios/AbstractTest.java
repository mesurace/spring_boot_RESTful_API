package com.disney.studios;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * The AbstractTest class is the parent of all JUnit test classes. This class
 * configures the test ApplicationContext and test runner environment.
 * 
 * @author suresh adhikari
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public abstract class AbstractTest {

}
