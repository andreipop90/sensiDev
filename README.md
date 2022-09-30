# sensiDev
Repository for code challenge

Project uses Page Object Model with Selenium WebDriver, TestNG and Allure for reporting.

Structure:
base package -> BasePage and BaseTest are superclasses that are extended by pages and tests.
BrowserFactory creates instances of Chrome, sets up chrome driver.

data package -> CredentialsModel class used for one test case (IncorrectLoginCredentialsErrorMessagesTest class)

sensidev.pages -> pages related to sensidev website, extend BasePage class
sensidev.tests (1st requirement of the test) -> tests related to sensidev website, extend BaseTest class

techlistic.page -> techlistic page related methods 
techlistic.tests (second requirement of the test) -> classes extend BaseTest

utils package -> classes that help testing

wiki.page -> class extend BasePage
wiki.test (3rd requirement) -> class extend BaseTest

NOTES:
1. removeElectricDeviceAndVerifyPresenceInListView() method might act inconsistent. the app is very buggy.
2. For the second requirement (CompleteFormBasedOnRequirementsTest class), the last step was to assert the title.
   "After you complete the last form check for the AUTOMATION PRACTICE ME title, as proof that the test has passed."
   After clicking the "Button", nothing happens therefore I didn't made the last assertion as the test would fail.
3. for the 3rd requirement, after running the test method in SearchTest class, please run the following command:
   allure generate target/allure-results/ --clean 
This will generate a report in the "allure-report" folder. From that folder, please open index.html in Chrome in order to check the results
4. Sorry for all the Thread.sleep(), I didn't have the time to come with a better solutions
