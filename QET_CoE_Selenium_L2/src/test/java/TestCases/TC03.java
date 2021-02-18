package TestCases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.OpenCart_AppleMonitor30Page;
import PageObjects.OpenCart_Homepage;
import PageObjects.OpenCart_LoginPage;
import PageObjects.OpenCart_MonitorPage;
import PageObjects.OpenCart_MyAccount;
import Resources.base;
import Utility.ReusableComponents;



public class TC03 extends base{
	
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
		
		String getc03login_success = null;
		rc.getss(getc03login_success, driver);
		
		OpenCart_MyAccount ma = new OpenCart_MyAccount(driver);
		ma.getComp().click();
		ma.getMonitor().click();
		
		String tc03monitor_success = null;
		rc.getss(tc03monitor_success, driver);
		
		String title2 = driver.getTitle();
		Assert.assertEquals(title2, "Monitors");
		
		OpenCart_MonitorPage mp = new OpenCart_MonitorPage(driver);
		String name = mp.getM_name().getText();
		String prize = mp.getM_price().getText();
		
		String Flat_File = "D:\\Selenium\\QET_CoE_Selenium_L2\\output_data\\tc03_Prize.txt";
		File FC = new File(Flat_File);
		FC.createNewFile();
		
		FileWriter FW = new FileWriter(Flat_File);
		BufferedWriter BW = new BufferedWriter(FW);
		BW.write(name);
		BW.write(prize);
		BW.close();
		
		mp.getAdd_to_c().click();
		
	}
	
	@Test(dataProvider="addtocart")
	public void apple_monitor(String txt, String txt_area , String date, String time , String dnt , String qty, String testcase) throws IOException
	{
		driver.get(rc.getProperty("apple_url"));
		driver.manage().window().maximize();
		
		String title1 = driver.getTitle();
		Assert.assertEquals(title1, "Apple Cinema 30");
		
		OpenCart_AppleMonitor30Page amp = new OpenCart_AppleMonitor30Page(driver);
		amp.getChckbox1().click();
		amp.getText1().sendKeys(txt);
		
		Select dropdown = new Select(amp.getDropdown1());
		dropdown.selectByValue("1");
		
		amp.getText2().sendKeys(txt_area);
		
		WebElement upload_btn = amp.getUpload_btn();
		//upload_btn.click();
		upload_btn.sendKeys("C:\\Users\\AN40063779\\Documents\\image.jfif");
		
		amp.getDate().sendKeys(date);
		amp.getTime().sendKeys(time);
		amp.getDate_time().sendKeys(dnt);
		amp.getQuantity().sendKeys(qty);
		
		String title2 = driver.getTitle();
		
		amp.getAdd_to_c_1().click();

		
		if(driver.getTitle().equalsIgnoreCase(title2))
		{
			String tc03adc_fail = null;
			rc.getss(tc03adc_fail, driver);
		}
		else
		{
			System.out.println("No error");
		}
		System.out.println("Radio button not available");
		
		OpenCart_Homepage hp1 = new OpenCart_Homepage(driver);
		hp1.getMy_act().click();
		hp1.getLogout().click();
		System.out.println("Successfully logged out");
		
		String Flat_File = "D:\\Selenium\\QET_CoE_SeleniumL2\\resources\\op.txt";
		File FC = new File(Flat_File);
		FC.createNewFile();
		
		FileWriter FW = new FileWriter(Flat_File);
		BufferedWriter BW = new BufferedWriter(FW);
		BW.write("Successfuly Logged Out");
		BW.close();
	}
	
	@DataProvider(name="addtocart")
	public Object[][] getTestData1() throws IOException
	{
		return rc.readDatafromExceltc02(1);
	}
	

	
	@DataProvider(name="login")
	public Object[][] getTestData() throws IOException
	{
		return rc.readDatafromExceltc02(0);
	}

}
