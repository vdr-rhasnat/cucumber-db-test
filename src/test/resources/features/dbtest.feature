Feature: DB Test
  Scenario: Database Test
    Given Sql server connection
    Then I should get connection status "Success"
    And Table "Contacts" should exists
    And I should get data from table

