package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenCart_LoginPage {
	
public WebDriver driver;
	
	public OpenCart_LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#input-email")
	WebElement email;
	
	@FindBy(css = "#input-password")
	WebElement password;
	
	@FindBy(css ="#content > div > div:nth-child(2) > div > form > input")
	WebElement login_btn;

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin_btn() {
		return login_btn;
	}
	
	

}
