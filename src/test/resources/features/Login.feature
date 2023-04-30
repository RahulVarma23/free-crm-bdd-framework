
Feature: Login feature

  Scenario Outline: User is able to login with valid credentials
    Given I am on login page
    When I enter username as "<Username>" and password as "<Password>"
    And I click on login button
#    Then I should be navigated to home page

    Examples:

      | Username                 | Password   |
      | Pooja19.cse@gmail.com    | Stupid#876 |
      | rahulvarma411@gmail.com  | Secit@3456 |
      | singhanjuli497@gmail.com | 1234       |



