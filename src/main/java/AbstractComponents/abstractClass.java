package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.OrderPage;
import pageObjects.cartPage;

public class abstractClass {
	
	WebDriver driver;
	
	public abstractClass(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy(css= "[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css= "[routerlink*='myorders']")
	WebElement orderHeader;
	
	public cartPage goToCartPage() {
		cartHeader.click();
		cartPage cp = new cartPage(driver);
		return cp;
	}
	public OrderPage goToOrderPage() {
		orderHeader.click();
		OrderPage orderpage = new OrderPage(driver);
		return orderpage;
	}
	public void waitForWebElementToAppear(WebElement findBy) {
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.visibilityOf(findBy));
	 }

//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
 public void waitForElementToAppear(By findBy) {
	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
 }
 
 public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
//	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//	 wait.until(ExpectedConditions.invisibilityOf(ele));
	 Thread.sleep(1000);
 }
 
}
