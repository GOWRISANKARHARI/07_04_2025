Feature: Newsletter Subscription in applicataion 
  
  @Newsletter
  Scenario Outline: Newsletter subscription validation
    Given the user is on the login page
    When the user enters email "hariabi2502@gmail.com" and password "hariabi2502"
    Then the user should be logged in successfully
    When the user enters "<email>" for newsletter subscription
    Then the user should see "<expected_message>"
    
    Examples:
  |email                |expected_message|
  |hariabi2502@gmail.com|Thank you for signing up! A verification email has been sent. We appreciate your interest.|
  |harias@@@@@2|Enter valid email|
  |            |Enter valid email|