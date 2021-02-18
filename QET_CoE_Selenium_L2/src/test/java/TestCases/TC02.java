package TestCases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.OpenCart_Homepage;
import PageObjects.OpenCart_LoginPage;
import PageObjects.OpenCart_MyAccount;
import PageObjects.OpenCart_inLoginPage;
import Resources.base;
import Utility.ReusableComponents;


public class TC02 extends base{
	
	public WebDriver driver;
	
	ReusableComponents rc = new ReusableComponents();
	
	@BeforeClass
	public void method1() throws IOException 
	{
		driver = driverSetup();
		driver.get(rc.getProperty("home_url"));
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider = "login")
	public void login(String email , String pswd , String testcasename) throws IOException
	{
		System.out.println(driver.getTitle());
		
		OpenCart_Homepage hp = new OpenCart_Homepage(driver);
		
		hp.getMy_act().click();
		hp.getLogin().click();
		
		String title1 = driver.getTitle();
		Assert.assertEquals(title1, "Account Login");
		
		OpenCart_LoginPage lp = new OpenCart_LoginPage(driver);
		lp.getEmail().sendKeys(email);
		lp.getPassword().sendKeys(pswd);
		lp.getLogin_btn().click();
		
		String tc02login_success = null;
		rc.getss(tc02login_success, driver);
		
		String title2 = driver.getTitle();
		Assert.assertEquals(title2, "My Account");
		
		OpenCart_inLoginPage ilp = new OpenCart_inLoginPage(driver);
		ilp.getEdit_act().click();
		
		String title3 = driver.getTitle();
		Assert.assertEquals(title3, "My Account Information");
		
		OpenCart_MyAccount ma = new OpenCart_MyAccount(driver);
		ma.getTele().clear();
		ma.getTele().sendKeys("9999452876");
		ma.getButton2().click();
		
		String tc02_editinfo_success = null;
		rc.getss(tc02_editinfo_success, driver);
		
		hp.getMy_act().click();
		hp.getLogout().click();
		
		String Flat_File = "D:\\Selenium\\QET_CoE_Selenium_L2\\output_data\\tc02_op.txt";
		File FC = new File(Flat_File);
		FC.createNewFile();
		
		FileWriter FW = new FileWriter(Flat_File);
		BufferedWriter BW = new BufferedWriter(FW);
		BW.write("Successfully Logged Out");
		BW.close();
		
	}
	
	@DataProvider(name="login")
	public Object[][] getTestData() throws IOException
	{
		return rc.readDatafromExceltc02(0);
	}

}
