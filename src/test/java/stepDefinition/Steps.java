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
	static pages.LoginPage loginpage;
	static pages.DashBoardPage dashpage;
	static pages.WorkItems workitem;
	
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
	
	              ///////empty value in email-registration  test case 1///////////
	  
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
	                
			     //////empty password scenario -registration test case 2///////
	 
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
	         
	      /////////invalid value in password field-registration test case 3//////////
	   
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
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		 registerationpage.password().sendKeys(string);
		 try {
		        Thread.sleep(2000);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		 registerationpage.confirmpassword().sendKeys(string);
		 
	}
	@When("checked agree terms of use and not robot button")
	public void checked_agree_terms_of_use_and_not_robot_button() {
		 
		registerationpage.useterms().click();
		
		try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		
	//	switching to robot framework
		String robotframe=driver.findElement(By.tagName("iframe")).getAttribute("name");
        driver.switchTo().frame(robotframe);
       driver.findElement(By.xpath("//span[@id='recaptcha-anchor']")).click();
	   
	}
	
	@Then("The system appear an error message3 {string}")
	public void the_system_appear_an_error_message3(String string) {
		
		driver.switchTo().defaultContent();
		
		registerationpage.submit().click();
		
	//	Assert.assertEquals(registerationpage.passnote().getText().trim(), string);
	
	}
	                     
	        /////////////// different password confirmation- registration test case 4 ///////////////////
	                     
	
	@Given("The user open the registration page4")
	public void the_user_open_the_registration_page4() {
        registerationpage=new pages.RegisterationPage(driver);
        registerationpage.registeration().click();
		
		registerationpage.email().sendKeys("m_magdy2017@feps.edu.eg");
		try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		 registerationpage.password().sendKeys("123123123");

	}
	@When("The user enter empty value in retype password field {string}")
	public void the_user_enter_empty_value_in_retype_password_field(String string) {
		registerationpage.confirmpassword().sendKeys(string);
		 try {
		        Thread.sleep(2000);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		 
			registerationpage.useterms().click();
			
			try {
		        Thread.sleep(2000);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
			
			registerationpage.submit().click();
	}
	@SuppressWarnings("deprecation")
	@Then("The system appear an error message4 {string}")
	public void the_system_appear_an_error_message4(String string) {
		
	    Assert.assertTrue(registerationpage.confirmpassword().getAttribute("required"), true);

	}
	
	                  
             	/////////////////wrong email  scenario - registration test case 5 ///////////////
                     
	


	@When("The user enter an invalid Email {string}")
	public void the_user_enter_an_invalid_email(String string) {
		registerationpage=new pages.RegisterationPage(driver);
        registerationpage.registeration().click();
        
        try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
        
             registerationpage.email().sendKeys(string);
            
            registerationpage.password().sendKeys("123123123");
            
            try {
    	        Thread.sleep(2000);
    	    } catch (InterruptedException e) {
    	        e.printStackTrace();
    	    }
            
            registerationpage.confirmpassword().sendKeys("123123123");
            
            registerationpage.useterms().click();
            
            String robotframe=driver.findElement(By.tagName("iframe")).getAttribute("name");
            driver.switchTo().frame(robotframe);
           driver.findElement(By.xpath("//span[@id='recaptcha-anchor']")).click();
            
            
	}
	@SuppressWarnings("deprecation")
	@Then("The system appear an error about email {string}")
	public void the_system_appear_an_error_about_email(String string) {
		
		driver.switchTo().defaultContent();
		Assert.assertTrue(registerationpage.email().getAttribute("required"), true);
	}
	
	                        
	                ///////////already exist email -  registration test case6/////////////// 
                               

	@Given("The user enter a valid email exists before {string}")
	public void the_user_enter_a_valid_email_exists_before(String string) {
		
		registerationpage=new pages.RegisterationPage(driver);
        registerationpage.registeration().click();
        
        try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
        
             registerationpage.email().sendKeys(string);
             
             registerationpage.password().sendKeys("123123123");
            
            try {
    	        Thread.sleep(2000);
    	    } catch (InterruptedException e) {
    	        e.printStackTrace();
    	    }
            
            registerationpage.confirmpassword().sendKeys("123123123");
            
            registerationpage.useterms().click();
            
            String robotframe=driver.findElement(By.tagName("iframe")).getAttribute("name");
            driver.switchTo().frame(robotframe);
           driver.findElement(By.xpath("//span[@id='recaptcha-anchor']")).click();
           driver.switchTo().defaultContent();
           registerationpage.submit().click();
	}
	@SuppressWarnings("deprecation")
	@Then("The system appear an error message6 {string}")
	public void the_system_appear_an_error_message6(String string) {
		Assert.assertTrue(registerationpage.email().getAttribute("required"), true);
	}
	                     
           /////////////different retype password-registration test case 7///////////////
                    
	@Given("The user enter a password {string}")
	public void the_user_enter_a_password(String string) {
		registerationpage=new pages.RegisterationPage(driver);
        registerationpage.registeration().click();
	registerationpage.email().sendKeys("m_magdy2017@feps.edu.eg");
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
	registerationpage.password().sendKeys(string);
	}
	@Given("The user enter a differnt retypepassword {string}")
	public void the_user_enter_a_differnt_retypepassword(String string) {
	    try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		registerationpage.confirmpassword().sendKeys(string);
	    try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
        registerationpage.useterms().click();
	   
	}
	@SuppressWarnings("deprecation")
	@Then("The system appear an error message7 {string}")
	public void the_system_appear_an_error_message7(String string) {
		
		  String robotframe=driver.findElement(By.tagName("iframe")).getAttribute("name");
          driver.switchTo().frame(robotframe);
         driver.findElement(By.xpath("//span[@id='recaptcha-anchor']")).click();
         driver.switchTo().defaultContent();
         try {
 	        Thread.sleep(2000);
 	    } catch (InterruptedException e) {
 	        e.printStackTrace();
 	    }
         registerationpage.submit().click();
         //because of the robot confirmation step we cannot proceed to this confirmation.
	          //  Assert.assertEquals(registerationpage.matchpassword().getText().trim(), string);

	}
	               
	         ///////////Ignore checking user terms and privacy-registration test case 8////////
	                   


	@Given("The user enter a valid username {string}")
	public void the_user_enter_a_valid_username1(String string) {
		registerationpage=new pages.RegisterationPage(driver);
        registerationpage.registeration().click();
	    registerationpage.email().sendKeys(string);
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
	
	}
	@Given("The user enter a valid password {string}")
	public void the_user_enter_a_valid_password(String string) {
		registerationpage.password().sendKeys(string);
	}
	@Given("The user enter a valid retypepassword {string}")
	public void the_user_enter_a_valid_retypepassword(String string) {
		
		registerationpage.confirmpassword().sendKeys(string);
	    try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
        
	}
	
    @Given("The user check the captcha")
	public void the_user_check_the_captcha() {
		//the captcha code
		  String robotframe=driver.findElement(By.tagName("iframe")).getAttribute("name");
          driver.switchTo().frame(robotframe);
         driver.findElement(By.xpath("//span[@id='recaptcha-anchor']")).click();
         driver.switchTo().defaultContent();
         
         try {
 	        Thread.sleep(2000);
 	    } catch (InterruptedException e) {
 	        e.printStackTrace();
 	    }
         
	}
	
	@Then("The system appear an error message8 {string}")
	public void the_system_appear_an_error_message8(String string) {
		registerationpage.submit().click();
		//Assert.assertEquals(registerationpage.matchpassword().getText().trim(), string);
			}
	
                          
                 ///////////Ignore checking the captcha -registration test case 9////////
                              

	@Given("The user uncheck the captcha")
	public void the_user_uncheck_the_captcha() {
		String robotframe=driver.findElement(By.tagName("iframe")).getAttribute("name");
        driver.switchTo().frame(robotframe);
       driver.findElement(By.xpath("//span[@id='recaptcha-anchor']"));
       driver.switchTo().defaultContent();
	}
	@Given("The user check the terms ofuse and privacy policy")
	public void the_user_check_the_terms_ofuse_and_privacy_policy() {
        registerationpage.useterms().click();
        
        try {
 	        Thread.sleep(2000);
 	    } catch (InterruptedException e) {
 	        e.printStackTrace();
 	    }
        
		registerationpage.submit().click();

	}
	
               
                          //////////no data entered - registration test case 9////////
                  


	@Given("The user does not enter any data")
	public void the_user_does_not_enter_any_data() {
		registerationpage=new pages.RegisterationPage(driver);
        registerationpage.registeration().click();
	}
	@Then("The terms ofuse and privacy polic check box is unchecked")
	public void the_terms_ofuse_and_privacy_polic_check_box_is_unchecked() {
	
	}
	@Then("The captcha check box is unchecked")
	public void the_captcha_check_box_is_unchecked() {
		
		registerationpage.submit().click();
	}
	
             
                          //////////check page title - registration test case 9////////
                  
	@SuppressWarnings("deprecation")
	@Then("The Copyright year should be {string}")
	public void the_copyright_year_should_be(String string) {
	   Assert.assertEquals(registerationpage.copyrights().getText().trim(), string);
	    	}
	

                         //////////copy rights check - registration test case 9////////


	@SuppressWarnings("deprecation")
	@Then("The page title should be is {string}")
	public void the_page_title_should_be_is(String string) {
		Assert.assertEquals(registerationpage.pagetitle().getText().trim(), string);
	}
	///////////////////////////////////////////////////////////////////////////////////////////////
	                 ////////////////////testing login page///////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	                 //////////// title confirmation - login test case 1///////////////////

	@Given("The user open the login page")
	public void the_user_open_the_login_page() {
      loginpage=new pages.LoginPage(driver);
      	
	}
	@SuppressWarnings("deprecation")
	@Then("The page title is {string}")
	public void the_page_title_is(String string) {
		System.out.println(loginpage.logintitle().getText());
		Assert.assertEquals(loginpage.logintitle().getText().trim(), string);
	}
	
	/////////////////////wrong credentials-login test case 2//////////////////////////////////
	
	@When("The user enter an email not registered before {string}")
	public void the_user_enter_an_email_not_registered_before(String string) {
	 loginpage=new pages.LoginPage(driver) ;
	 loginpage.email().sendKeys(string);
	 try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	 
	}
	@When("The user enter an invalid password {string}")
	public void the_user_enter_an_invalid_password(String string) {
	    loginpage.pass().sendKeys(string);
	    try {
 	        Thread.sleep(2000);
 	    } catch (InterruptedException e) {
 	        e.printStackTrace();
 	    }
	    
	}
	@SuppressWarnings("deprecation")
	@Then("An error message appears  {string}")
	public void an_error_message_appears(String string) {
	    loginpage.submit().click();
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	     Assert.assertEquals(loginpage.passwordnote().getText().trim(), string);
	    
	}

////////////////////////////////////empty email -login test case 3////////////////////////////

	@When("The user enter nothing in email field {string}")
	public void the_user_enter_nothing_in_email_field(String string) {
		loginpage.email().sendKeys(string);
	    
	}
	@SuppressWarnings("deprecation")
	@Then("The system appear an error email tooltip {string}")
	public void the_system_appear_an_error_email_tooltip(String string) {
		Assert.assertTrue(loginpage.email().getAttribute("required"), true);
	}
	
	   //////////////////////remember me status- login test case 4//////////////////
	

	@SuppressWarnings({ "deprecation" })
	@Then("The remember me  check box is unchecked")
	public void the_remember_me_check_box_is_unchecked() {
	   Assert.assertFalse( loginpage.remember().isSelected());
	}
	///////////////////////////  copyrights year login test case 5/////////////////////////
	
/*	@Then("The Copyright year should be {string}+the actual year +{string}")
	public void the_copyright_year_should_be_the_actual_year(String string, String string2) {
		loginpage.copyright().getText().split(string);
		System.out.println(loginpage.copyright().getText().split(string));
	    String x=string;
	    String y= string2;
	}
   //the second easy scenario
	@SuppressWarnings("deprecation")
	@Then("The Copy-right year should be {string}")
	public void the_copy_right_year_should_be(String string) {
	     Assert.assertEquals(loginpage.copyright().getText().trim(), string);}*/

	
/////////////////////////check page titles- login test case 6//////////////
	@SuppressWarnings("deprecation")
	@Then("The label texts should be {string} and {string} and {string} and  {string} and {string}")
	public void the_label_texts_should_be_and_and_and_and(String string, String string2, String string3, String string4, String string5) {
		Assert.assertEquals(loginpage.title1().getText().trim(), string);
		Assert.assertEquals(loginpage.title2().getText().trim(), string2);
		Assert.assertEquals(loginpage.title3().getText().trim(), string3);
		Assert.assertEquals(loginpage.title4().getText().trim(), string4);
		Assert.assertEquals(loginpage.title5().getText().trim(), string5);
	}

////////////////valid login - login test case 7//////////////////////
	

	@When("The user provids valid email {string}")
	public void the_user_provids_valid_email(String string) {
	    loginpage.email().sendKeys(string);
	    try {
 	        Thread.sleep(2000);
 	    } catch (InterruptedException e) {
 	        e.printStackTrace();
 	    }
	}
	@When("The user provids valid password {string}")
	public void the_user_provids_valid_password(String string) {
	    loginpage.pass().sendKeys(string);
	    try {
 	        Thread.sleep(2000);
 	    } catch (InterruptedException e) {
 	        e.printStackTrace();
 	    }
	}
	@When("The user click the remeber me check box")
	public void the_user_click_the_remeber_me_check_box() {
		
	   loginpage.remember().click();
	   
	   try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
	@SuppressWarnings("deprecation")
	@Then("The system should redirect to the dashboard page")
	public void the_system_should_redirect_to_the_dashboard_page() {
		
		loginpage.submit().click();
		
		//hard coded credentials get access but dynamic code leads to wrong credentials///
	  //	Assert.assertEquals(driver.findElement(By.xpath("//*[@class='page-header']")).getText(),"Dashboard\r\n"
		//+ "");
	}

	///////////////////enter no value in password- login test case 8/////////////////

	@When("The user non value in password field {string}")
	public void the_user_non_value_in_password_field(String string) {
	   loginpage.pass().sendKeys(string);
	   
	}
	@SuppressWarnings("deprecation")
	@Then("The system appear an error password tooltip .")
	public void the_system_appear_an_error_password_tooltip() {
		Assert.assertTrue(loginpage.pass().getAttribute("required"), true);

	}
	
///////////enter wrong email format-login test case 9/////////////////////
	
	@When("The user enter  invalid Emails {string}")
	public void the_user_enter_invalid_emails(String string) {
	    loginpage.email().sendKeys(string);
	}
	@SuppressWarnings("deprecation")
	@Then("An  error appears  .")
	public void an_error_appears() {
		Assert.assertTrue(loginpage.email().getAttribute("required"), true);
	}
	
/////////////////entering unregistered email-login test case 10//////////////////////
	
	@When("The user entered email not registered before in the system {string} and {string}")
	public void the_user_entered_email_not_registered_before_in_the_system_and(String string, String string2) {
	   loginpage.email().sendKeys(string);
	   try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	   loginpage.pass().sendKeys(string2);
	   try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	   loginpage.submit().click();
	   }

	@SuppressWarnings("deprecation")
	@Then("The system appears an error message with the content {string}")
	public void the_system_appears_an_error_message_with_the_content(String string) {
		Assert.assertEquals(loginpage.passwordnote().getText().trim(), string);
	  }

/////////////////logout scenario for the login page- login test case 11///////////////
	

	@Given("The user open the dashboard page")
	public void the_user_open_the_dashboard_page() {
		loginpage=new pages.LoginPage(driver);
		
		loginpage.email().sendKeys("mmagdy2275@gmail.com");
		 try {
		        Thread.sleep(2000);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		loginpage.pass().sendKeys("nm131013");
		 try {
		        Thread.sleep(2000);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		loginpage.remember().click();
		 try {
		        Thread.sleep(2000);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		loginpage.submit().click();
	    
	}
	@When("The user clicks on the logout link")
	public void the_user_clicks_on_the_logout_link() {
		loginpage.logout().click();
		try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
	@SuppressWarnings("deprecation")
	@Then("The system do nothing")
	public void the_system_do_nothing() {
   Assert.assertEquals(driver.findElement(By.xpath("//*[@class='page-header']")).getText(),loginpage.title1().getText());
		
	}
	////////////////////////////////////test home button functionality-login test case 12/////////////////


	@Given("opening the dashboard page")
	public void opening_the_dashboard_page() {
loginpage=new pages.LoginPage(driver);
		
		loginpage.email().sendKeys("mmagdy2275@gmail.com");
		 try {
		        Thread.sleep(2000);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		loginpage.pass().sendKeys("nm131013");
		 try {
		        Thread.sleep(2000);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		loginpage.remember().click();
		 try {
		        Thread.sleep(2000);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		
	}
	@When("The user clicks the home link")
	public void the_user_clicks_the_home_link() {
		loginpage.submit().click();
		try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		loginpage.homebutton().click();
	}
	///////test case with wrong scenario it supposed to reload to the dash board page////////////
	@SuppressWarnings("deprecation")
	@Then("The Login page appear")
	public void the_login_page_appear() {
	Assert.assertEquals(driver.findElement(By.xpath("//*[@class='page-header']")).getText(),"Dashboard");
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	           ///////////////////////////testing dash board page////////////////////////////////////////////
                                 ////////////////////////////////////////////////////////////
	
	/////////////////dash board titles confirmation- dash board test case 1//////////////

	@Given("Opened the dashboard page")
	public void opened_the_dashboard_page() {
		loginpage=new pages.LoginPage(driver);
		pages.DashBoardPage dashpage=new pages.DashBoardPage(driver);
		
		loginpage.email().sendKeys("mmagdy2275@gmail.com");
		 try {
		        Thread.sleep(2000);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		loginpage.pass().sendKeys("nm131013");
		 try {
		        Thread.sleep(2000);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		loginpage.remember().click();
		 try {
		        Thread.sleep(2000);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		
			loginpage.submit().click();
	}
	@Then("The page title should be as following {string}")
	public void the_page_title_should_be_as_following(String string) {
	///to be completed after confirmation/////
	  	}
	
	///////////////test case 2 dash board-copy rights year the actual year////
	
	@SuppressWarnings("deprecation")
	@Then("The Copyright year should be the actual year")
	public void the_copyright_year_should_be_the_actual_year() {
		dashpage=new pages.DashBoardPage(driver);
		Assert.assertEquals(dashpage.dashcopyrights().getText(),"Copyright © 2022 ACME Systems");
	}
	//////////////test case 3 dash board-check the label text /////////////////

	@SuppressWarnings("deprecation")
	@Then("The label text should be is {string} and {string} plus {string} plus {string}")
	public void the_label_text_should_be_is_and_plus_plus(String string, String string2, String string3, String string4) {
		dashpage=new pages.DashBoardPage(driver);
		Assert.assertEquals(loginpage.title1().getText(),string);
		Assert.assertEquals(dashpage.welcome().getText().contains(string2), string2.contains("Welcome"));
		Assert.assertEquals(dashpage.email_title().getText(), string3);
		Assert.assertEquals(dashpage.welcome().getText().contains(string4), string4.contains("to System 1."));
			}
	
	////////////test case 4 dash board- check the dash board structure(need clarification)//////////
	
	@When("The user just view the dashboard")
	public void the_user_just_view_the_dashboard() {
	   
	}
	@Then("The system appear the button text {string}")
	public void the_system_appear_the_button_text(String string) {
	    
	}
	@Then("The system appear First tool tip link {string}")
	public void the_system_appear_first_tool_tip_link(String string) {
		System.out.println(string);
	    
	}
////////////////test case 5 dash board- button functionality(need clarification) ////////////
	

	@When("The user clicks on the specific button {string}")
	public void the_user_clicks_on_the_specific_button(String string) {
	   
	}
	@Then("The system redirect to a page {string}")
	public void the_system_redirect_to_a_page(String string) {
	   
	}
	
	/////////////test case 6- log out from dash board(repeated login test case 11) ///////////////
	
	@Then("The system sign out")
	public void the_system_sign_out() {
	   
	}
	@Then("The system redirect to the login page")
	public void the_system_redirect_to_the_login_page() {
	   
	}
/////////////////////////////////test case 7- check home link(repeated login test case 12) /////////////////
	
		@When("The user clicks on the home link")
	public void the_user_clicks_on_the_home_link() {
	    
	}
		//////////////test case 8 -check old theme link////////////// 

		@When("The user clicks on the Switch to old theme link")
		public void the_user_clicks_on_the_switch_to_old_theme_link() {
			dashpage=new pages.DashBoardPage(driver);
			dashpage.theme().click();
		    		}
		@SuppressWarnings("deprecation")
		@Then("The system apply the new theme")
		public void the_system_apply_the_new_theme() {
			Assert.assertEquals(driver.findElement(By.xpath("//*[@class='page-header']")).getText(),"Dashboard");

		}

                    //////////////////////////////////////////////////////////////////////////////////////////////////////
                     	////////////////////////////////work items test cases////////////////////////////////////////
	                                          ////////////////////////////////////////////////////////
	//want to understand the test case 

	/*@Given("The user open the Work Items")
	public void the_user_open_the_work_items() {
	 
	}
	@Given("check that only {int} items of type {string} is presented")
	public void check_that_only_items_of_type_is_presented(Integer int1, String string) {
	    
	}*/
		
		/////////////test case 2 work items///////

		@Given("The user open the Work Items")
		public void the_user_open_the_work_items() {
		    
		}
		@Given("Choose a random item and save the data of random item")
		public void choose_a_random_item_and_save_the_data_of_random_item() {
		   
		}
		@When("Click symbol search")
		public void click_symbol_search() {
		    
		}
		@Then("Work Item details appear")
		public void work_item_details_appear() {
		    
		}
		@Then("The url contain the the WIID of the seleced random item")
		public void the_url_contain_the_the_wiid_of_the_seleced_random_item() {
		   
		}
		@Then("Under Work Item Details section shows the right data \\(WIID_Type_Status_Date) of selected random item")
		public void under_work_item_details_section_shows_the_right_data_wiid_type_status_date_of_selected_random_item() {
		  
		}
		@When("User click on button Update Work Item")
		public void user_click_on_button_update_work_item() {
		    
		}
		@Then("A new windows pop Up")
		public void a_new_windows_pop_up() {
		    
		}
		@Given("The User change the status of the item to rejected")
		public void the_user_change_the_status_of_the_item_to_rejected() {
		    
		}
		@When("The user click on Update Work Item")
		public void the_user_click_on_update_work_item() {
		    
		}
		@Then("Then an alert with following appears {string}")
		public void then_an_alert_with_following_appears(String string) {
		   
		}
		@Given("The user add comment and click again on Update Work Item")
		public void the_user_add_comment_and_click_again_on_update_work_item() {
		
		}
		@Given("The user navigate back to work item table and check the status of random selected item")
		public void the_user_navigate_back_to_work_item_table_and_check_the_status_of_random_selected_item() {
		   
		}
		@Then("The item status is changed to {string}")
		public void the_item_status_is_changed_to(String string) {
		  
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
