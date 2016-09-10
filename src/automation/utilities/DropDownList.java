package automation.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//DropDownList.ChooseOption("dataType").Select("VARCHAR");
//WELLLLLLLLL it works for certain frames buttttt
//Maybe we can make a Map of Enumerations for the drop down 
//BUTTTTTT maybe I should look into dynamically generating enumerations for drop down list

/**
 * Selects options from Drop Down menus
 * 
 * @author Phil Ramirez
 *
 */
public class DropDownList {
		public static Option temp;
		String selectAttributeName;
		/**
		 * Constructor for <code>DropDownList</code> select an option from a drop down list
		 * 
		 * @param selectName Specified Text field to select
		 */
		public DropDownList(String selectName){
			this.selectAttributeName = selectName;
		}
		/**
		 * <code>ChooseOption</code> selects an specified option.
		 * 
		 * @param option	Specified option to select.
		 * @return
		 */
		public static Option ChooseOption(String option){
			temp = new Option(option);
			return temp;
		}
		/**
		 * <code>Option</code> selects a specified option for a selected Attribute.
		 *
		 * @author Javier Argandona
		 */
		public static class Option{
			String optionSelected;
			/**
			 * Constructor for <code>Option</code> specifying a Option to select.
			 * 
			 * @param optionSelected Specified option to select.
			 */
			public Option(String optionSelected){
				this.optionSelected = optionSelected;
			}
			
			/**
			 * Selects the chosen option for the selected attribute.
			 * 
			 * @param chosenDropDownOption 		Specified value of selected option.
			 * @throws InterruptedException	
			 */
			public void Select(String chosenDropDownOption) throws InterruptedException{
				WebElement select = Driver.Instance.findElement(By.name(optionSelected));
				List<WebElement> options = select.findElements(By.tagName("option"));
				for(WebElement x: options){
					if(x.getText().equals(chosenDropDownOption))
						x.click();
				}
					Driver.Wait(1);
			}
		}
	}