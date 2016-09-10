/*
 * 
 * 
 * 
 * Levels used for identifying the severity of an event. Levels are organized from most specific to least:
 * OFF (most specific, no logging)
 * FATAL (most specific, little data)
 * ERROR
 * WARN
 * INFO
 * DEBUG
 * TRACE (least specific, a lot of data)
 * ALL (least specific, all data)
 * 
 * For more information regarding Log4j2 levels: https://logging.apache.org/log4j/2.x/log4j-api/apidocs/org/apache/logging/log4j/Level.html
 */

package automation.utilities;


import org.apache.logging.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.apache.logging.log4j.LogManager;

/**
 * Logs messages with different severities or formats.
 * 
 * @author Phil Ramirez
 *
 */
public class Log 
{
	private static Logger Logit = LogManager.getLogger(Log.class.getName());
	 
	/**
	 * Logs the Test Case Title.
	 *  
	 * @param TestCaseTitle	Name of the Test Case that is being run.
	 */
	public static void StartTestCase(String TestCaseTitle)
	{
		BasicConfigurator.configure();
		Logit.info("+---------------------------------------------------------------------------------------+");
	 
		Logit.info("|                                                                                       |");
	 
		Logit.info(" Title: " + TestCaseTitle);
	 
		Logit.info("|                                                                                       |");
	 
		Logit.info("+---------------------------------------------------------------------------------------+");
	 }
	 
	/**
	 * Logs a message to signify the end of the testing of the Test Case.
	 */
	 public static void EndTestCase()
	 {
	 
		Logit.info("+---------------------------------------------------------------------------------------+");
	 
		Logit.info("|                                                                                       |");
	 
		Logit.info("  Automated Framework");
	 
		Logit.info("|                                                                                       |");
	 
		Logit.info("+---------------------------------------------------------------------------------------+");
	 
	 }
	 
	 /**
	  * Logs a Fatal Error.
	  * 
	  * @param message A message of where the Fatal Error occurred and the exception.
	  */
	 public static void Fatal(String message) 
	 {
		 Logit.fatal(message);
	 }
	 
	 /**
	  * Logs a Error.
	  * 
	  * @param message A message of where the Error occurred and the exception.
	  */
	 public static void Error(String message) 
	 {
		 Screenshot.Capture(message);
		 Logit.error(message);
	 }
	 
	 /**
	  * Logs a Warning.
	  * 
	  * @param message A message of where the Warning occurred and the exception.
	  */
	 public static void Warn(String message) 
	 {
		 Logit.warn(message);
	 }
	 
	 /**
	  * Logs Information.
	  * 
	  * @param message The information that is to be logged.
	  */
	 public static void Info(String message) 
	 {
		 Logit.info(message);
	 }
	 
	 /**
	  * Logs a Debug message.
	  * 
	  * @param message Debug message.
	  */
	 public static void Debug(String message) 
	 {
		 Logit.debug(message);
	 } 
	 
	 /**
	  * Logs a Trace.
	  * 
	  * @param message Trace message.
	  */
	 public static void Trace(String message)
	 {
		 Logit.trace(message);
	 }
	 
}
