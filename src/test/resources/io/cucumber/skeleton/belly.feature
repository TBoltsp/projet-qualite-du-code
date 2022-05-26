Feature: Belly

  Scenario: a few cukes
    Given I have 10 cukes in my belly
    When I wait 1 hour
    Then my belly should growl
   # And I take a coffee

  Scenario: less cakes
    Given I have 1 cukes in my belly
    When I wait 1 hour
    Then my belly should not growl


  Scenario: more cakes and more time
    Given I have 10 cukes in my belly
    When I wait 2 hours
    Then my belly should not growl

  Scenario: some cakes and not enough times
    # When I wait 2 hour    # essayez pour voir
    Given I have 20 cukes in my belly
    When I wait 2 hours
    Then my belly should growl


  Scenario: some cakes on a table
    Given I have this cukes in my belly
      | CukeName    | Number |
      | baba        | 2      |
      | forêt noire | 2      |
      | petit lun   | 3      |
      | banofee     | 2      |
    When I wait 1 hours
    Then my belly should not growl

  Scenario: too much cakes on a table
    Given I have this cukes in my belly
      | CukeName    | Number |
      | baba        | 2      |
      | forêt noire | 2      |
      | petit lun   | 3      |
      | banofee     | 3     |
    When I wait 1 hours
    Then my belly should growl
