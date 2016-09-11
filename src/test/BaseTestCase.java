package test;

import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import automation.utilities.Driver;
import automation.utilities.Log;

/**
 * 
 * @author Phil Ramirez
 *
 */
public class BaseTestCase 
{
	/**
	 * Logs the current Test Case title and starts the driver for the web browser.
	 * 
	 * @param driverType	Specifies which web browser is to be used.
	 * @param testCaseTitle	The name of the Test Cases being tested.
	 */
	@BeforeTest
	@Parameters("driverType")
	public void Init(String driverType, ITestContext testCaseTitle)
	{
		Log.StartTestCase(testCaseTitle.getName());
		Driver.Initialize(driverType);
	}// Init method

	/**
	 * Logs the ending of the testing and closes the driver for the web browser.
	 */
	@AfterTest
	public void Cleanup()
	{
	
		Log.EndTestCase();
		Driver.Close();
	
	}// Cleanup method
	
}//BaseTestCase Class
