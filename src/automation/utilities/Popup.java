

package automation.utilities;

import org.openqa.selenium.Alert;

/**
 * Accepts Alert popups from the browser.
 * 
 * @author Phil Ramirez
 *
 */
public class Popup 
{

	/**
	 * Switches to a pop alert created by the browser and accepts it.
	 * 
	 * @throws InterruptedException
	 */
	 public static void AcceptAlert() throws InterruptedException 
	 {	 
		  try
		  {
			  Driver.Wait(4);
			  
			  Alert alert = Driver.Instance.switchTo().alert();
			  alert.accept();
			  
			  Driver.Wait(3);
		  }
		  catch(Exception e)
		  {
			  Log.Error("[EXCEPTION CAUGHT] : Popup.AcceptAlert() | alert.accept() | Exception: " + e);
			  
			  // Terminate test 
			  throw(e);
		  }
	  }	
	
}
