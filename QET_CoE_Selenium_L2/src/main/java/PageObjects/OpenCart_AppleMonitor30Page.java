package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenCart_AppleMonitor30Page {
	
public WebDriver driver;
	
	public OpenCart_AppleMonitor30Page(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "input[value=\"11\"]")
	WebElement chckbox1;
	
	@FindBy(css = "#input-option208")
	WebElement text1;
	
	@FindBy(css = "#input-option217")
	WebElement dropdown1;
	
	@FindBy( css = "#input-option209")
	WebElement text2;
	
	@FindBy(css = "#button-upload222")
	WebElement upload_btn;
	
	@FindBy(css = "#input-option219")
	WebElement date;
	
	@FindBy(css = "#input-option221")
	WebElement time;
	
	@FindBy(css = "#input-option220")
	WebElement date_time;
	
	@FindBy(css = "#input-quantity")
	WebElement quantity;
	
	@FindBy(css = "button[id=\"button-cart\"]")
	WebElement add_to_c_1;

	public WebElement getChckbox1() {
		return chckbox1;
	}

	public WebElement getText1() {
		return text1;
	}

	public WebElement getDropdown1() {
		return dropdown1;
	}

	public WebElement getText2() {
		return text2;
	}

	public WebElement getUpload_btn() {
		return upload_btn;
	}

	public WebElement getDate() {
		return date;
	}

	public WebElement getTime() {
		return time;
	}

	public WebElement getDate_time() {
		return date_time;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getAdd_to_c_1() {
		return add_to_c_1;
	}

}
