package stepDefinition;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
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

public class Steps {
	static WebDriver driver;
	static pages.RegisterationPage registerationpage;
	public static  WebDriverWait wait;
	
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
        
        String Url ="https://acme-test.uipath.com";
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        //pages initiation
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
         driver.navigate().to(Url);
         driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        
    }
	
	
	@Given("The user open the registration page")
	public void the_user_open_the_registration_page() {
	    
	}
	@When("The user enter empty value in email field {string}")
	public void the_user_enter_empty_value_in_email_field(String string) {
	    
	}
	@Then("The system appear an error message {string}")
	public void the_system_appear_an_error_message(String string) {
	   
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
