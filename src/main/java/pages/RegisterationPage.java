package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterationPage extends PageBase{

	public RegisterationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText="Register")
	WebElement registeration;
	
	public WebElement registeration () {
		return registeration;
	}
	
	@FindBy(id="email")
	WebElement email;
	public WebElement email() {
		return email;
	}
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement submit;
	
	public WebElement submit() {
		return submit;
	}
	
	@FindBy(xpath="//*[@id='password']")
	WebElement password;
	public WebElement password() {
		return password;
	}
	@FindBy(id="password-confirm")
	WebElement confirmpassword;
	public WebElement confirmpassword() {
		return confirmpassword;
	}
	@FindBy(xpath="//*[@name='checkTerms']")
	WebElement useterms;
	
	public WebElement useterms() {
		return useterms;
	}
	
	@FindBy(partialLinkText="not a robot")
	WebElement robotcheck;
	public WebElement robotcheck() {
		return robotcheck;
	}
	
	@FindBy(xpath="//*[@role='alert']//strong")
	WebElement passnote;
	
	public WebElement passnote() {
		return passnote;
	}
	
	

}
