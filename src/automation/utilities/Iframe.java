package automation.utilities;

import org.openqa.selenium.By;


/**
 * Switches between the different Iframes that are created by Enable.
 * 
 *
 *
 */
public class Iframe 
{
	/**
	 * Iframe for the Dashboard.
	 * 
	 * 
	 *
	 */
	public static class Dashboard
	{
		/**
		 * Switches to the Dashboard Iframe.
		 */
		public static void SwitchTo()
		{
			try
			{
				Iframe.Default.SwitchTo();
				Driver.Instance.switchTo().frame(Driver.Instance.findElement(By.xpath("//*[@id='tabHome']/iframe")));
			}
			catch(Exception e)
			{
				Log.Error("[EXCEPTION CAUGHT] : Iframe.Dashboard.SwitchTo()");
				throw(e);
			}
		}
	}
	
	/**
	 * Iframe for the Record Listing.
	 * 
	 *  
	 *
	 */
	public static class RecordListing
	{
		/**
		 * Switches to the Record Listing Iframe.
		 */
		public static void SwitchTo()
		{
			//TODO: Figure out js to get hidden value of uuTabID
//			WebElement div = Driver.Instance.findElement(By.xpath(".//*[@id='main']/div/div[2]"));
//			String repoId = div.getAttribute("id");
//			
//			Log.Info("***********************");
//			Log.Info("|                     |");
//			Log.Info("|          "+repoId+"           |");
//			Log.Info("|                     |");
//			Log.Info("***********************");
			try
			{
				Iframe.Default.SwitchTo();
				
				// Ewapp8...
				// Driver.Instance.switchTo().frame(Driver.Instance.findElement(By.xpath("//*[@id='repo-10087']/iframe")));
				
				// Ewapp12 and Ewapp13
				Driver.Instance.switchTo().frame(Driver.Instance.findElement(By.xpath("//*[@id='repo-10010']/iframe")));
			}
			catch(Exception e)
			{
				Log.Error("[EXCEPTION CAUGHT] : Iframe.RecordListing.SwitchTo()");
				throw(e);
			}

		}
	}
	
	/**
	 * Iframe for the InlineEditor.
	 * 
	 *  
	 *
	 */
	public static class InlineEditor
	{
		/**
		 * Switches to the InlineEditor Iframe.
		 */
		public static void SwitchTo()
		{
			try
			{
				Iframe.RecordListing.SwitchTo();
				Driver.Instance.switchTo().frame(Driver.Instance.findElement(By.xpath("//*[@id='cellEditDiv']/iframe")));
			}
			catch(Exception e)
			{
				Log.Error("[EXCEPTION CAUGHT] : Iframe.InlineEditor.SwitchTo()");
				throw(e);
			}
		}
	}
	
	/**
	 * Default Iframe
	 * 
	 *  
	 *
	 */
	public static class Default
	{
		/**
		 * Switches to the Default Iframe.
		 */
		public static void SwitchTo()
		{
			try
			{
				Driver.Instance.switchTo().defaultContent();
			}
			catch(Exception e)
			{
				Log.Error("[EXCEPTION CAUGHT] : Iframe.Default.SwitchTo()");
				throw(e);
			}
		}
	}
	
	/**
	 * Active Iframe.
	 * 
	 *  
	 *
	 */
	public static class Active
	{
		/**
		 * Switches to the Active Iframe.
		 */
		public static void SwitchTo()
		{
			try
			{
				Driver.Instance.switchTo().activeElement();
			}
			catch(Exception e)
			{
				Log.Error("[EXCEPTION CAUGHT] : Iframe.Active.SwitchTo()");
				throw(e);
			}
		}
	}
	
	/**
	 * Iframe for the Editor.
	 * 
	 *  
	 *
	 */
	public static class Editor
	{
		/**
		 * Switches to the Editor Iframe.
		 */
		public static void SwitchTo()
		{
			try
			{
				Iframe.RecordListing.SwitchTo();
				Driver.Instance.switchTo().frame(Driver.Instance.findElement(By.xpath("//*[@id='modalIFrameDialog']/iframe")));
			}
			catch(Exception e)
			{
				Log.Error("[EXCEPTION CAUGHT] : Iframe.Editor.SwitchTo()");
				throw(e);
			}
		}
	}
	
	/**
	 * Iframe for the Editor.
	 * 
	 * @author Phillip Ramirez
	 *
	 */
	public static class UserSettingsEditor
	{
		/**
		 * Switches to the Editor Iframe.
		 */
		public static void SwitchTo()
		{
			try
			{
				Driver.Instance.switchTo().frame(Driver.Instance.findElement(By.xpath("//*[@id='mainPIM-modalIFrameDialog']/iframe")));
			}
			catch(Exception e)
			{
				Log.Error("[EXCEPTION CAUGHT] : Iframe.Editor.SwitchTo()");
				throw(e);
			}
		}
	}
	
	/**
	 * Iframe for Manage Profiles.
	 * 
	 *  
	 *
	 */
	public static class ManageProfiles
	{
		/**
		 * Switches to the Manage Profiles Iframe.
		 */
		public static void SwitchTo()
		{
			try
			{
				//Iframe.RecordListing.SwitchTo();
				Driver.Instance.switchTo().frame(Driver.Instance.findElement(By.xpath("//*[@id='tabProfiles']/iframe")));
				//Driver.Instance.switchTo().frame(Driver.Instance.findElement(By.xpath("//*[@id='repo-10010']/iframe")));
			}
			catch(Exception e)
			{
				Log.Error("[EXCEPTION CAUGHT] : Iframe.ManageProfiles.SwitchTo()");
				throw(e);
			}
		}
	}
	
	/**
	 * Iframe for the Manage Profiles Edit Frame.
	 * 
	 *  
	 *
	 */
	//Popup screen after selecting brand in Model - Profile and clicking edit
	public static class ManageProfilesEditFrame
	{
		/**
		 * Switches to the Manage Profiles Edit Iframe.
		 */
		public static void SwitchTo()
		{
			try
			{
				//ManageProfiles.SwitchTo();
				Driver.Instance.switchTo().frame(Driver.Instance.findElement(By.xpath(".//*[@id='profileEditor-modalIFrameDialog']/iframe")));
				//Driver.Instance.switchTo().frame(Driver.Instance.findElement(By.xpath("//*[@id='repo-10010']/iframe")));
			}
			catch(Exception e)
			{
				Log.Error("[EXCEPTION CAUGHT] : Iframe.ManageProfilesEditFrame.SwitchTo()");
				throw(e);
			}
		}
	}
	
	/**
	 * Iframe for Manage Profile Define Attributes.
	 * 
	 *  
	 *
	 */
	//Profile Define Attributes iframe , check if I even need this because this xpath is the same
	public static class ManageProfileDefineAttributes
	{
		/**
		 * Switches to the Manage Profile Define Attributes Iframe.
		 */
		public static void SwitchTo()
		{
			try
			{
				//ManageProfiles.SwitchTo();
				Driver.Instance.switchTo().frame(Driver.Instance.findElement(By.xpath(".//*[@id='profileEditor-modalIFrameDialog']/iframe")));
				//Driver.Instance.switchTo().frame(Driver.Instance.findElement(By.xpath("//*[@id='repo-10010']/iframe")));
			}
			catch(Exception e)
			{
				Log.Error("[EXCEPTION CAUGHT] : Iframe.ManageProfilesEditFrame.SwitchTo()");
				throw(e);
			}
		}
	}
	
	/**
	 * Iframe for Manage Profile Define Attribute Details.
	 * 
	 *  
	 *
	 */
	//Profile Define Attributes - Define Attribute Details iframe, not yet not in use and not sure where the frame is for this
	public static class ManageProfileDefineAttributesDetails
	{
		/**
		 * Switches to the Manage Profile Define Attribute Details Iframe.
		 */
		public static void SwitchTo()
		{
			try
			{
				//ManageProfiles.SwitchTo();
				Driver.Instance.switchTo().frame(Driver.Instance.findElement(By.xpath(".//*[@id='profileEditor-modalIFrameDialog']/iframe")));
				//Driver.Instance.switchTo().frame(Driver.Instance.findElement(By.xpath("//*[@id='repo-10010']/iframe")));
			}
			catch(Exception e)
			{
				Log.Error("[EXCEPTION CAUGHT] : Iframe.ManageProfilesEditFrame.SwitchTo()");
				throw(e);
			}
		}
	}
	
	/**
	 * Iframe for Define Attribute Detail.
	 * 
	 *  
	 *
	 */
	public static class DefineAttributeDetailTemp{
		/**
		 * Switches to the Define Attribute Detail Iframe.
		 */
		public static void SwitchTo()
		{
			try
			{
				Driver.Instance.switchTo().frame(Driver.Instance.findElement(By.xpath(".//*[@id='profileAttribute-modalIFrameDialog']/iframe")));
			}catch(Exception e){
				Log.Error("[EXCEPTION CAUGHT] : Iframe.DefineAttributeDetailTemp.SwitchTo()");
			}
		}
	}
	
	/**
	 * WIP.
	 * 
	 *  
	 *
	 */
	//TODO:have to rename this class just using to find what is the problem with not hitting the ok button NOT working as of yet
	public static class TryingToClickSave{
		public static void SwitchTo()
		{
			try
			{
				Driver.Instance.switchTo().frame(Driver.Instance.findElement(By.xpath(".//*[@id='profileAttribute-modalIFrameDialog']/iframe")));
			}catch(Exception e){
				Log.Error("[EXCEPTION CAUGHT] : Iframe.DefineAttributeDetailTemp.SwitchTo()");
			}
		}
	}
	
	/**
	 * Iframe for the Import and Export Templates.
	 * 
	 *  
	 *
	 */
	//Iframe for Import&Export Feature, Import Templates function
	public static class ImportTemplates{
		public static void SwitchTo()
		{
			try
			{
				Driver.Instance.switchTo().frame(Driver.Instance.findElement(By.xpath(".//*[@id='tabImport']/iframe")));
			}catch(Exception e){
				Log.Error("[EXCEPTION CAUGHT] : Iframe.ImportTemplates.SwitchTo()");
			}
		}
	}
	
	public static class ModalWindow{
		public static void SwitchTo(){
			try{
				Driver.Instance.switchTo().frame(Driver.Instance.findElement(By.xpath(".//*[@id='ew-modal-window']/iframe")));
			}catch(Exception e){
				Log.Error("[EXCEPTION CAUGHT] : Iframe.ModalWindow.SwitchTo()");

			}
		}
	}
	
	public static class JobMonitorWindow{
		public static void SwitchTo(){
			try{
				Driver.Instance.switchTo().frame(Driver.Instance.findElement(By.xpath(".//*[@id='tabJobMonitor']/iframe")));
			}catch(Exception e){
				Log.Error("[EXCEPTION CAUGHT] : Iframe.JobMonitorWindow.SwitchTo()");
			}
		}
	}
	
	//Iframe for Export Multi-Language function in System feature
	public static class ExportMultiLanguages{
		public static void SwitchTo(){
			try{
				Driver.Instance.switchTo().frame(Driver.Instance.findElement(By.xpath(".//*[@id='tabJobMonitor']/iframe")));
			}catch(Exception e){
				Log.Error("[EXCEPTION CAUGHT] : Iframe.JobMonitorWindow.SwitchTo()");
			}
		}
	}
	//Iframe for Export Multi-Language function in System feature
	public static class JobHistory{
		public static void SwitchTo(){
			try{
				Driver.Instance.switchTo().frame(Driver.Instance.findElement(By.xpath(".//*[@id='jobMonitorModalIFrameDialog']/iframe")));
			}catch(Exception e){
				Log.Error("[EXCEPTION CAUGHT] : Iframe.JobHistory.SwitchTo()");
			}
		}
	}
}
