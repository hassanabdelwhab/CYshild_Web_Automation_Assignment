CYshild Web Automation Assignment-Rigisteration Form

Description:
  
  This repository contains the source code for a web automation assignment using Selenium 

  The project focuses on testing the registration form functionality of the target website.
  Installation:

Prerequisites:

  Java 17 or later
  Selenium -Maven-TestNG
  GeckoDriver (if using Firefox) or ChromeDriver (if using Chrome)
  
Setting Up:
  1- Clone the Repository:
      git clone https://github.com/hassanabdelwhab/CYshild_Web_Automation_Assignment
      
  2-Install Dependencies:
      Use your project's build tool (e.g., Maven or Gradle) to install the necessary dependencies.
Usage:
  1-Running the Tests:
      Navigate to the project directory in your terminal or command prompt.
      Execute the tests using your project's build tool (e.g., mvn test for Maven).

      
Test Cases:

  1-validateIfAllElementsAreVisible(): Verifies that all elements on the registration form are visible.
  
  2-validateRegistrationFormWithInValidID(): Validates the registration form with an invalid user ID.
  
  3-validateRegistrationFormWithValidData(): Validates the registration form with valid data.
  
  
Additional Notes:

  1-The project uses a data-driven approach to test different registration scenarios.
  
  2-The GeneralConstants class contains test data and URLs. You can customize this class to adapt to different testing environments.
  
  3-The TestBase class provides a common setup and teardown mechanism for your tests.
  
  4-The PageBase class provide Provides common methods for navigating to URLs, finding elements, interacting with elements (click, scroll, type text), and waiting for elements to be available.
  
  5-The registerationPage Provides methods to interact with the elements on the registration form.
  
  6- The XML File provided XML file defines a TestNG suite for running your web automation tests.
  
     this XML file configures TestNG to run the RegisterFormTest class using a default browser_Parallel Execution.
     
  7-Report: HTML file displays the TestNG test results for your "Registration form Test" suite.
  
     
