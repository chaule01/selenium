package supports;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TravelAgencySupportFunctions extends CommonFunctions {
	//use this method to  search and select first field in TravelAgency website
	public static void selectSearchFld(WebElement ele1, WebElement ele2, WebElement searchResult,String searchText) {
		click(ele1);
		setText(ele2, searchText);
		waitForElementInvisible(searchResult);
		sendKey(ele2, Keys.ENTER);
	}

}
