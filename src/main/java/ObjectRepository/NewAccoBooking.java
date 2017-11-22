package ObjectRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NewAccoBooking {

    public static final By destCity = By.id("destination");
    public static final By AccomUnit = By.id("Hotel");
    public static final By transferName = By.xpath("//*[@id='Transfer']");
    public static final By transferDate = By.name("transferDate");
    public static final By transferTime = By.xpath("//*[@id='searchForm']/div/div[2]/div[3]/div/div/div[2]/select");
    public static final By transferBookingChild=By.name("nbrChildren");
    public static final By transferBookingChildAge=By.name("childrenAges[1]");
    public static final By transferGetTransfers=By.xpath("//*[@id='searchResults']/div[3]/div[3]/button");
    public static final By transferType=By.name("transferType");
    public static final By pickUpFrom=By.name("pickUp");
    public static final By dropOffTo=By.name("dropOff");
    public static final By transferRadioSelection = By.xpath("//input[@data-capacity='3']");
    public static final By transferRadioScheduled = By.xpath("//input[@data-capacity='0']");
    public static final By transferFChildren=By.xpath("//*[@id='details_0']/div[2]/div[1]/div[2]/div/select");
    public static final By transferFrstPaxTitle=By.name("title[0]");
    public static final By transferFrstPaxFname=By.name("firstName[0]");
    public static final By transferFrstPaxLname=By.name("lastName[0]");
    public static final By transferPickUp=By.name("pickUpLocation");
    public static final By transferAirlineDetails=By.name("airline");
    public static final By transferArrivingFrom=By.id("arrivingFrom");
    public static final By transferFlightNo=By.xpath("//input[@name='flightNbr']");
    public static final By transferArrival=By.name("arrivalTimeHour");
    public static final By transferArrivalHour=By.name("arrivalTimeHour");
    public static final By transferArrivalMins=By.name("arrivalTimeMinute");
    public static final By transDropOff=By.name("dropOffLocation");
    public static final By transCntinueBook=By.xpath("//button[@id='continueToBook']");
    public static final By transProceedBook=By.xpath("//*[contains(text(), 'Proceed to booking')]");
    public static final By inDate = By.xpath("//*[@id='fromDate']");
    public static final By outDate = By.xpath("//*[@id='toDate']");
    public static final By searchButton = By.xpath("//*[@id='searchForm']/div/div[3]/button");
    public static final By resultHotel = By.xpath("//*[@id='searchResults']/div[3]/h4");
    public static final By roomtypes =By.xpath("//*[contains(text(), 'See Room Types')]");
    public static final By child = By.id("children_0");
    public static final By childage =By.xpath("//*[@id='addRoomsHere']/tr[2]/td[3]/select[1]");
    public static final By roomselection = By.xpath("//*[@id='roomtype_84722_0_0_0']");
    public static final By allcheckbox = By.xpath("//*[@id='roomtype_84722_0_0_0']");
    public static final By procedetoBook = By.xpath("//*[@id='roomList_84722']/div[4]/div[3]/button");
    public static final By paxtitle = By.xpath("//*[@id='passengerDetails']/div[1]/div/div[1]/select");
    public static final By paxFname = By.xpath("//*[@id='passengerDetails']/div[1]/div/div[2]/input");
    public static final By acceptChkBX = By.xpath("//*[@id='acceptRateNotes_0']");
    public static final By bookBtn = By.xpath("//*[@id='continueToBook']");
    public static final By confirmBook = By.xpath("//*[@id='table_bookItinerary']/form/div[2]/div[2]/a");
    public static final By prodctType = By.xpath("//*[@id='productType']");
    public static final By dOTWRef = By.xpath("//*[@id='referenceNumber']");
    public static final By TRNNum = By.xpath("//*[@id='mainContainer']/div[1]/div/div[1]/div[1]/h3");
    public static final By CROsearch = By.xpath("//*[@id='croSearchForm']/div/div[3]/button");
    public static final By finalTRN = By.xpath("//*[@id='resultsBody']/tbody/tr[2]/td[2]/strong");

}
