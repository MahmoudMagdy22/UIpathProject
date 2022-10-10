Feature: Register

@implemented
@low1 
 Scenario Outline:  Enter empty value in email field
    Given  The user open the registration page
    When   The user enter empty value in email field "<email>"
    Then   The system appear an error message "<error message>"

    Examples: 
      | email           | error message               | 
      |                 | Please fill out this field  | 

@not-implemented-yet
@low2
Scenario Outline:  Enter empty value in password field
    When   The user enter empty value in password field "<password>"
    Then   The system appear an error message2 "<error message>"

    Examples: 
      | password           | error message               | 
      |                    | Please fill out this field  | 

@not-implemented-yet 
@low3
Scenario Outline:  Enter invalid value password field
    When   The user enter invalid value in password field "<password>"
    And checked agree terms of use and not robot button
    Then   The system appear an error message3 "<error message>"

    Examples: 
      | password           | error message               | 
      | abc                | The password must be at least 8 characters  | 
@not-implemented-yet
@low       
Scenario Outline:  Enter empty value in retype password field
    Given  The user open the registration page
    When   The user enter empty value in retype password field "<retypepassword>"
    Then   The system appear an error message "<error message>"

    Examples: 
      | retypePassword  | error message               | 
      |                 | Please fill out this field  | 

@not-implemented-yet
@medium                  
Scenario Outline:  Enter invaled email formate in email field
    Given  The user open the registration page
    When   The user enter an invalid Email "<email>"
    Then   The system appear an error message "<error message>"

    Examples: 
      | email        | error message            | 
      | testets      | Please enter true Email  | 
      | test@test    | Please enter true Email  | 
      | test.test    | Please enter true Email  | 

@not-implemented-yet     
@important        
Scenario Outline:  Registration with a valid email exists before
    Given  The user open the registration page
    When   The user enter a valid email exists before "<email>"
    Then   The system appear an error message "<error message>"

    Examples: 
      | email                    | error message                     | 
      | s.mahallel99@gmail.com   | The email has already been taken. | 

@not-implemented-yet     
@medium       
Scenario Outline:  Enter differnt password from retype password
    Given  The user open the registration page
    When   The user enter a password "<password>"
    And    The user enter a differnt retypepassword "<retypepassword>"
    Then   The system appear an error message "<error message>"

    Examples: 
      | password        | retypepassword | error message  
      | 123456          | 1234567        | The password confirmation does not match.

@not-implemented-yet      
@medium      
Scenario Outline:  Uncheck the Term and privacy check box
    Given  The user open the registration page
    When   The user enter a valid username "<email>"
    And    The user enter a valid password "<password>"
    And    The user enter a valid retypepassword "<retypepassword>"
    And    The user check the captcha
    Then   The system appear an error message "<error message>"

    Examples: 
      | email                     | password    | retypepassword | error message  
      | s.mahallel99@gmail.comb   | 123456789a  | 123456789a     | The terms ofuse and privacy policy should be checked

@not-implemented-yet    
@medium 
Scenario Outline:  Uncheck the captcha check box
    Given  The user open the registration page
    When   The user enter a valid username "<email>"
    And    The user enter a valid password "<password>"
    And    The user enter a valid retypepassword "<retypepassword>"
    And    The user uncheck the captcha
    And    The user check the terms ofuse and privacy policy
    Then   The system appear an error message "<error message>"

   Examples: 
      | email                     | password    | retypepassword | error message  
      | s.mahallel99@gmail.comb   | 123456789a  | 123456789a     | Please validate that you are a human!
      
@not-implemented-yet
@medium     
Scenario:  Check the intial status of the check boxes
    Given  The user open the registration page
    When   The user does not enter any data
    Then   The terms ofuse and privacy polic check box is unchecked
    And    The captcha check box is unchecked

@not-implemented-yet
@medium     
Scenario:  Check the Copyright year
    Given  The user open the registration page
    When   The user does not enter any data
    Then   The Copyright year should be "copyright year"

@not-implemented-yet
@medium     
Scenario:  Check the label text 
    Given  The user open the registration page
    When   The user does not enter any data
    Then   The label text should be is "label text"

@not-implemented-yet
@low     
Scenario:  Check the page title 
    Given  The user open the registration page
    When   The user does not enter any data
    Then   The page title should be is "title text"
       
@not-implemented-yet
@important      
Scenario Outline:  Enter true values in all fields
  Given    The user open the registration page
    When   The user enter a valid username "<email>"
    And    The user enter a valid password "<password>"
    And    The user enter a valid retypepassword "<retypepassword>"
    And    The user check the captcha
    And    The user check the terms ofuse and privacy policy
    Then   The system should redirect to the dashboard page

      Examples: 
      | email                     | password    | retypepassword 
      | s.mahallel99@gmail.comb   | 123456789a  | 123456789a     
      


