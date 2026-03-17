package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import AbstractComponents.abstractClass;

public class checkoutPage extends abstractClass{
	WebDriver driver;
	
	public checkoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// //input[@placeholder='Select Country']
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="//body//app-root//button[2]")
	WebElement selectCountry;
	
	@FindBy(xpath="//a[normalize-space()='Place Order']")
	WebElement submit;
	
	By results = By.cssSelector(".ta-results");
	
	public void selectCountry(String countryName) {
		Actions action= new Actions(driver);
		action.sendKeys(country,countryName).build().perform();
		waitForElementToAppear(results);
		selectCountry.click();
	}
	public confirmationPage submitOrder() {
		
		submit.click();
		return new confirmationPage(driver);
	}
	

}
