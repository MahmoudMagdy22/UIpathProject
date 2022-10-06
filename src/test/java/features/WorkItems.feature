Feature: Work Item

@not-implemented-yet
@Autom  
Scenario:  Check the items of type WI3 
    Given  The user open the Work Items
    And    check that only 4 items of type "WI3" is presented
    
@not-implemented-yet
@medium     
Scenario:  Check that item details shows the right values
    Given  The user open the Work Items
    And    Choose a random item and save the data of random item
    When   Click symbol search
    Then   Work Item details appear
    And    The url contain the the WIID of the seleced random item
    And    Under Work Item Details section shows the right data (WIID_Type_Status_Date) of selected random item
    When   User click on button Update Work Item
    Then   A new windows pop Up
    Given  The User change the status of the item to rejected
    When   The user click on Update Work Item
    Then   Then an alert with following appears "Please fill in the complete update form!"
    Given  The user add comment and click again on Update Work Item
    Then   Then an alert with following appears "Work Item was updated accordingly"
    Given  The user navigate back to work item table and check the status of random selected item
    Then   The item status is changed to "Rejected"

@not-implemented-yet
@important      
Scenario Outline:  Change items status
    Given  The user open the Work Items
    And    The user choose item  "<WIID>"
    When   Click symbol search
    Then   Work Item details appears
    When   User click on button Update Work Item
    Then   A new windows pop Up
    Given  The User change the status of the item to "<Status>" and add comment and click on Update Work Item
    Then   Then an alert with following appears "Work Item was updated accordingly"
    Given  The user navigate back to work item table and check the status of random selected item
    Then   The item status is changed to "<Status>"
    Given  The user click on reset data
    Then   "Account - Reset Test Data" appear
    When   The user click on Reset Test Data
    Then   Progress bar appear
    And    Alert with the following appear "Your Test Data has been successfully reset."
    When   The user click OK 
    Then   The alert disappear and the progress bar
    And    The data in Work item table is reseted

      Examples: 
      | WIID       | Status   |
      | 57064719   | Completed|
      | 57064719   | Rejected |
          
