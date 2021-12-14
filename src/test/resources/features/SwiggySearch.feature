Feature: Swiggy Search
  Scenario: Search pizza
    Given visit "https://www.swiggy.com/"
    Given location "New Delhi, Delhi, India"
    When open search
    When search "pizza"
    Then "Pizza Pizza" is suggested 
    #Result can changed depends on availability
  Scenario: Search rice
    Given visit "https://www.swiggy.com/"
    Given location "New Delhi, Delhi, India"
    When open search
    When search "rice"
    Then "Dayal Dhaba" is suggested
    #Result can changed depends on availability
  Scenario: Search Poori
    Given visit "https://www.swiggy.com/"
    Given location "New Delhi, Delhi, India"
    When open search
    When search "poori"
    Then "Saravana Bhavan" is suggested
    #Result can changed depends on availability