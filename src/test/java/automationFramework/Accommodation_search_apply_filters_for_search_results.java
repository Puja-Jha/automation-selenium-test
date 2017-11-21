package automationFramework;

import Utility.Configuration;
import lib.DriverAndObjectDetails;
import lib.ExcelDataConfig;
import lib.ExtentManager;
//import lib.LoggingToFile;
import lib.Takescreenshot;
import lib.DriverAndObjectDetails.DriverName;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.NewAccoBooking;
import ObjectRepository.Operations;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class Accommodation_search_apply_filters_for_search_results {
	Configuration Config = new Configuration();
	Takescreenshot obj = new Takescreenshot();
	LoginPage login = new LoginPage();
	HomePage home = new HomePage();
	NewAccoBooking acco = new NewAccoBooking();
	Operations opo = new Operations();
	WebDriver driverqa;
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test;
	Logger logger = Logger.getLogger("Accommodation_search_apply_filters_for_search_results");

	@Test
	@Parameters({ "browsername" })
	public void login(String browsername) throws Exception {
		PropertyConfigurator.configure("Log4j.properties");
		

		try {
			if (browsername.equalsIgnoreCase("CH")) {

				driverqa = new DriverAndObjectDetails(DriverName.CH).CreateDriver();
			} else if (browsername.equalsIgnoreCase("IE")) {
				driverqa = new DriverAndObjectDetails(DriverName.IE).CreateDriver();
			} else {
				driverqa = new DriverAndObjectDetails(DriverName.FF).CreateDriver();
			}
			logger.info("Browser Opened");
			driverqa.get(Config.getApplicationUrl());
			logger.info("Test Case Started");
			ExcelDataConfig excel = new ExcelDataConfig(Config.getExcelPath());
			test = rep.startTest("LoginTest");
			test.log(LogStatus.INFO, "Starting LoginTest");
			WebElement username = driverqa.findElement(LoginPage.uname);
			username.clear();
			username.sendKeys(excel.getData(0, 1, 0));
			WebElement password = driverqa.findElement(LoginPage.pwd);
			password.clear();
			password.sendKeys(excel.getData(0, 1, 1));
			driverqa.findElement(LoginPage.submit).click();
			Thread.sleep(1000);
			String expectedtitle = "DOTWconnect.com::DOTWconnect.com: My Admin";
			String atualtitle = driverqa.getTitle();
			Assert.assertEquals(atualtitle, expectedtitle);
			test.log(LogStatus.INFO, "Ending LoginTest");
			test.log(LogStatus.PASS, "PASSED LoginTest");
			logger.info("Login Successful");
		} catch (Exception e) {
			logger.info(e.getMessage());
			test.log(LogStatus.FAIL, e.getMessage());
			rep.endTest(test);
			rep.flush();
		}
	}

	@Test(dependsOnMethods = { "login" })
	public void searchaccomodation() throws Exception {
		Actions action;
		action = new Actions(driverqa);
		WebDriverWait wait;
		ExcelDataConfig excel;
		wait = new WebDriverWait(driverqa, 30);
		excel = new ExcelDataConfig(Config.getExcelPath());
		test = rep.startTest("searchaccomodation");
		try {

			test.log(LogStatus.INFO, "Navigating to customer search page");
			logger.info("Navigating to customer search page");
			driverqa.findElement(HomePage.operation).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Operations.newBooking));
			driverqa.findElement(Operations.newBooking).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Operations.AccomBook));
			driverqa.findElement(Operations.AccomBook).click();
			Thread.sleep(2000);
			String searchcustatualtitle = driverqa.getTitle();
			String searchcustexpectedtitle = "DOTWconnect.com::New Accommodation Booking";
			Assert.assertEquals(searchcustatualtitle, searchcustexpectedtitle);
			logger.info("Navigated to customer search page");
			test.log(LogStatus.PASS, "Customer Search Page");
		} catch (Exception e) {
			logger.info(e.getMessage());
			test.log(LogStatus.FAIL, e.getMessage());
			rep.endTest(test);
			rep.flush();
		}
		
		logger.info("Searching Customer");

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Operations.city));
			driverqa.findElement(Operations.city).sendKeys(excel.getData(0, 4, 0));
			Thread.sleep(1000);
			action.sendKeys(Keys.ARROW_DOWN).build().perform();
			action.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(2000);
			obj.Takesnap(driverqa, Config.SnapShotPath() + "/Accommodation_search_apply_filters_for_search_results/Customer-filter-search-hotel.jpg");
			//Clicking on Filter Customers Button
			action.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(2000);
			obj.Takesnap(driverqa, Config.SnapShotPath() + "/Accommodation_search_apply_filters_for_search_results/Customer-list-search-hotel.jpg");
			wait.until(ExpectedConditions.visibilityOfElementLocated(Operations.chooseCust));
			logger.info("Selecting Customer");
			driverqa.findElement(Operations.chooseCust).click();
			Thread.sleep(1000);
			String searchpageactualtitle = driverqa.getTitle();
			String searchpageexpectedtitle = "DOTWconnect.com::";
			Assert.assertEquals(searchpageactualtitle, searchpageexpectedtitle);
			logger.info("Customer Selected");
			test.log(LogStatus.PASS, "Customer Selected");

		} catch (Exception e) {
			logger.info(e.getMessage());
			test.log(LogStatus.FAIL, e.getMessage());
			rep.endTest(test);
			rep.flush();
		}

		logger.info("Applying search Filters");

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccoBooking.destCity));
			driverqa.findElement(NewAccoBooking.destCity).sendKeys(excel.getData(0, 7, 0));
			Thread.sleep(2000);
			action.sendKeys(Keys.ARROW_DOWN).build().perform();
			action.sendKeys(Keys.ENTER).build().perform();
			driverqa.findElement(NewAccoBooking.AccomUnit).sendKeys(excel.getData(0, 10, 0));
			Thread.sleep(2000);
			action.sendKeys(Keys.ARROW_DOWN).build().perform();
			action.sendKeys(Keys.ENTER).build().perform();
			driverqa.findElement(NewAccoBooking.inDate).clear();
			driverqa.findElement(NewAccoBooking.inDate).sendKeys(excel.getData(0, 13, 0));
			driverqa.findElement(NewAccoBooking.outDate).clear();
			driverqa.findElement(NewAccoBooking.outDate).sendKeys(excel.getData(0, 13, 1));
			Thread.sleep(2000);
			obj.Takesnap(driverqa,Config.SnapShotPath() + "/Accommodation_search_apply_filters_for_search_results/Filter_Hotel.jpg");
			driverqa.findElement(NewAccoBooking.searchButton).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccoBooking.resultHotel));
			String result = driverqa.findElement(NewAccoBooking.resultHotel).getText();
			String expected = excel.getData(0, 10, 0);
			Thread.sleep(2000);
			obj.Takesnap(driverqa,Config.SnapShotPath() + "/Tour_search_apply_filters_for_search_results/search-hotel.jpg");
			Thread.sleep(1000);
			driverqa.findElement(NewAccoBooking.roomtypes).click();
			Thread.sleep(5000);
			obj.Takesnap(driverqa, Config.SnapShotPath() + "/Tour_search_apply_filters_for_search_results/final-search-hotel.jpg");
			Assert.assertTrue(result.contains(expected));
			test.log(LogStatus.INFO, "Ending HotelSearch");
			test.log(LogStatus.PASS, "PASSED HotelSearch");
			logger.info("Hotel Search Complete");
		} catch (Exception e) {
			logger.info(e.getMessage());
			test.log(LogStatus.FAIL, e.getMessage());
			rep.endTest(test);
			rep.flush();
		}
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getThrowable());
		}
		rep.endTest(test);
	}

	@AfterTest
	public void afterTest() {

		rep.endTest(test);
		rep.flush();
		driverqa.close();
	}
}
