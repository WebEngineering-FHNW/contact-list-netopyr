# Contact-List
An implementation of a contact-list.
 
Goals of this assignment:
* Become familiar with the usage of a template-engine.
* Write your first e2e-tests.

## Assigment 1
Implement the UI of the contact-list.
1. Familiarize yourself with the code, in particular with the controller
1. Implement the list of contacts
   * The user should be able to click a contact to see the details
1. Show the details of a selected contact
   * Show the name, the first email and the first phone-number in a table
   * Show a placeholder when no contact is selected
1. Simplify the details using a user-defined macro
1. Move the header section to a separate file, that can be reused

## Assignment 2
Add e2e-tests to validate your UI.
1. Implement a page object for the index-page
1. Write a test to validate that initially no contact details are visible
1. Write another test to validate that contact details are visible after the user selects one

## Assignment 3
Improve the UI.
1. Show the job-title and the company of a selected contact
1. Show all emails and phone-numbers of a contact
   * Hide the label, if no email/phone-number is present
1. Mark the selected contact in the contact-list

## Assignment 4
Implement more complex e2e-tests.
1. Write a test to validate that the displayed data of a selected contact is correct
1. Write another test to validate that the right data is displayed if a second contact is clicked
