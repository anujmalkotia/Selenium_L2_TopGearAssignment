package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenCart_MonitorPage {
public WebDriver driver;
	
	public OpenCart_MonitorPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Apple Cinema 30\"")
	WebElement m_name;
	
	@FindBy(css = ".price-new")
	WebElement m_price;
	
	@FindBy(xpath = "//button[@onclick=\"cart.add('42', '2');\"]")
	WebElement add_to_c;

	public WebElement getM_name() {
		return m_name;
	}

	public WebElement getM_price() {
		return m_price;
	}

	public WebElement getAdd_to_c() {
		return add_to_c;
	}
	

}
