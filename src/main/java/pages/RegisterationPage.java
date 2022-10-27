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
	
	@FindBy(xpath="//*[@id='email']")
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
		
	
	@FindBy(id="recaptcha-anchor-label")
	WebElement robotcheck;
	public WebElement robotcheck() {
		return robotcheck;
	}
	
	
	@FindBy(xpath="//strong[normalize-space()='The password must be at least 8 characters.']")
	WebElement passnote;
	
	public WebElement passnote() {
		return passnote;
	}
		@FindBy(xpath="//*[@role='alert']")
		WebElement matchpassword;
		
		public WebElement matchpassword() {
			return matchpassword;
		}
		
		@FindBy(xpath="//p[1]")
		WebElement copyrights;
		
		public WebElement copyrights() {
			return copyrights;
		}
		
		@FindBy(xpath="//*[normalize-space()='Register by filling the below questionnaire.']")
		WebElement pagetitle;
		
		public WebElement pagetitle() {
			return pagetitle;
		}
	
	
	

}
