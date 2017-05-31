package bg.pragmatic.qa8_exam;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pageobjects.AdminLogInPageObject;
import pageobjects.DashboardPageObject;
import pageobjects.ProductsPageObject;
import utils.Browser;

public class ProductsPageTests {
	@Before
	public void beforeMethod(){
		Browser.browserInit();
		AdminLogInPageObject.goTo();
		AdminLogInPageObject.logIn("admin", "parola");
		DashboardPageObject.assertIamOnThePage();
		DashboardPageObject.goToProductsPage();
		ProductsPageObject.assertProductsPage();
			
	}
	
	@Test
	public void InsertNewProduct() {
		ProductsPageObject.searchForProduct("Test_product");
		Browser.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		;
		
		if (ProductsPageObject.IsProductFound()){
			ProductsPageObject.selectProduct();
			ProductsPageObject.deleteProduct();
			ProductsPageObject.insertProduct("Test_product", "Test_model");
			ProductsPageObject.searchForProduct("Test_product");
			ProductsPageObject.assertProductIsFound();
			
		} else {
			ProductsPageObject.insertProduct("Test_product", "Test_model");
			ProductsPageObject.searchForProduct("Test_product");
			ProductsPageObject.assertProductIsFound();
		}
		
	}
	
	@After 
	public void tearDown(){
		Browser.driver.close();
	}

}
