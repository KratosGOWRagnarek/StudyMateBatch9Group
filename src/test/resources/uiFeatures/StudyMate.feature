Feature: Test StudyMate functionalities

  Scenario: Student adding validation and deleting check
    Given user goes to a website and enters valid credentials
    When user adds online and offline students
    Then user deletes offline student

  Scenario Outline: Add students with scenario outline
    Given user goes to a website and enters valid credentials
    When user goes to a student page
    And user adds students by '<name>','<lastname>','<phone>','<email>'
    Then user verifies that new students were added
    Examples:
      | name   | lastname | phone        | email            |
      | random | random   | random_phone | random@gmail.com |
      | random | random   | random_phone | random@gmail.com |
      | random | random   | random_phone | random@gmail.com |

