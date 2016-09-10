@echo off

cd C:\SourceCode\SAFE

if [%1] equ [] GOTO UserSpecified

REM Get Test Plan
set parameterPlan=%1
set parameterPlanName=%parameterPlan:~0,-4%

REM Rename testng.xml to testngdefault.xml
echo ************************************
echo *                                  *
echo *      Renaming default testng     *
echo *                                  *
echo ************************************
cd C:\SourceCode\SAFE\CurrentTestPlan
rename testng.xml testngDefault.xml


REM Move Test Plan to run to CurrentTestPlan
echo ************************************
echo *                                  *
echo *	    Moving %parameterPlan%      *
echo *                                  *
echo ************************************
cd C:\SourceCode\SAFE\TestPlans
rename %parameterPlan% testng.xml
move testng.xml C:\SourceCode\SAFE\CurrentTestPlan


REM Run Selenium
echo ************************************
echo *                                  *
echo *	   Running %parameterPlan%      *
echo *                                  *
echo ************************************
cd C:\SourceCode\SAFE\Scripts\forWindows\BatchScripts
call SAFE.bat


REM Build Allure-Reports site
echo ************************************
echo *                                  *
echo *	   Generating Report Site       *
echo *                                  *
echo ************************************
cd C:\SourceCode\SAFE
call mvn site


REM Reset testPlanToRun's name
echo ************************************
echo *                                  *
echo * Resetting %parameterPlan%'s Name *
echo *                                  *
echo ************************************
cd C:\SourceCode\SAFE\CurrentTestPlan
rename testng.xml %parameterPlan%


REM Make Directory for log files
echo ************************************
echo *                                  *
echo *	 Creating Directory for Logs    *
echo *                                  *
echo ************************************
for /f "tokens=2 delims==" %%a in ('wmic OS Get localdatetime /value') do set "dt=%%a"
set "YY=%dt:~2,2%" & set "YYYY=%dt:~0,4%" & set "MM=%dt:~4,2%" & set "DD=%dt:~6,2%"
set "HH=%dt:~8,2%" & set "Min=%dt:~10,2%" & set "Sec=%dt:~12,2%"
set "fullstamp=%MM%-%DD%-%YYYY%_%HH%-%Min%-%Sec%"
cd C:\SourceCode\SAFE\logs\ArchivedLogs
mkdir %parameterPlanName%Reports[%fullstamp%]


REM Move Logs to logs\ArchivedLogs
echo ************************************
echo *                                  *
echo *	      Moving Log files          *
echo *                                  *
echo ************************************
copy C:\SourceCode\SAFE\test-log\logfile.log C:\SourceCode\SAFE\logs\ArchivedLogs\%parameterPlanName%Reports[%fullstamp%]
copy C:\SourceCode\SAFE\CurrentTestPlan\%parameterPlan% C:\SourceCode\SAFE\logs\ArchivedLogs\%parameterPlanName%Reports[%fullstamp%]
move C:\SourceCode\SAFE\target\allure-reports C:\SourceCode\SAFE\logs\ArchivedLogs\%parameterPlanName%Reports[%fullstamp%]


REM Move Test Plan to run back to TestPlans
echo ************************************
echo *                                  *
echo *	     Moving %parameterPlan%     *
echo *                                  *
echo ************************************
move C:\SourceCode\SAFE\CurrentTestPlan\%parameterPlan% C:\SourceCode\SAFE\TestPlans


REM Rename testngDefault.xml back to testng.xml
echo ************************************
echo *                                  *
echo *	   Reseting Default testng      *
echo *                                  *
echo ************************************
cd C:\SourceCode\SAFE\CurrentTestPlan
rename testngdefault.xml testng.xml
cd C:\SourceCode\SAFE


REM We are done here
goto END


:UserSpecified
REM Get Test Plan to run.
echo Available Test Plans
echo *********************************
dir C:\SourceCode\SAFE\TestPlans /B
echo *********************************
set /p testPlanToRun="Which Test Plan would you like to run? "


REM Get Test Plan Name
set planName=%testPlanToRun:~0,-4%

REM Rename testng.xml to testngdefault.xml
echo ************************************
echo *                                  *
echo *      Renaming default testng     *
echo *                                  *
echo ************************************
cd C:\SourceCode\SAFE\CurrentTestPlan
rename testng.xml testngDefault.xml


REM Move Test Plan to run to CurrentTestPlan
echo ************************************
echo *                                  *
echo *	    Moving %parameterPlan%      *
echo *                                  *
echo ************************************
cd C:\SourceCode\SAFE\TestPlans
rename %testPlanToRun% testng.xml
move testng.xml C:\SourceCode\SAFE\CurrentTestPlan


REM Run Selenium
echo ************************************
echo *                                  *
echo *	   Running %parameterPlan%      *
echo *                                  *
echo ************************************
cd C:\SourceCode\SAFE\Scripts\forWindows\BatchScripts
call SAFE.bat


REM Build Allure-Reports site
echo ************************************
echo *                                  *
echo *	   Generating Report Site       *
echo *                                  *
echo ************************************
cd C:\SourceCode\SAFE
call mvn site


REM Reset testPlanToRun's name
echo ************************************
echo *                                  *
echo * Resetting %parameterPlan%'s Name *
echo *                                  *
echo ************************************
cd C:\SourceCode\SAFE\CurrentTestPlan
rename testng.xml %testPlanToRun%


REM Make Directory for log files
echo ************************************
echo *                                  *
echo *	 Creating Directory for Logs    *
echo *                                  *
echo ************************************
for /f "tokens=2 delims==" %%a in ('wmic OS Get localdatetime /value') do set "dt=%%a"
set "YY=%dt:~2,2%" & set "YYYY=%dt:~0,4%" & set "MM=%dt:~4,2%" & set "DD=%dt:~6,2%"
set "HH=%dt:~8,2%" & set "Min=%dt:~10,2%" & set "Sec=%dt:~12,2%"
set "fullstamp=%MM%-%DD%-%YYYY%_%HH%-%Min%-%Sec%"
cd C:\SourceCode\SAFE\logs\ArchivedLogs
mkdir %planName%Reports[%fullstamp%]


REM Move Logs to logs\ArchivedLogs
echo ************************************
echo *                                  *
echo *	      Moving Log files          *
echo *                                  *
echo ************************************
copy C:\SourceCode\SAFE\test-log\logfile.log C:\SourceCode\SAFE\logs\ArchivedLogs\%planName%Reports[%fullstamp%]
copy C:\SourceCode\SAFE\CurrentTestPlan\%testPlanToRun% C:\SourceCode\SAFE\logs\ArchivedLogs\%planName%Reports[%fullstamp%]
move C:\SourceCode\SAFE\target\allure-reports C:\SourceCode\SAFE\logs\ArchivedLogs\%planName%Reports[%fullstamp%]


REM Move Test Plan to run back to TestPlans
echo ************************************
echo *                                  *
echo *	     Moving %parameterPlan%     *
echo *                                  *
echo ************************************
move C:\SourceCode\SAFE\CurrentTestPlan\%testPlanToRun% C:\SourceCode\SAFE\TestPlans


REM Rename testngDefault.xml back to testng.xml
echo ************************************
echo *                                  *
echo *      Renaming default testng     *
echo *                                  *
echo ************************************
cd C:\SourceCode\SAFE\CurrentTestPlan
rename testngdefault.xml testng.xml
cd C:\SourceCode\SAFE


REM We are done here
goto END

:END
REM Notify the user that we are done here
echo *********************************************
echo *                                           *
echo *                 FINISHED!                 *
echo *                                           *
echo *********************************************
