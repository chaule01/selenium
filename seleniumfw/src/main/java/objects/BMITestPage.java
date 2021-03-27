package objects;

import org.testng.annotations.Test;

import libraries.CreateRequestFunctions;

import static supports.TravelAgencySupportFunctions.*;
public class BMITestPage {
	public static void main(String[] args) {
		setBrowser("chrome");
		CreateRequestFunctions page = new CreateRequestFunctions(getDriver());
		page.openHomePage();
		waitForElementInvisible(page.blockUIOverlay);
		click(page.anyTransportRad);
		
		
	}
		

		
}

