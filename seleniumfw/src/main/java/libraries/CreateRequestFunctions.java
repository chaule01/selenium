package libraries;

import static supports.TravelAgencySupportFunctions.*;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


import objects.CreateRequestPage;


public class CreateRequestFunctions extends CreateRequestPage{

	public CreateRequestFunctions(WebDriver driver) {
		super(driver);
	}
	
	public void openHomePage() {
		visit("https://ch.bbv-demo.ch/wbb");
		maximizeBrowser();

	}
	
	public void fakeAuthenTo(String username) {
		if (! (getText(usernameFld).trim().equalsIgnoreCase(username.trim())) ) {
			click(usernameFld);
			setText(usernameSearchFld, username);
			sendKey(usernameSearchFld, Keys.ENTER);
			refreshCurrentPage();
			waitForElementInvisible("xpath","//div[@class='blockUI blockOverlay']");
		}
	}
	
	public void fillPlanTrip(String mainTransport, String startDate,String endDate, String fromPlace, String toPlace) {
		if(mainTransport.toLowerCase().contains("any")) {
			click(anyTransportRad);
		}
		else if(mainTransport.toLowerCase().contains("plane")) {
			click(planeRad);
		}
		else if(mainTransport.toLowerCase().contains("train")) {
			click(trainRad);
		}

		setText(startDateFld, startDate);
		setText(endDateFld, endDate);
//		selectSearchFld(fromPlaceFld, fromPlaceSearchFld, ,fromPlace);
//		selectSearchFld(toPlaceFld, toPlaceSearchFld, toPlace);		
		click(plantripContinueBtn);
	}
	
	public void fillTripDetails() {
		click(tripDetailNextButton);
	}
	
	public void fillTravelPreferencePopup() {
		click(travelPrefereneSaveBtn);
	}
	public void fillOtherServices() {
		click(ortherServiceFinishBtn);
	}
}
