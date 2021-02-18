package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenCart_Registerpage {
public WebDriver driver;
	
	public OpenCart_Registerpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#input-firstname")
	WebElement fname;
	
	@FindBy(css = "#input-lastname")
	WebElement lname;
	
	@FindBy(css = "#input-email")
	WebElement email;
	
	@FindBy(css = "#input-telephone")
	WebElement telephone ;
	
	@FindBy(css = "#input-password")
	WebElement password;
	
	@FindBy(css = "#input-confirm")
	WebElement c_password;
	
	@FindBy(css = "input[name=\"agree\"]")
	WebElement chck_box1;
	
	@FindBy(css = ".btn.btn-primary")
	WebElement button1;
	
	@FindBy(xpath = "//*[@id=\"account-register\"]/div[1]")
	WebElement err_1;

	public WebElement getFname() {
		return fname;
	}

	public WebElement getLname() {
		return lname;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getTelephone() {
		return telephone;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getC_password() {
		return c_password;
	}

	public WebElement getChck_box1() {
		return chck_box1;
	}

	public WebElement getButton1() {
		return button1;
	}

	public WebElement getErr_1() {
		return err_1;
	}
	

	
	

}
