package pageobjects;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utils.Browser;

public class DashboardPageObject {

	public static void assertIamOnThePage() {
		WebElement greetingText = Browser.driver.findElement(By.cssSelector("div.div3"));
		System.out.println("greetingText.getText()" + greetingText.getText());
		Assert.assertEquals("This is not the expected text", " You are logged in as admin", greetingText.getText());
		
	}

	public static void goToProductsPage() {
		WebElement catalog = Browser.driver.findElement(By.linkText("Catalog"));
		catalog.click();
		Browser.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    WebElement products = Browser.driver.findElement(By.linkText("Products"));
		products.click();
		
	}
	
}
