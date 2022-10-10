package stepDefinition;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import pages.RegisterationPage;

    public class Steps {
	private static final String Initiate = null;
	static WebDriver driver;
	static pages.RegisterationPage registerationpage ;
	public static  WebDriverWait wait;
	
	
	@SuppressWarnings("deprecation")
	@Before()
    public void startdriver() {
                String D="chrome";
        
        if (D.equalsIgnoreCase("chrome")) {
            
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            
        }else if(D.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        
        String Url ="https://acme-test.uipath.com/login";
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        //pages initiation
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
         driver.navigate().to(Url);
         driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        
    }
	
	
///////////////////////////////////////////
	///////first test case///////////
	////////////////////////////////
    @SuppressWarnings("deprecation")
	@Given("The user open the registration page")
	public void the_user_open_the_registration_page1() {
	registerationpage=new pages.RegisterationPage(driver);
	    registerationpage.registeration().click();
	     Assert.assertEquals(driver.findElement(By.xpath("//*[@class='page-header']")).getText().trim(), "Register");
	    
	}
	@When("The user enter empty value in email field {string}")
	public void the_user_enter_empty_value_in_email_field(String string) {
		
		registerationpage.email().sendKeys(string);
		registerationpage.submit().click();
			    
	}
	
  @SuppressWarnings("deprecation")
  @Then("The system appear an error message {string}")
	public void the_system_appear_an_error_message(String string) {
    Assert.assertTrue(registerationpage.email().getAttribute("required"), true);
	 
	}
	///////////////////////////////////////////////////
			     //////second test scenario///////
	//////////////////////////////////////////////////
	
	@When("The user enter empty value in password field {string}")
	public void the_user_enter_empty_value_in_password_field(String string) {
		registerationpage=new pages.RegisterationPage(driver);
		 registerationpage.password().sendKeys(string);
	}
	@SuppressWarnings("deprecation")
	@Then("The system appear an error message2 {string}")
	public void the_system_appear_an_error_message2(String string) {
		Assert.assertTrue(registerationpage.password().getAttribute("required"), true);
	}
	
	
	//////////////////////////////////////////////
	      /////////third test case //////////
	/////////////////////////////////////////////
	
	@When("The user enter invalid value in password field {string}")
	public void the_user_enter_invalid_value_in_password_field(String string) {
		registerationpage=new pages.RegisterationPage(driver);
		registerationpage.registeration().click();
		try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		registerationpage.email().sendKeys("m_magdy2017@feps.edu.eg");
		try {
	        Thread.sleep(3000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		 registerationpage.password().sendKeys(string);
		 try {
		        Thread.sleep(3000);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		 registerationpage.confirmpassword().sendKeys(string);
		 
	}
	@When("checked agree terms of use and not robot button")
	public void checked_agree_terms_of_use_and_not_robot_button() {
		 
		registerationpage.useterms().click();
		try {
	        Thread.sleep(3000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		registerationpage.robotcheck().click();
	   
	}
	@SuppressWarnings("deprecation")
	@Then("The system appear an error message3 {string}")
	public void the_system_appear_an_error_message3(String string) {
		registerationpage.submit().click();
		Assert.assertEquals(registerationpage.passnote().getText().trim(), string);
	
	}



















	
	
	
	
	
	
	
	
	

	
	
	@After()

	public void takeScreenshotOnFailure(Scenario scenario) {
	    
	    if (scenario.isFailed()) {
	        
	        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	        scenario.attach(screenshot, "image/png","");
	    }
	    //try remove the wait to check the error of socet
	    
	    try {
	        Thread.sleep(3000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }

	    
	    driver.quit();
	    try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }

	    
	}
}
