@login
Feature: Login feature
  As a user, I should validate login functionality

  @regression
  Scenario Outline: User is able to login with valid credentials
    Given I am on login page
    When I enter username as "<Username>" and password as "<Password>"
    And I click on login button
    Then I should be navigated to home page

    Examples:

      | Username              | Password    |
      | Pooja19.cse@gmail.com | Stupid#1234 |
#      | rahulvarma411@gmail.com  | Secit@3456 |
#      | singhanjuli497@gmail.com | 1234       |

  @smoke
  Scenario: User is able to login with valid credentials
    Given I am on login page
    When I enter username as "Pooja10.cse@gmail.com" and password as "Stupid#876"
    And I click on login button
    Then I should validate error message "Invalid login"
    And I click on Add button for "Deals"
