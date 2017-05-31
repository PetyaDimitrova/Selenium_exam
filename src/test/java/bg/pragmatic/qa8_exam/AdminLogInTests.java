package bg.pragmatic.qa8_exam;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pageobjects.AdminLogInPageObject;
import pageobjects.DashboardPageObject;
import utils.Browser;

public class AdminLogInTests {
	
	@Before
	public void setUp(){
		Browser.browserInit(); 
		AdminLogInPageObject.goTo(); 
		
	}
	
	@After
	public void tearDown(){
		Browser.shutDown();
	}
	
	@Test
	public void successfulLogIn(){
		AdminLogInPageObject.logIn("admin", "parola");
		DashboardPageObject.assertIamOnThePage();
		
	}
	
	

}
