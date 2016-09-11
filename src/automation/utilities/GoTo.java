package automation.utilities;

import automation.utilities.Driver;
import automation.utilities.Log;

/**
 * Navigates to the Home page
 * 
 * 
 * 
 *
 */
public class GoTo
{
	/**
	 * Navigates to the home page
	 * 
	 * @param baseAddress			
	 * @throws InterruptedException
	 */
	public static void HomePage(String baseAddress) throws InterruptedException
	{
		Driver.Instance.get(baseAddress);
		Log.Info("Home Page is shown.");
	}
	
}
