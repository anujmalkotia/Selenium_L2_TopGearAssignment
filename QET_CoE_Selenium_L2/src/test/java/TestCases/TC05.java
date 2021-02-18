package TestCases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.OpenCart_FindYourFavoriteBrand;
import PageObjects.OpenCart_Homepage;
import PageObjects.OpenCart_LoginPage;
import PageObjects.OpenCart_YourStore;
import PageObjects.OpenCart_inLoginPage;
import Resources.base;
import Utility.ReusableComponents;

public class TC05 extends base {
	
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
		
		String tc05_login_success = null;
		rc.getss(tc05_login_success, driver);
		
		OpenCart_inLoginPage ilp = new OpenCart_inLoginPage(driver);
		ilp.getYour_s().click();
		
		OpenCart_YourStore ys = new OpenCart_YourStore(driver);
		ys.getBr().click();
		
		String tc05_brand_ss = null;
		rc.getss(tc05_brand_ss, driver);
		
		OpenCart_FindYourFavoriteBrand fb = new OpenCart_FindYourFavoriteBrand(driver);
		int count = fb.getBrs().size();
		System.out.println(count);
		
		
		for(int i=1;i<=count;i++)
		{
			if(i!=3)
			{
				driver.findElement(By.xpath("//*[@id=\"content\"]/div["+i+"]/div/a")).click();
				String title = driver.getTitle();
				rc.getss(title, driver);
				driver.navigate().back();
			}
			else
			{
				for(int j=1;j<=2;j++)
				{
					driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div["+j+"]/a")).click();
					String title = driver.getTitle();
					rc.getss(title, driver);
					driver.navigate().back();
				}
			}
			
		}
		
		hp.getMy_act().click();
		hp.getLogout().click();
		
		String Flat_File = "D:\\Selenium\\QET_CoE_Selenium_L2\\output_data\\tc05_op.txt";
		File FC = new File(Flat_File);
		FC.createNewFile();
		
		FileWriter FW = new FileWriter(Flat_File);
		BufferedWriter BW = new BufferedWriter(FW);
		BW.write("Successfully Logged out");
		BW.close();
		FW.close();

	}
	
	@DataProvider(name="login")
	public Object[][] getTestData() throws IOException
	{
		return rc.readDatafromExceltc02(0);
	}
}
