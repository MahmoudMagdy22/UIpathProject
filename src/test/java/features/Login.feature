Feature: Login
 
@implemented
@login1   
Scenario:  Check the page title 
    Given  The user open the login page
    Then   The page title is "Login"
 
@implemented
@login2       
Scenario Outline:  Enter a wrong password for the email registered before
    Given  The user open the login page
    When   The user enter an email not registered before "<email>"
    And    The user enter an invalid password "<password>"
    Then   An error message appears  "<error message>"

    Examples: 
      | email                      | password | error message                               | 
      | s.mahallel99@gmail.com     |1231234as | These credentials do not match our records. | 
  
@implemented
@login3
Scenario Outline:  Enter empty value inlogin page email field
    Given  The user open the login page
    When   The user enter nothing in email field "<email>"
    Then   The system appear an error email tooltip "<error tooltip>"

    Examples: 
      | email           | error tooltip              | 
      |                 | Please fill out this field.| 
    

@implemented
@login4     
Scenario:  Check the intial status of remember me check box
    Given  The user open the login page
    Then   The remember me  check box is unchecked


@current-implementation   
@login5 
Scenario:  Check the Copyright year
    Given  The user open the login page
    Then   The Copyright year should be "Copyright © "+the actual year +" ACME Systems" 

@not-implemented-yet
@login6    
Scenario:  Check the label text 
    Given  The user open the login page
    Then   The label texts should be "Login" and "Home" and "To continue, please authenticate here" and  "Email:" and "Password:"
    
@not-implemented-yet
@login7      
Scenario Outline:  Enter loginpage with valid dta
  Given    The user open the login page
    When   The user provids valid email "<email>"
    And    The user provids valid password "<password>"
    And    The user click the remeber me check box
    Then   The system should redirect to the dashboard page

      Examples: 
      | email                     | password
      | mmagdy2275@gmail.com      | nm131013  
          
@not-implemented-yet
@login8
Scenario Outline:  Enter empty value in password field
    Given  The user open the login page
    When   The user non value in password field "<password>"
    Then   The system appear an error password tooltip .

    Examples: 
      | password           | error message               | 
      |                    | Please fill out this field  | 
      
@not-implemented-yet
@login9                  
Scenario:  Enter invaled email formate in email field
    Given  The user open the login page
    When   The user enter  invalid Emails "<email>"
    Then   An  error appears  .

     
      
@not-implemented-yet
@login10       
Scenario Outline:  Enter with email not registered before
    Given  The user open the login page
    When   The user entered email not registered before in the system "<email>" and "<password>"
    Then   The system appears an error message with the content "<error message>"

    Examples: 
      | email                      | password  |error message                               | 
      | s.mahallel9999@gmail.com   | 112232aa  | These credentials do not match our records. |
      
    
@not-implemented-yet
@login11
Scenario:   Check the login link
    Given   The user open the dashboard page
    When    The user clicks on the logout link
    Then    The system do nothing

@not-implemented-yet
@login12 
Scenario:   Check the home link
    Given   opening the dashboard page
    When    The user clicks the home link
    Then    The Login page appear
    

    
      
       
       