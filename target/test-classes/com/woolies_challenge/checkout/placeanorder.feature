# place an order Feature file contains scenario to add 2 items in the cart and proceed to checkout

  @websmoke
  Feature: Placing an order
    Verify if the user is able to place an order on the site

    Scenario: add 2 items to the cart and place an order
      Given User is on the homepage
      When User sign in with valid credentials
      Then User add two items to the cart
      Then User clicks on the checkout button and proceed to checkout
      Then User navigates to address details page
      And User proceeds to checkout
      And User agrees to terms of service and clicks on proceed to checkout page button
      And User choose to pay by "bankwire" option
           #because bankwire is faster than check
      Then User clicks on the confirm my order button
      And Order confirmation page displays order details with message "Your order on My Store is complete."



