Feature: Register


  Scenario: User should able to register
    Given User should register with valid credentials
    Then User should verify the status code

  Scenario: User should input the valid credentials
    Given input valid credentials
    Then verify tokenStatusCode
  @wip
  Scenario: User should able to be authorized
    Given User should be authorized with valid credentials
    Then verify authorizedStatusCode
  @wip
  Scenario: User should able to see the collection
    Given user should see book list
    Then User should verify the BookStatusCode

  @wip
  Scenario: User should able to all books list from store
    Given User should see book list
    Then User verify the booksStatusCode

  @wip
  Scenario: User should able to add new book to the collection
    Given User should add new book
    Then User should verify the addBookStatusCode

  @wip
  Scenario: Usershould able to update the books
    Given User should update the collection
    Then User should verify the updateStatusCode
  @wip
  Scenario: User should able to delete a book from collection
    Given User should delete a book
    Then User should verify deleteStatusCode
  @wip
  Scenario: User should able to delete account
    Given User should delete account
    Then User should verify delete account status code