package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	
	}

	@FindBy(xpath="//*[@class='page-header']")
	WebElement logintitle;
	
	public WebElement logintitle() {
		return logintitle;
		}
	
	@FindBy(xpath="//*[@id='email']")
	WebElement email;
	public WebElement email() {
		return email;
			}
	
	@FindBy(xpath="//*[@id='password']")
	WebElement pass;
	public WebElement pass() {
		return pass;
			}
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement submit;
	public WebElement submit() {
		return submit;
	}
	
		@FindBy(xpath="//strong[normalize-space()='These credentials do not match our records.']")
	WebElement passwordnote;
	public WebElement passwordnote() {
		return passwordnote;
	}
	
	@FindBy(xpath="//*[@id='remember']")
	WebElement remember;
	public WebElement remember() {
		return remember;
	}
	
	@FindBy(xpath="//p[1]")
	WebElement copyright;
	public WebElement copyright() {
		return copyright;
	}
	
	@FindBy(xpath="//*[@class='page-header']")
	WebElement title1;
	public WebElement title1() {
		return title1;
	}
	
	@FindBy(xpath="//*[@href='https://acme-test.uipath.com/home']")
	WebElement title2;
	public WebElement title2() {
		return title2;
	}
	@FindBy(xpath="//*[normalize-space()='To continue, please authenticate here']")
	WebElement title3;
	public WebElement title3() {
		return title3;
	}
	@FindBy(xpath="//*[@for='email']")
	WebElement title4;
	public WebElement title4() {
		return title4;
	}
	@FindBy(xpath="//*[@for='password']")
	WebElement title5;
	public WebElement title5() {
		return title5;
	}
	@FindBy(xpath="//*[normalize-space()='Log Out']")
	WebElement logout;
	public WebElement logout() {
		return logout;
	}
	@FindBy(xpath="//*[@href='https://acme-test.uipath.com/home']")
	WebElement homebutton;
	public WebElement homebutton() {
		return homebutton;
	}
	
}
