@groupFunctionalityAPI
Feature: Test Group functionality

  @apiCreateGroup @regression
  Scenario: Successfully create a group (API)

    Given the base url is "https://backend.studymate.us/api/groups"
    And the origin header is set to "https://codewise.studymate.us"
    And the valid token is provided
    And the request body contains key following fields
      | imageId      | 0                              |
      | groupName    | Batch9                         |
      | dateOfFinish | 2025-01-13                     |
      | description  | All of the students got offers |
    When I send a POST request
    Then verify status code is 200
    And verify response body contains key "message" and value "Group successfully saved"


  @apiGetGroups @regression
  Scenario: Successfully retrieve all groups
    Given the base url is "https://backend.studymate.us/api/groups"
    And the origin header is set to "https://codewise.studymate.us"
    And the valid token is provided
    When I send GET request
    Then verify status code is 200
    Then verify group response contains expected text



  @apiGetGroupById
  Scenario: Successfully retrieve group by its Id
    Given the base url is "https://backend.studymate.us/api/groups"
    And the endpoint path is "/250"
    And the origin header is set to "https://codewise.studymate.us"
    And the valid token is provided
    When I send GET request
    Then verify status code is 200
    And verify response body contains key "name" and value "Batch9"


  @apiDeleteGroup
  Scenario: Successfully delete a group by ID
    Given the base url is "https://backend.studymate.us/api/groups"
    And the endpoint path is "/250"
    And the origin header is set to "https://codewise.studymate.us"
    And the valid token is provided
    When I send DELETE request
    Then verify status code is 200
    And verify response body contains key "message" and value "Group successfully moved to trash"