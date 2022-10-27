Feature: Register

@done
@low1 
 Scenario Outline:  Enter empty value in email field
    Given  The user open the registration page
    When   The user enter empty value in email field "<email>"
    Then   The system appear an error message "<error message>"

    Examples: 
      | email           | error message               | 
      |                 | Please fill out this field  | 

@done
@low2
Scenario Outline:  Enter empty value in password field
    When   The user enter empty value in password field "<password>"
    Then   The system appear an error message2 "<error message>"

    Examples: 
      | password           | error message               | 
      |                    | Please fill out this field  | 

@done 
@low3
Scenario Outline:  Enter invalid value password field
    When   The user enter invalid value in password field "<password>"
    And    checked agree terms of use and not robot button
    Then   The system appear an error message3 "<error message>"

    Examples: 
      | password           | error message               | 
      | abc                | The password must be at least 8 characters  | 
@not-implemented-yet
@low4       
Scenario Outline:  Enter empty value in retype password field
    Given  The user open the registration page4
    When   The user enter empty value in retype password field "<retypepassword>"
    Then   The system appear an error message4 "<error message>"

    Examples: 
      | retypePassword  | error message               | 
      |                 | Please fill out this field  | 

@not-implemented-yet
@medium1                  
Scenario Outline:  Enter invaled email formate in email field
    
    When   The user enter an invalid Email "<email>"
    Then   The system appear an error about email "<error message>"

    Examples: 
      | email        | error message            | 
      | testets      | Please enter true Email  | 
      | test@test    | Please enter true Email  | 
      | test.test    | Please enter true Email  | 

@not-implemented-yet     
@important1        
Scenario Outline:  Registration with a valid email exists before
    Given  The user enter a valid email exists before "<email>"
    Then   The system appear an error message6 "<error message>"

    Examples: 
      | email                    | error message                     | 
      | s.mahallel99@gmail.com   | The email has already been taken. | 

@not-implemented-yet     
@medium2       
Scenario Outline:  Enter differnt password from retype password
    Given   The user enter a password "<password>"
    And    The user enter a differnt retypepassword "<retypepassword>"
    Then   The system appear an error message7 "<error message>"

    Examples: 
      | password        | retypepassword | error message  
      | 00123456        | 1234567        | The password confirmation does not match.

@not-implemented-yet      
@medium3      
Scenario Outline:  Uncheck the Term and privacy check box
    
    Given  The user enter a valid username "<email>"
    And    The user enter a valid password "<password>"
    And    The user enter a valid retypepassword "<retypepassword>"
    And    The user check the captcha
    Then   The system appear an error message8 "<error message>"

    Examples: 
      | email                     | password    | retypepassword | error message  
      | s.mahallel99@gmail.comb   | 123456789a  | 123456789a     | The terms ofuse and privacy policy should be checked

@not-implemented-yet    
@medium4 
Scenario Outline:  Uncheck the captcha check box
   
    Given  The user enter a valid username "<email>"
    And    The user enter a valid password "<password>"
    And    The user enter a valid retypepassword "<retypepassword>"
    And    The user uncheck the captcha
    And    The user check the terms ofuse and privacy policy
    Then   The system appear an error message "<error message>"

   Examples: 
      | email                     | password    | retypepassword | error message  
      | s.mahallel99@gmail.comb   | 123456789a  | 123456789a     | Please validate that you are a human!
      
@not-implemented-yet
@medium5     
Scenario:  Check the intial status of the check boxes
   
    Given   The user does not enter any data
    Then   The terms ofuse and privacy polic check box is unchecked
    And    The captcha check box is unchecked

@not-implemented-yet
@medium6     
Scenario:  Check the Copyright year
    
    When   The user does not enter any data
    Then   The Copyright year should be "Copyright © 2022 ACME Systems"


@not-implemented-yet
@low5    
Scenario:  Check the page title 
   
    When   The user does not enter any data
    Then   The page title should be is "Register by filling the below questionnaire."
       
@not-implemented-yet
@important2      
Scenario Outline:  Enter true values in all fields
  
    When   The user enter a valid username "<email>"
    And    The user enter a valid password "<password>"
    And    The user enter a valid retypepassword "<retypepassword>"
    And    The user check the captcha
    And    The user check the terms ofuse and privacy policy
    Then   The system should redirect to the dashboard page

      Examples: 
      | email                     | password    | retypepassword 
      | s.mahallel99@gmail.comb   | 123456789a  | 123456789a     
      


