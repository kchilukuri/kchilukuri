@test
Feature: Google Search feature

  Scenario Outline: To test google search functionality
    Given User is on <searchEngine> home page
    When User perform search with <searchKey>
    Then User see all the valid search results

    Examples: 
      | searchKey | searchEngine |
      | "java"    | "bing"       |
      | "java"    | "google"     |
