package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenCart_FindYourFavoriteBrand {
public WebDriver driver;
	
	public OpenCart_FindYourFavoriteBrand(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#content > div")
	List<WebElement> brs;

	public List<WebElement> getBrs() {
		return brs;
	}
	
	
	
	

}
