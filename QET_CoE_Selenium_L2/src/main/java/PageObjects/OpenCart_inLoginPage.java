package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenCart_inLoginPage {
public WebDriver driver;
	
	public OpenCart_inLoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".list-group > a:nth-child(2)")
	WebElement edit_act;
	
	@FindBy(linkText = "Your Store")
	WebElement your_s;

	public WebElement getEdit_act() {
		return edit_act;
	}

	public WebElement getYour_s() {
		return your_s;
	}
	

}
