@tag
Feature: Calculator

  Scenario: add two numbers
    Given Two input values, 1 and 2
    When I add the two values
    Then I expect the result 3


  Scenario Outline: add two numbers
    Given Two input values, <first> and <second>
    When I add the two values
    Then I expect the result <result>
    Examples:
      | first | second | result |
      | 1 | 12 | 13 |
      | -1 | 6 | 5 |
      | 2 | 2 | 4 |

  Scenario: rvs and sqr scenarios
    Given Two input values, 4 and rvs
    When I calculate the given operation
    Then I expect the new result 0.25


  Scenario Outline: rvs and sqr scenarios
    Given Two input values, <Input> and <opt>
    When I calculate the given operation
    Then I expect the new result <result>
    Examples:
      | Input | opt | result |
      | 4 | rvs | 0.25 |
      | 4 | sqr | 2 |
      | -1 | sqr | Bad Input! |
      | 0  | rvs | Bad Input! |
