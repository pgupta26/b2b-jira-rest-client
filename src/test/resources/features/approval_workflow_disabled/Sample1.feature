@story:B2BS-8844 @Regression @Storefronts
Feature: Jira Test With Single Scenario Outline


  @test:B2BS-8919 @B2BS-Positive-Test
  Scenario Outline: 01. Validate user name for different sets of data
    Given Username is <userName>

    Examples:
      | userName         |
      | Test1            |
      | Test2            |
      | Test3            |
      | Test4            |
      | Test5            |

