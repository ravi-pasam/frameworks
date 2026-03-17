package ravi.frameworks;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.cartPage;
import pageObjects.checkoutPage;
import pageObjects.confirmationPage;
import pageObjects.productCatalogue;
import ravi.testComponents.baseTest;

public class ErrorValid extends baseTest{
	
	@Test(groups="errorValidation")
	public void loginErrorValidation() throws IOException, InterruptedException {
	    
		String productName="ADIDAS ORIGINAL";
		
		lp.loginApplication("ravidtd11@gmail.com","Ravi@123");
		Assert.assertEquals(lp.getErrorMessage(), "Incorrect email or password.");
	
	}
	@Test
public void productValidationTest() throws IOException, InterruptedException {
	    
		String productName="ADIDAS ORIGINAL";
		
		productCatalogue pc =lp.loginApplication("ravi11@gmail.com","Ravi@123");
		
		List<WebElement> products =pc.getProductList();
		pc.addProductToCart(productName);
		cartPage cp = pc.goToCartPage();
		
		boolean match = cp.verifyProductDisaplay("ADIDAS ORIGINAL");
		Assert.assertTrue(match);
		

	}


}
