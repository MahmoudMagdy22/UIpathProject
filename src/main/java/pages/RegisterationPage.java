package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterationPage extends PageBase{

	public RegisterationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="")
	WebElement registeration;
	
	public WebElement registeration () {
		return registeration;
	}
	

}
