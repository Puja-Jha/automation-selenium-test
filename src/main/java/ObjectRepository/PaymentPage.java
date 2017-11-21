package ObjectRepository;

import org.openqa.selenium.By;


public class PaymentPage {

	public static final By fName = By.xpath("//*[@id='ccFields']/fieldset[1]/div[1]/div[1]/input");

	public static final By LName = By.xpath("//*[@id='ccFields']/fieldset[1]/div[1]/div[2]/input");

	public static final By address = By.xpath("//*[@id='ccFields']/fieldset[1]/div[2]/div/input");

	public static final By zip = By.xpath("//*[@id='ccFields']/fieldset[1]/div[3]/div/input");

	public static final By country = By.xpath("//*[@id='ccFields']/fieldset[1]/div[4]/div[1]/select");

	public static final By city = By.xpath("//*[@id='ccFields']/fieldset[1]/div[4]/div[2]/input");

	public static final By ccType = By.xpath("//*[@id='ccFields']/fieldset[2]/div[1]/div[1]/select");

	public static final By ccNum = By.xpath("//*[@id='ccFields']/fieldset[2]/div[2]/div/input");

	public static final By ccName = By.xpath("//*[@id='ccFields']/fieldset[2]/div[3]/div/input");

	public static final By expMonth = By.xpath("//*[@id='ccFields']/fieldset[2]/div[4]/div[1]/select");

	public static final By expYear = By.xpath("//*[@id='ccFields']/fieldset[2]/div[4]/div[2]/select");

	public static final By cvv = By.xpath("//*[@id='ccFields']/fieldset[2]/div[5]/div/input");

	public static final By termsconditions = By.xpath("//*[@id='creditCardDetailsForm']/div[1]/div/div[2]/label/input");

	public static final By confirmPayment = By.xpath("//*[@id='completedCreditCardDetails']");

	public static final By confirmationStatus = By.xpath("//*[@id='mainContainer']/div[1]/div/div[1]/div[1]/h5[2]");

}
