package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.abstractClass;

public class cartPage extends abstractClass{
	
	WebDriver driver;
	
	public cartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (xpath="//button[normalize-space()='Checkout']")
	WebElement checkOutBtn;
	
	@FindBy (css=".cartSection h3")
	List<WebElement> productTitles;
	
	public boolean verifyProductDisaplay(String productName) {
		boolean match =	productTitles.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	public checkoutPage goToCheckout() {
		checkOutBtn.click();
		return new checkoutPage(driver);
	}

}
