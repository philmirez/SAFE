package test.ui;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import test.BaseTestCase;
import automation.utilities.GoTo;
import automation.utilities.Log;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

/**
 * 
 * Test goes to the specified home page
 * 
 * @author Phil Ramirez
 *
 */
// Test Case Title for Allure Report
@Features("RH LogIn")
public class GoToHomePage extends BaseTestCase
{
	/**
	 * Logs the title of the test case for the Allure Report.
	 */
	@Test(priority=1)
	public static void Test_Case_Title()
	{
		// Test Case Title for Log
		Log.Info("Accessing the home page.");
	}
	
	/**
	 * Accesses the home page.
	 * 
	 * @param baseAddress				
	 * @throws InterruptedException
	 */
	@Stories("Accessing the home page.")
	@Test(priority=2)
	@Parameters("baseAddress")
	public void GoTo_HomePage(String baseAddress) throws InterruptedException
	{
		GoTo.HomePage(baseAddress);
	}
}