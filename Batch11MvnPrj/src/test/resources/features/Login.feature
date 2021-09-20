@login
Feature: Login

	Background:
		Given user navigates to the Login page

	Scenario: login with valid username and password
		When user enters username as "dem7@gmail.com" and password as "xyzabc" 
		Then verify user is Logged in
		
	@sfL
	Scenario Outline: login with valid username and password
		When user enters username as "<user>" and password as "<pass>"
		Then verify user is Logged in
		Examples:
		| user | pass |
		|dem7@gmail.com|xyzabc|
		|gem7@gmail.com|xyzabc|
		|rem7@gmail.com|xyzabc|
		