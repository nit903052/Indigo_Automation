package testCase;

import org.testng.annotations.Test;

import pom.Home_Page;
import testBase.BaseClass;

public class TC_001_Login extends BaseClass
{
	@Test
	public void login() throws InterruptedException
	{{
		
	
		Home_Page home = new Home_Page(driver);
		home.Click_Booking_ad();
		home.Click_Login_button();
		home.Click_Login_AS_Customer_button();
		home.Txt_countryName(p.getProperty("countryName"));
		home.Txt_Phone_number(p.getProperty("phoneNumber"));
		home.Click_Sent_OTP_Button();
		home.Login_With_Password_Btn();
		home.Input_Password_Txt(p.getProperty("Password"));
		home.Login_button_after_password();
		home.Click_Login_After_Entering_Password();
	}}
	
		
		
}
