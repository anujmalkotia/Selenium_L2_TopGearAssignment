package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenCart_MyAccount {
public WebDriver driver;
	
	public OpenCart_MyAccount(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#input-telephone")
	WebElement tele;
	
	@FindBy(css = ".btn.btn-primary")
	WebElement button2;
	
	@FindBy(css = ".nav.navbar-nav >li:nth-child(3)")
	WebElement comp;
	
	@FindBy(css = "#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li.dropdown.open > div > div > ul > li:nth-child(2) > a")
	WebElement monitor;

	public WebElement getTele() {
		return tele;
	}

	public WebElement getButton2() {
		return button2;
	}

	public WebElement getComp() {
		return comp;
	}

	public WebElement getMonitor() {
		return monitor;
	}
	
	 

}
