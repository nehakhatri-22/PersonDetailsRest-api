@WebserviceTest

Feature: Testing a REST API Users should be able to submit GET and POST  PUT requests to a web service,


  Scenario: Add person Record
    Given Setup a POST employee service API
    When setup of header
    And send a POST HTTP request
    Then i recieve a valid response

  Scenario: Update person Record
    Given Setup a PUT employee service API
    When setup of header
    And send a PUT HTTP request
    Then i recieve a valid response

  Scenario: Get person  Information
    Given Setup a GET employee service API
    When setup of header
    And send a GET HTTP request
    Then i recieve a valid response

  Scenario: Delete the Information
    Given Setup a DELETE employee service API
    When setup of header
    And send a DELETE HTTP request
    Then i recieve a valid response

