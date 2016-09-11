package page.objects;

import automation.utilities.Driver;
import automation.utilities.Log;

/**
 * Navigates to the Home page
 * 
 * 
 * 
 *
 */
public class HomePage 
{
	/**
	 * 
	 * 
	 * @param baseAddress		
	 * @throws InterruptedException
	 */
	public static void GoTo(String baseAddress) throws InterruptedException
	{
		Driver.Instance.get(baseAddress);
		Log.Info("Home Page is shown.");
	}
	
}
