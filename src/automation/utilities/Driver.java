/*
 * 
 * 
 * 
 * */

package automation.utilities;


//import org.openqa.selenium.By;
import org.openqa.selenium.Alert;


import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.codeborne.selenide.WebDriverRunner;

/**
 * Creates a WebDriver, Manages wait times, and opens and closes the web browser.
 * 
 * 
 *
 */
public class Driver 
{
	
	public static WebDriver Instance;
	
	public static String BaseAddress(String baseAddress)
	{	
		return baseAddress;
	}
	
	/**
	 * <code>Initialize</code> opens a Internet browser window for the test cases to be run.
	 * The browser to be opened is specified by driverType.
	 * 
	 * @param driverType Specifies which Internet browser is to be opened.
	 */
	public static void Initialize(String driverType)
	{	
		if(driverType.equals("firefox"))
		{
			/*
			 * 
			 * Preferences of Firefox Driver
			 *
			 * Use the below setPreferences for manipulating files
			 * profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword, application/csv, application/ris, text/csv, image/png, application/pdf, text/html, text/plain, application/Zip, application/x-zip, application/x-zip-compressed, application/download, application/octet-stream");
			profile.setPreference("browser.download.manager.showWhenStarting", false);
			profile.setPreference("browser.download.manager.focusWhenStarting", false);  
			profile.setPreference("browser.download.useDownloadDir", true);
			profile.setPreference("browser.helperApps.alwaysAsk.force", false);
			profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
			profile.setPreference("browser.download.manager.closeWhenDone", true);
			profile.setPreference("browser.download.manager.showAlertOnComplete", false);
			profile.setPreference("browser.download.manager.useWindow", false);
			profile.setPreference("services.sync.prefs.sync.browser.download.manager.showWhenStarting", false);
			profile.setPreference("pdfjs.disabled", true);
			 * */
			FirefoxProfile profile = new FirefoxProfile();
			
		
			Instance = new FirefoxDriver(profile);
			WebDriverRunner.setWebDriver(Instance);

		}
		// TODO chromedriver.exe only executes on Windows! Need to extend for Mac
		else if(driverType.equals("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			System.setProperty("webdriver.chrome.driver", "..\\3rdParty\\chromedriver-win32-2.21\\chromedriver.exe");
			Instance = new ChromeDriver(options);
			WebDriverRunner.setWebDriver(Instance);
			
		}
		// TODO ie.exe only executes on Windows! Well, of course...
		else if(driverType.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", "..\\3rdParty\\IEDriverServer_win32_2.52.0\\IEDriverServer.exe");
			Instance = new InternetExplorerDriver();
			WebDriverRunner.setWebDriver(Instance);

		}
		// Maximize browser window
		Instance.manage().window().maximize();
					
		// Implicit wait 
		TurnOnWait();
		
	}// Initialize method
	
	/**
	 * <code>Close</code> terminates the instance created by <code>Initialize</code>.
	 */
	public static void Close()
	{
		
		Instance.quit();
		
	}// Close method
	
	/**
	 * <code>Wait</code> puts the current Thread to sleep for a specified amount of seconds.
	 * 
	 * @param time					The amount of seconds that the Thread is to sleep for.
	 * @throws InterruptedException
	 */
	public static void Wait(long time)
	{
		Log.Info("*****************************************");
		Log.Info("|                                       |");
		Log.Info("| Driver is waiting for:   " + time + "            |");
		Log.Info("|                                       |");
		Log.Info("*****************************************");
		
		try{
			// OBJECT 1 from Joda to JDK
		    DateTime dt = new DateTime();
		    GregorianCalendar jdkGCal = dt.toGregorianCalendar();
	
		    // OBJECT 1 from JDK to Joda
		    dt = new DateTime(jdkGCal);
		    int hour = dt.getHourOfDay();
		    int min = dt.getMinuteOfHour();
		    int sec = dt.getSecondOfMinute();
		    
		    System.out.println("Time: " + hour + ":" + min + ":" + sec);
		    
		    // time * 1000 = seconds
			Thread.sleep(time * 1000);
			
			// OBJECT 2 from Joda to JDK
			DateTime dt2 = new DateTime();
			GregorianCalendar jdkGCal2 = dt2.toGregorianCalendar();
			
			// OBJECT 2 output to console
			dt2 = new DateTime(jdkGCal2);
			int hour2 = dt2.getHourOfDay();
		    int min2 = dt2.getMinuteOfHour();
		    int sec2 = dt2.getSecondOfMinute();
			
			System.out.println("Time: " + hour2 + ":" + min2 + ":" + sec2);
		}catch(InterruptedException e){
			Log.Error("Driver.Wait() has failed!");
			e.printStackTrace();
		}
	}// Wait method
	
	@FunctionalInterface
	public interface Action {
		void apply();
	
	}
	
	/**
	 * <code>NoWait</code> turns off the timeout until the action completes.
	 * Used mainly for when a page is loading.
	 * 
	 * @param action	Action that needs to have the timeout turned off.
	 */
	public static void NoWait(Action action)
	{
		TurnOffWait();
		action.apply();
		TurnOnWait();
	}
	
	/**
	 * Sets the Instance's timeout to 0 seconds.
	 */
	private static void TurnOffWait()
	{
		Instance.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}
	
	/**
	 * Sets the Instance's timeout to 55 seconds.
	 */
	private static void TurnOnWait()
	{
		Instance.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);
	}
	
}// Driver class
