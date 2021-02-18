package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenCart_Homepage {
	public WebDriver driver;
	
	public OpenCart_Homepage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".list-inline > li:nth-child(2)")
	WebElement my_act;
	
	@FindBy(css = ".dropdown-menu.dropdown-menu-right >li:nth-child(1)") 
	WebElement register;
	
	@FindBy(css = ".dropdown-menu.dropdown-menu-right>li:nth-child(5)")
	WebElement logout;
	@FindBy(css = "#top-links > ul > li.dropdown.open > ul > li:nth-child(2) > a")
	WebElement login;

	public WebElement getMy_act() {
		return my_act;
	}
	public WebElement getRegister() {
		return register;
	}
	public WebElement getLogout() {
		return logout;
	}
	public WebElement getLogin() {
		return login;
	}

	
	
	
	
	

}
