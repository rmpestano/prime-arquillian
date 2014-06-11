Story: test primefaces push component

Scenario: test counter page

Given user is at push home

And user go to counter page

When user click in counter button

Then counter value should be incremented

Scenario: test viewparam page

Given user is at push home

And user is at viewparam page

When user refreshes the browser passing [value] as viewparam

Then [value] is displayed in the page

Examples:
|value|
|Primefaces|
|arquillian|
|JavaEE|
|ROCKS!!!!!!|

