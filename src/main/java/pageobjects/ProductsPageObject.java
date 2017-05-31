package pageobjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utils.Browser;

public class ProductsPageObject {

		
	public static void assertProductsPage() {
		WebElement productsHeader = Browser.driver.findElement(By.xpath("//h1[text()=' Products']"));
		System.out.println("productsHeader" + productsHeader.getText());
		Assert.assertEquals("Products", productsHeader.getText());
	}

	public static void searchForProduct(String productName) {
		WebElement productNameField = Browser.driver.findElement(By.name("filter_name"));
		productNameField.clear();
		productNameField.sendKeys(productName);
		Browser.driver.findElement(By.linkText("Filter")).click();
	}

	public static void assertProductIsFound() {
		WebElement result = Browser.driver.findElement(By.xpath("//td[text()='Test_product']"));
		System.out.println("result: " + result.getText());
		Assert.assertEquals("Test_product", result.getText());
	}	
	
	public static void assertProductIsNotFound() {
		WebElement message = Browser.driver.findElement(By.xpath("//td[text()='No results!']"));
		Assert.assertEquals("No results!", message.getText());

	}
	

	public static void goToDataTab() {
		WebElement data = Browser.driver.findElement(By.linkText("Data"));
		data.click();
	}

	public static void saveChanges() {
		Browser.driver.findElement(By.linkText("Save")).click();

	}

	public static void selectProduct() {
		WebElement product = Browser.driver.findElement(By.name("selected[]"));
		if (!product.isSelected())
			product.click();
		assertTrue(product.isSelected());

	}
	
	public static boolean IsProductFound()
 	{
 		if (isElementPresent(By.xpath("//td[text()='Test_product']"))) {
 			assertProductIsFound();
 			return true;
 		}
 		else {
 			assertProductIsNotFound();
 			return false;
 		}
 	}
 	
 	private static boolean isElementPresent(By by) {
		try {
			Browser.driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
 	}
 	

	public static void deleteProduct() {

		WebElement deleteButton = Browser.driver.findElement(By.linkText("Delete"));
		deleteButton.click();

		try {
			Alert alert = Browser.driver.switchTo().alert();
			String alertMessage = alert.getText();
			alert.accept();
			assertEquals("Delete/Uninstall cannot be undone! Are you sure you want to do this?", alertMessage);

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		
		WebElement deleteSuccessfulMesseage = Browser.driver.findElement(By.cssSelector("div.success"));
		Assert.assertEquals("Success: You have modified products!", deleteSuccessfulMesseage.getText());
	}
	

	public static void insertProduct(String productName, String model) {
		WebElement insertButton = Browser.driver.findElement(By.linkText("Insert"));
		insertButton.click();
		WebElement productNameField = Browser.driver.findElement(By.name("product_description[1][name]"));
		productNameField.sendKeys(productName);
		goToDataTab();
		WebElement modelField = Browser.driver.findElement(By.name("model"));
		modelField.sendKeys(model);
		saveChanges();
		WebElement successfulMessage = Browser.driver.findElement(By.cssSelector("div.success"));
		Assert.assertEquals("Success: You have modified products!", successfulMessage.getText());
	}

}
