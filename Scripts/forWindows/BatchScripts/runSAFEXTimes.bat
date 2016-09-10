@echo off

REM Refresh the archivedLogs folder 
cd C:\SourceCode\SAFE\logs
rmdir /S /Q TempLogs
mkdir TempLogs

REM Check to see if we need to save the logs
echo Would you like to save the log files?
echo 1. Yes
echo 2. No
set /p saveLogs=""

REM Set variables to control loop
set /p numTimesToRun="How many times would you like to run? "
set count=0

REM Generate a timestamp for the report files
for /f "tokens=2 delims==" %%a in ('wmic OS Get localdatetime /value') do set "dt=%%a"
set "YY=%dt:~2,2%" & set "YYYY=%dt:~0,4%" & set "MM=%dt:~4,2%" & set "DD=%dt:~6,2%"
set "HH=%dt:~8,2%" & set "Min=%dt:~10,2%" & set "Sec=%dt:~12,2%"
set timestamp=%MM%-%DD%-%YYYY%_%HH%-%Min%-%Sec%

REM Loop through running Test Cases and creating files for archivedLogs
:Loop 
if %count% lss %numTimesToRun% (
	REM Run the Test Cases
	cd C:\SourceCode\SAFE\Scripts\forWindows\BatchScripts
	call SAFE.bat
	
	REM Make the directory for the Test Report
	cd C:\SourceCode\SAFE\logs\TempLogs
	mkdir TestReport[%count%]
	
	REM Move the Log file to the new TestReport directory
	cd C:\SourceCode\SAFE\test-log
	move logfile.log C:\SourceCode\SAFE\logs\TempLogs\TestReport[%count%]
	
	REM Generate the Allure-Reports
	cd C:\SourceCode\SAFE
	call mvn site
	
	REM Move the Allure-Reports to the new TestReport directory
	move C:\SourceCode\SAFE\target\allure-reports C:\SourceCode\SAFE\logs\TempLogs\TestReport[%count%]
	
	REM Increment the counter
	set /a "count=count+1"
	
	REM Restart the loop
	goto Loop
)
goto END

:END
if	%saveLogs% equ 1 (
	cd C:\SourceCode\SAFE\logs
	rename TempLogs SeleniumMultiRunLogs[%timestamp%]
	move SeleniumMultiRunLogs[%timestamp%] ArchivedLogs
	cd C:\SourceCode\SAFE
	
)

REM Notify the user that we are done here
echo *********************************************
echo *	
echo *	FINISHED!
echo *
echo *********************************************