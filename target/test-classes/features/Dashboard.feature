Feature: Dashboard
 
@not-implemented-yet
@low     
Scenario:  Check the page title 
    Given  The user open the dashboard page
    Then   The page title should be is "ACME System 1 -  Dashboard"

@not-implemented-yet
@medium     
Scenario:  Check the Copyright year
    Given  The user open the dashboard page
    Then   The Copyright year should be the actual year

@not-implemented-yet
@medium     
Scenario:  Check the label text 
    Given  The user open the dashboard page
    Then   The label text should be is "Dashboard" and "Welcome, " plus "s.mahallel9999@gmail.com" plus " to System 1."

@not-implemented-yet   
@important 
Scenario Outline:  Check the buttons text and tool tip
    Given  The user open the dashboard page
    When   The user just view the dashboard
    Then   The system appear the button text "<button text>" 
    And    The system appear First tool tip link "<first tooltip link>"
    And    The system appear First tool tip link "<second tooltip link>"
    And    The system appear First tool tip link "<third tooltip link>"
    And    The system appear First tool tip link "<forth tooltip link>"
    And    The system appear First tool tip link "<fifth tooltip link>"
    And    The system appear First tool tip link "<sixth tooltip link>"
    And    The system appear First tool tip link "<seventh tooltip link>"
    And    The system appear First tool tip link "<eighth tooltip link>"
    And    The system appear First tool tip link "<ninth tooltip link>" 

    Examples: 
      | button text         | first tooltip link           | second tooltip link          | third tooltip link          | forth tooltip link         | fifth tooltip link   | sixth tooltip link | seventh tooltip link | eighth tooltip link | ninth tooltip link  |                                       
      | User options        | Download Client and Support  | Reset test data              | Change password             | Check training assignments |                      |                    |                      |                     |                     |
      | Work Items          |                              |                              |                             |                            |                      |                    |                      |                     |                     |
      | Accounts            | Add account modification     | View account history         |                             |                            |                      |                    |                      |                     |                     |
      | Checks              | Search for Check             | Submit Check Copy            |                             |                            |                      |                    |                      |                     |                     |
      | Vendors             | Search for Vendor            | Add Vendor                   | Download Resource Report    | Resource Order             | Download Vendor List | Vendor Inventory   | Upload Order         |Vendors Stock        | Create Order        |
      | Invoices            | Search for Invoice           | Add Invoice Details          | Delete Invoice              |                            |                      |                    |                      |                     |                     |
      | Internal Invoices   | Download Monthly Invoices    | Download Full Invoice Report |                             |                            |                      |                    |                      |                     |                     |
      | Reports             | Download Monthly Report      | Upload Yearly Report         |                             |                            |                      |                    |                      |                     |                     | 
      | Students            | Download Enrollment Report   | Download Result Report       | Score Card                  |                            |                      |                    |                      |                     |                     |
      | Health Care         | Download Daily Appointment   | Download Treatment Report    | National Insurance Planning |                            |                      |                    |                      |                     |                     |
      | Employees           |                              |                              |                             |                            |                      |                    |                      |                     |                     |
      | Bank                | Add Account                  |                              |                             |                            |                      |                    |                      |                     |                     |
      | Customer Service    |                              |                              |                             |                            |                      |                    |                      |                     |                     |
      
@not-implemented-yet   
@important 
Scenario Outline:  Check the buttons redirect to other page
    Given  The user open the dashboard page
    When   The user clicks on the specific button "<button text>"
    Then   The system redirect to a page "<redirection page>" 
    
    Examples: 
      | button text         | redirection page                                               
      | Work Items          | work-items
      | Employees           | employees
      | Customer Service    | callcenter
      
@not-implemented-yet      
@important 
Scenario:   Check the logout link
    Given   The user open the dashboard page
    When    The user clicks on the logout link
    Then    The system sign out
    And     The system redirect to the login page

@not-implemented-yet
@medium 
Scenario:   Check the home link
    Given   The user open the dashboard page
    When    The user clicks on the home link
    Then    The system do nothing

@not-implemented-yet   
@medium 
Scenario:   Check the switch to old theme link
    Given   The user open the dashboard page
    When    The user clicks on the Switch to old theme link
    Then    The system apply the new theme 
    
    
    
    
    
    
    
    
    
    
    
    
    
    