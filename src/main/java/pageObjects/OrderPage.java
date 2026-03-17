	package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.abstractClass;

public class OrderPage extends abstractClass{
	
	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (xpath="//button[normalize-space()='Checkout']")
	WebElement checkOutBtn;
	
	@FindBy (css="tr td:nth-child(3)")
	List<WebElement> productTitles;
	
	public boolean verifyOrderDisaplay(String productName) {
		boolean match =	productTitles.stream().anyMatch(Product->Product.getText().equalsIgnoreCase(productName));
		return match;
	}
	

}
