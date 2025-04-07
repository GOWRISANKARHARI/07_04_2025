Feature: User Login
  As a user I want to login to the application

Background:
 		Given the user is on the login page
  @ValidLogin
  Scenario: Successful login with valid credentials
    When the user enters email "hariabi2502@gmail.com" and password "hariabi2502"
    Then the user should be logged in successfully

  @InvalidLogin
  Scenario Outline: Failed login with invalid credentials
    When the user enters email "<email>" and password "<password>"
    Then the user should see an error message
    Examples:
      |email              |password|
      |hariabiii@gmail.com|123456|
      |hariabi1@gmail.com|112233|