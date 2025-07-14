Feature: Verify authentication


#  @apiLoginSuccessfully @regression
#  Scenario: Successfully login with valid credentials (API)
#
#    Given the base url is "https://backend.studymate.us/api/auth"
#    And the endpoint is "/authenticate"
#    And the origin header is set to "https://codewise.studymate.us"
#    And the valid token is provided
#    And the request body contains key following fields
#      | email    | fromConfig |
#      | password | fromConfig |
#    When I send POST request
#    Then  verify status code is 200
#    And verify response body contains key "workspaceId" and value "1"
#
#
#  @apiForgotPassword @regression
#  Scenario: Successfully request password reset via email (API)
#
#    Given the base url is "https://backend.studymate.us/api/auth"
#    And the endpoint is "/forgotPassword"
#    And the origin header is set to "https://codewise.studymate.us"
#    And the valid token is provided
#    And the request body contains key following fields
#      | email | fromConfig |
#    When I send POST request
#    Then  verify status code is 200
#    And verify response body contains key "message" and value "Password reset email sent to this email"