Feature: Login and view latest article

Scenario Outline: Login and view latest article

Given user already launched straitstimes application
Then user open drawer menu
Then tap on LOGIN button
Then enter "<username>" and "<password>" tap on continue button
Then verify user has logged in successfully
Then tap on latest tab and tap on first article
Then verify that article loading sucessfully with image/video

# username and password parameterized in Examples section
Examples:
	| username				     | password |
	| wijerathna.nilmi@gmail.com	 | Test1234 |
