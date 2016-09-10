<div style="width: 100%; margin: 0 auto">![Project][logo]</div>
-------------
[logo]: https://github.com/ramirezp6856/SAFE/blob/master/img/icon.ico
# SAFE 
### Selenium Automated Framework for Everyone

> Automated Framework that utilizes Selenium WebDriver, Selenide, TestNG, Allure Reports, and Maven. 
> This repo provides a quick and easy way of getting an Automated Framework up and running.

***
## Initial Setup
***
After downloading and setting up Maven, clone the SAFE repo from gitHub.

Once that is finished downloading, extract it to the desired file location.

Navigate into the folder and change the file paths in the following locations to the file path of your SAFE folder
```
	-\SAFE\pom.xml
		Line 84: <suiteXmlFile><Drive:>/SAFE/CurrentTestPlan/testng.xml</suiteXmlFile>
	-\SAFE\src\automation\utilities\Driver.java
		Line 72: System.setProperty("webdriver.chrome.driver", "<Drive:>\\SAFE\\3rdParty\\chromedriver-win32-2.21\\chromedriver.exe");
		Line 77: System.setProperty("webdriver.ie.driver", "<Drive:>\\SAFE\\3rdParty\\IEDriverServer_win32_2.52.0\\IEDriverServer.exe");
	-\SAFE\Scripts\forWindows\BatchScripts\runTestPlan.bat
		Find and Replace all instances of C: with <Drive:>
	-\SAFE\Scripts\forWindows\BatchScripts\Selenium.bat (Windows users only! Sorry Mac users...)
		Change cd C:\SAFE to <Drive:>\SAFE
	-\SAFE\Scripts\forWindows\BatchScripts\runTestPlan.bat
		Add <Drive:> to the top of the file
```
Verify JDK is configured correctly as an environment variable, run as configuration for eclipse, and build path for eclipse.

Create the following xml files within the SAFE root folder.
```
	-CurrentTestPlan\testng.xml
	-testcasebucket.xml
```
Note: Right click on project -> Hover over Maven -> Click Update Project
***
## Task Scheduler Setup (Windows Only)
***
###### Setting Up a Task
```
	1. Open the Task Scheduler
	2. Select Create Task from the Actions bar on the right side of the window
	3. Enter a Name and Description for the task
	4. Navigate to the Triggers tab
	5. Click New
	6. Choose a schedule for the task.
	7. Click OK
	8. Navigate to the Actions tab
	9. Click New
	10. Click the Browse button
	11. Navigate to <Drive:>/SAFE/Scripts/forWindows/BatchScripts
	12. Select runTestPlan.bat and click Open
	13. Enter "<Test_Plan_Name>.xml" into the Add arguments text box.
	14. Click OK
	15. Click OK
```
###### Verifying the Task was Created
```
	1. Click on the arrow next to Task Scheduler Library
	2. Scroll through top menu and the test should be listed.
```	
***
## Updating
***
To update, clone the latest patch from gitHub.
Copy and replace the following folders:
```	
	/SAFE/src
	/SAFE/TestPlans
```
Navigate into the folder and change the file paths in the following locations to the file path of your Selenium folder
```
	-\SAFE\src\automation\utilities\Driver.java
		Line 72: System.setProperty("webdriver.chrome.driver", "<Drive:>\\SAFE\\3rdParty\\chromedriver-win32-2.21\\chromedriver.exe");
		Line 77: System.setProperty("webdriver.ie.driver", "<Drive:>\\SAFE\\3rdParty\\IEDriverServer_win32_2.52.0\\IEDriverServer.exe");
```
The Automated tests should now be updated.

***
## Running tests from cmd (Windows Only)
***
To run the test from the server enter these commands into a command prompt that is in administrator mode: 
```
	1. <drive>:
	2. cd <drive>:\SAFE\Scripts\forWindows\BatchScripts
	3. runTestPlan.bat SmokeTests.xml
```
After tests are finished, verify the Test Plan completed successfully by following these steps:
``` 
	1. Open the newest folder in <drive>:\SAFE\logs\archivedLogs
	2. Open /allure-reports/index.html
```
