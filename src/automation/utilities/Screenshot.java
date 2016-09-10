package automation.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;

/**
 * In the event of a Fatal error, a screenshot is taken and logged.
 * 
 * @author Phil Ramirez
 *
 */
public class Screenshot 
{
	String titleOfScreenshot;
	
	/**
	 * Captures a screenshot and saves it with a message.
	 * 
	 * @param message	Message to be saved with the screenshot.
	 */
	public static void Capture(String message)
	{
		// Strip illegal characters from the string.
		String messageStripped = message.replaceAll("[\\-\\+\\<>|\"?^*\\\\/:,]","");
		
		// Remove all characters to the right of the left parenthesis including the left parenthesis.
		String titleOfScreenshot = messageStripped.substring(0, messageStripped.indexOf('('));
		
		try 
		{
			saveScreenshot(titleOfScreenshot);
		} 
		catch (Exception e1) 
		{
			Log.Fatal("[EXCEPTION CAUGHT] : Screenshot.Capture() | Exception: " + e1);
		}
	}// Capture method
	
	/**
	 * Logs the title of the screenshot and returns a screenshot with a specified title.
	 * 
	 * @param titleOfScreenshot	Title of the Screenshot
	 * @return					
	 */
	// {0} corresponds to the first argument, {1} to the second, etc...
	@Attachment(value = "{0} screenshot", type = "image/png")
	public static byte[] saveScreenshot(String titleOfScreenshot) 
	{
		Log.Info("Title of screenshot: " + titleOfScreenshot);
		
	    return ((TakesScreenshot)Driver.Instance).getScreenshotAs(OutputType.BYTES);
	}
	
}// Screenshot class
