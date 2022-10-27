package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage extends PageBase {

	public DashBoardPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//*[@class='navbar-brand']")
	WebElement title1;
	public WebElement title1() {
		return title1;
	}
	@FindBy(xpath="//*[@class='page-header']")
	WebElement headtitle;
	public WebElement headtitle() {
		return headtitle;
	}
	@FindBy(xpath="//footer//p['1']")
	WebElement dashcopyrights;
	public WebElement dashcopyrights() {
		return dashcopyrights;
	}
	@FindBy(xpath="//*[contains(text(),'Welcome')]")
	WebElement welcome;
	public WebElement welcome() {
		return welcome;
	}
	@FindBy(xpath="//strong[normalize-space()='mmagdy2275@gmail.com']")
	WebElement email_title;
	public WebElement email_title() {
		return email_title;
	}
	
	@FindBy(xpath="//*[normalize-space()='Switch to old theme']")
	WebElement theme;
	public WebElement theme() {
		return theme;
	}
	

}
