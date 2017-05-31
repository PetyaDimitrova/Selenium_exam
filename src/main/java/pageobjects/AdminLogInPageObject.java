package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Browser;

import static org.junit.Assert.*;

import org.junit.Assert;

public class AdminLogInPageObject {
	@FindBy(name="username")
	private static WebElement username;
	
	@FindBy(name="password")
	private static WebElement password;

	private static final String url = "http://shop.pragmatic.bg/admin/";

	public static void goTo() {
		Browser.driver.get(url);
		PageFactory.initElements(Browser.driver,AdminLogInPageObject.class);
	}

	public static void logIn(String usernameParam, String passwordParam) {
		username.sendKeys(usernameParam);
		password.sendKeys(passwordParam);
		Browser.driver.findElement(By.cssSelector("a.button")).click();
		
	}

	public static void assertLogOut() {
		WebElement logInText = Browser.driver.findElement(By.cssSelector("div.heading>h1"));
		System.out.println("Log in text: " + logInText.getText());
		Assert.assertEquals("Please enter your login details.", logInText.getText());
		
	}
	
	

}
