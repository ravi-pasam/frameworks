package ravi.frameworks;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.OrderPage;
import pageObjects.cartPage;
import pageObjects.checkoutPage;
import pageObjects.confirmationPage;
import pageObjects.productCatalogue;
import ravi.testComponents.baseTest;

public class e_commerce extends baseTest{
	String productName="IPHONE 13 PRO";
	@Test(dataProvider = "getData", groups="purchase")
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {
	    
		
		
		productCatalogue pc =lp.loginApplication(input.get("email"),input.get("password"));
		
		List<WebElement> products =pc.getProductList();
		pc.addProductToCart(input.get("productName"));
		cartPage cp = pc.goToCartPage();
		
		boolean match = cp.verifyProductDisaplay(input.get("productName"));
		Assert.assertTrue(match);
		checkoutPage checkoutPage = cp.goToCheckout();
		checkoutPage.selectCountry("india");
		confirmationPage confirmationPage =checkoutPage.submitOrder();
		String cnfMessage =confirmationPage.getConfirmationMessage();
	    Assert.assertTrue(cnfMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}
	@Test(dependsOnMethods= {"submitOrder"})
	public void orderHistoryTest() {
		productCatalogue pc =lp.loginApplication("ravi11@gmail.com","Ravi@123");
		OrderPage orderpage = pc.goToOrderPage();
		Assert.assertTrue(orderpage.verifyOrderDisaplay(productName));

		
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String,String>> data =getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\ravi\\data\\purchaseOrder.json");
		
		return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)}};
	}
	
	
	
	
	
	
	
	
//	HashMap<String, String> map = new HashMap<String,String>();
//	map.put("email", "ravi11@gmail.com");
//	map.put("password", "Ravi@123");
//	map.put("productName", "QWERTY");
//	HashMap<String, String> map2 = new HashMap<String,String>();
//	map2.put("email", "teja112@gmail.com");
//	map2.put("password", "Ravi@123");
//	map2.put("productName", "ZARA COAT 3");
//	HashMap<String, String> map3 = new HashMap<String,String>();
//	map3.put("email", "ravi11@gmail.com");
//	map3.put("password", "Ravi@123");
//	map3.put("productName", "ADIDAS ORIGINAL");
	
/*	@DataProvider
	public Object[][] getData() {
		return new Object[][] {
			{"ravi11@gmail.com" , "Ravi@123"},
		    {"ravi55@gmail.com","Ravi@123"}
			};
			}
			*/
		
	
}

