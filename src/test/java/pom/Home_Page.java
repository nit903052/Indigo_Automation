package pom;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Home_Page extends Basepage

{

	public Home_Page(WebDriver driver) 
	{
		super(driver);
	}

	public WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(8));
	
	
	@FindBy(xpath = "//span[@id='close']")
	WebElement Booking_Ad;
	
	@FindBy (xpath = "//span[@id =\"flight-close\"]")   // To handle "GRAND RUNAWAY FEST" pop-up
    WebElement Fest_pop_up;
	
	@FindBy(xpath = "//span[@id='usernameFirstLetter']")
	WebElement Login_button;
	
	@FindBy(xpath = "//a[@title='Customer CTA']")
	WebElement Login_As_Customer_button;
	
	@FindBy(xpath = "//*[@name='userId']")
	WebElement Txt_phone_number;
	
	
	@FindBy(xpath = "//*[contains(@class,'selected-country-box-wrapper')]")    
	WebElement country_code;
	
	
	@FindBy(xpath = "//button[normalize-space()='Send OTP']")
	WebElement Sent_OTP_Button;
	
	
	@FindBy(xpath =  "//form[contains(@class,'skyplus-otpInput__container')]/div")
	WebElement Txt_OTP;
	
	

	@FindBy(xpath = "//button[normalize-space()='Submit OTP']")
	WebElement Submit_OTP;
	

	@FindBy (xpath = "//a[text()='Login with password']")
    WebElement Login_With_Password_Btn;
	
	
	 @FindBy(xpath = "//input[contains(@class,'search-input') and @placeholder='Search']")
	    WebElement Search_Country_Txt;
	 
	 @FindBy (xpath = "//input[@class=' required']")
	    WebElement Input_Password_Txt;
	 
	 
	 @FindBy(xpath="//button[@label='Submit OTP']")
	 WebElement Login_button_after_password;
	 
    public	boolean Status = true;
	public void Click_Booking_ad()
	{
	
		try 
		{
		if(Booking_Ad.isDisplayed()==Status)
		{
			Booking_Ad.click();}
		}
		catch(Exception e)
		{
			return;
		}
	}
	
	public void Click_Fest_PopUp()
	{
	
		try 
		{
		if(Fest_pop_up.isDisplayed()==Status)
		{
			Fest_pop_up.click();}
		}
		catch(Exception e)
		{
			return;
		}
	}
	
	
	
	
	
	
	
	  public void Input_Password_Txt(String Pass) {
	    	Input_Password_Txt.sendKeys(Pass);
	    }
	  public void Login_With_Password_Btn()
	  {
	    	Login_With_Password_Btn.click();;
	  }
	
	  public void Login_button_after_password() throws InterruptedException
	   { 
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@label='Submit OTP']")));
		  Login_button_after_password.click();
		  Thread.sleep(10);
	   }
	  
	
	public void Click_Login_button()
	{
		Login_button.click();
	}
	
	
	public void Click_Login_AS_Customer_button()
	{  
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Customer CTA']")));
		Login_As_Customer_button.click();
	}
	
	public void Txt_Phone_number(String num)
	{
		Txt_phone_number.sendKeys(num);
	}
	
	  public void Txt_countryName(String code) {	
	        country_code.click();;
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@class,'search-input') and @placeholder='Search']")));
	        Search_Country_Txt.sendKeys(code);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='skyplus-dropdown-popover']//span[text()='India']")));
	        driver.findElement(By.xpath("//*[@class='skyplus-dropdown-popover']//span[text()='India']")).click();
	    }
	
	  
	  
	  
	  
	  
	public void Click_Sent_OTP_Button()
	{
		wait.until(ExpectedConditions.elementToBeClickable(Sent_OTP_Button));
		Sent_OTP_Button.click();
	}
	

            
            
      	
public void Click_Login_After_Entering_Password() {
    	
    	String targetElementXPath = "//*[@class='dynamiccontainer']//h1[text()='Hey MR ThankYou Indigo,']";
        
    	
    	
    	//*[@class='dynamiccontainer']//h1[text()='Hey MR ThankYou Indigo,']
    	
    	
        int maxRetries = 10; 
        int retryCount = 0;
        
        while (retryCount < maxRetries) {
            try {
            	Login_button_after_password.click();
                WebElement targetElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(targetElementXPath)));
                
                if (targetElement.isDisplayed()) {
                	System.out.println("Target element found!");
                    break;
                }
            } catch (Exception e)
            {

                retryCount++;
            }
          
	
        }
   }  
}            
       
            
            
            
            
            
	
	
	
	
	
       
