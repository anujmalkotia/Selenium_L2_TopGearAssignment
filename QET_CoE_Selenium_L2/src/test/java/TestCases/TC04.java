package TestCases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.OpenCart_Homepage;
import PageObjects.OpenCart_LoginPage;
import Resources.base;
import Utility.ReusableComponents;




public class TC04 extends base {
	
public WebDriver driver;
	
	ReusableComponents rc = new ReusableComponents();
	
	@BeforeClass
	public void method2() throws IOException 
	{
		driver = driverSetup();
		driver.get(rc.getProperty("home_url"));
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider = "login")
	public void addtocart(String email, String pswd, String testcasename) throws IOException
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
		
		String tc04_login_success = null;
		rc.getss(tc04_login_success , driver);
		
		List<WebElement> menu = driver.findElements(By.cssSelector(".nav.navbar-nav >li"));
		int count = menu.size();
		
		String Flat_File = "D:\\Selenium\\QET_CoE_Selenium_L2\\output_data\\tc04_op.txt";
		File FC = new File(Flat_File);
		FC.createNewFile();
		
		FileWriter FW = new FileWriter(Flat_File);
		BufferedWriter BW = new BufferedWriter(FW);
		BW.write("Menu links:" + count);
		
		
		for(int i =1;i<count+1;i++)
		{
			driver.findElement(By.cssSelector(".nav.navbar-nav >li:nth-child("+ i + ")")).click();;
			String a="menu_ss"+i;
			String ss_name=a;
			rc.getss(ss_name, driver);
		}
		
		hp.getMy_act().click();
		hp.getLogout().click();
		
		
		BW.append("\n Successfully logged out");
		BW.close();
		FW.close();
		
		
		

	}
	
	@DataProvider(name="login")
	public Object[][] getTestData() throws IOException
	{
		return rc.readDatafromExceltc02(0);
	}
}
