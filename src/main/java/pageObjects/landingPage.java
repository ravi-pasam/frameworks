package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.abstractClass;

public class landingPage extends abstractClass{

	WebDriver driver;
	
  public landingPage(WebDriver driver) {
	  super(driver);
	  this.driver=driver;
	  PageFactory.initElements(driver, this);
  }
  //driver.findElement(By.id("userEmail")).sendKeys("ravi11@gmail.com");
      @FindBy(id= "userEmail")
      WebElement userEmail;
      
  //driver.findElement(By.id("userPassword")).sendKeys("Ravi@123");
      @FindBy(id= "userPassword")
      WebElement password;
      
 //driver.findElement(By.id("login")).click();
      @FindBy(id= "login")
      WebElement submitBtn;
      
      
      @FindBy(css="[class*='flyInOut']")
      WebElement errorMessage;
      
      public void goTO() {
    	  driver.get("https://rahulshettyacademy.com/client");
      }
      
      public String getErrorMessage() {
    	  waitForWebElementToAppear(errorMessage);
    	 return errorMessage.getText();
      }
      

	public productCatalogue loginApplication(String email, String passKey) {
    	  userEmail.sendKeys(email);
    	  password.sendKeys(passKey);
    	  submitBtn.click();
    	  productCatalogue pc= new productCatalogue(driver);
    	  return pc;
      }
      
      
      ////div[@class='flyInOut']
      
}
