@regression
Feature: Google search and assert search result
  Background: User open the browser & is in google.com
    Given User Navigate to "https://www.google.com/"
    Scenario:User search specific keywords and assert search results & suggestions
      When User enter keyword "Foodics" & Click search
      And Clear search field & search another keyword "Foodics"
      And Click page 2 from paginator
      Then Number of results exist on UI
      And Click on page 3 and check number of results equals to page2
      And There is different search suggestions at the end of the page
