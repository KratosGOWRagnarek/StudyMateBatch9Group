Feature: Test student functionality
@regression
  Scenario: Successfully add a new student
    Given the base url is "https://backend.studymate.us"
    And the endpoint path is "/api/students"
    And the origin header is set to "https://codewise.studymate.us"
    And the valid token is provided
    And then request content type is "application/json"
    And the request body contains following fields
      | name        | Salim           |
      | lastName    | Aryanov         |
      | phoneNumber | 7777777777      |
      | email       | samal@gmail.com |
      | groupId     | 0               |
      | studyFormat | ONLINE          |
    When I send a POST request
    Then verify status code is 200
    And verify response body contains key "message" and value "New student successfully saved"

  Scenario: Successfully retrieve all students
    Given the base url is "https://backend.studymate.us"
    And the endpoint path is "/api/students"
    And the origin header is set to "https://codewise.studymate.us"
    And the valid token is provided
    When I send GET request
    Then verify status code is 200
    Then verify group response contains expected text

  Scenario: Successfully delete a student by ID
    Given the base url is "https://backend.studymate.us/api/students"
    And the endpoint path is "/458"
    And the origin header is set to "https://codewise.studymate.us"
    And the valid token is provided
    When I send DELETE request
    Then verify status code is 200
    And verify response body contains key "message" and value "Student successfully deleted"