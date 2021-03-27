package modules;

import static supports.CommonFunctions.getDriver;
import static supports.CommonFunctions.setBrowser;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import libraries.Bound;
import libraries.CreateRequestFunctions;
import supports.ExcelUtil;


public class CreateRequestTest {
	
	
	@BeforeMethod
	public static void setup() {
		setBrowser("chrome");
	}
	
	@Test
	public static void testcase01() {
		CreateRequestFunctions page = new CreateRequestFunctions(getDriver());
		page.openHomePage();
		
		
		
		
		
		
		
//		page.fakeAuthenTo("Nguyen Manh Dong");
//		page.fillPlanTrip("any","30/09/2017", "01/10/2017", "Ho Chi Minh", "Ha Noi");
//		page.fillTripDetails();
//		page.fillTravelPreferencePopup();
//		page.fillOtherServices();
	}
	
	public static void main(String[] args) throws IOException {
//		Bound<Integer> OneToEight = new Bound.Builder<Integer>(i-> i + 1, 1).withTo(8).build();
//		Workbook wb = ExcelUtil.readWorkbook("C:\\Users\\chaule\\Desktop\\Selenium.xlsx");
//		List<Object> result = ExcelUtil.getDataFromColumnHandler(wb, "Sheet1", 2, OneToEight);
//		result.forEach(System.out::println);
//	 System.out.println("Hello world");
//	 System.out.print("Hello world");
	 
	}
}
