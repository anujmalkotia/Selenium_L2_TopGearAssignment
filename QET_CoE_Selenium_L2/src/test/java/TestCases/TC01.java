package TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.OpenCart_Homepage;
import PageObjects.OpenCart_Registerpage;
import Resources.base;
import Utility.ReusableComponents;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TC01 extends base {
	
	public WebDriver driver;
	
	ReusableComponents rc = new ReusableComponents();
	
	@Given("Open URL")
	public void open_url() throws IOException {
		
		driver = driverSetup();
		driver.get(rc.getProperty("home_url"));
		driver.manage().window().maximize();
	    
	}

	@When("Register")
	public void register() throws IOException {
		System.out.println(driver.getTitle());

		OpenCart_Homepage hp = new OpenCart_Homepage(driver); 
		hp.getMy_act().click();
		hp.getRegister().click();

		String title1 = driver.getTitle();
		Assert.assertEquals(title1, "Register Account");

		OpenCart_Registerpage rp = new OpenCart_Registerpage(driver);
		rp.getFname().sendKeys("ajay");
		rp.getLname().sendKeys("mehta");
		rp.getEmail().sendKeys("ajay03@yahoo.in");
		rp.getTelephone().sendKeys("999921221");
		rp.getPassword().sendKeys("aj12345");
		rp.getC_password().sendKeys("aj12345");
		rp.getChck_box1().click();

		rp.getButton1().click();

		if(rp.getErr_1().isDisplayed())
		{
			String tc01_error1 = null;
			rc.getss(tc01_error1, driver);
		}

		else
		{
			String title2 = driver.getTitle();
			Assert.assertEquals(title2, "Your Account Has Been Created!");

			String tc01_ss = null;
			rc.getss(tc01_ss, driver);
		}
		
		

	}

	

	@Then("Logout")
	public void logout() {
		
		OpenCart_Homepage hp = new OpenCart_Homepage(driver); 
		hp.getMy_act().click();
		hp.getLogout().click();
		System.out.println("Successfully logged out");
	}

}
	
	
/*
	

		
	}
	
	@DataProvider(name="Registeration")
	public Object[][] getTestData() throws IOException
	{
		return rc.readDatafromExceltc01(0);
	}

}
*/