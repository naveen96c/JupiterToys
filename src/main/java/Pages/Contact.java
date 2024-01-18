package Pages;

//import java.util.NoSuchElementException;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import base.Testbase;
//import util.TestUtil;

public class Contact extends Testbase {

	public static String FORE_NAME = "//input[@id='forename']";
	public static String EMAIL = "//input[@id='email']";
	public static String MESSAGE = "//textarea[@id='message']";
	public static String FORE_NAME_ERR = "//span[@id='forename-err']";
	public static String EMAIL_ERR = "//span[@id='email-err']";
	public static String MESSAGE_ERR = "//span[@id='message-err']";
	public static String SUCCESS_MSG = "//body/div[2]/div[1]/div[1]";

	/*To enter forename,message and email details*/
	
	public void enterMandatoryDetails() throws InterruptedException {

		WebElement forename = driver.findElement(By.xpath(FORE_NAME));
		forename.sendKeys("Steve");
		WebElement email = driver.findElement(By.xpath(EMAIL));
		email.sendKeys("steve@abc.com");
		WebElement message = driver.findElement(By.xpath(MESSAGE));
		message.sendKeys("Hello Jupiter Toys");
	}

	/*validates forename error message "Forename is required" is not displayed*/
	
	public void checkForenameError() throws InterruptedException {
		boolean forenameError = driver.findElements(By.xpath(FORE_NAME_ERR)).size() < 1;
		if (forenameError == true) {
			System.out.println("Forename Error message is not displayed");
		} else {
			System.out.println("FORENAME Error message is still displaying");

		}
	}
	
	/*validates email error message "Email is required" is not displayed*/
	
	public void checkEmailError() throws InterruptedException {
		boolean forenameError = driver.findElements(By.xpath(EMAIL_ERR)).size() < 1;
		if (forenameError == true) {
			System.out.println("Email Error message is not displayed");
		} else {
			System.out.println("EMAIL Error message is still displaying");

		}
	}

	/*validates message error  "Message is required" is not displayed*/

	public void checkMessageError() throws InterruptedException {
		boolean forenameError = driver.findElements(By.xpath(MESSAGE_ERR)).size() < 1;
		if (forenameError == true) {
			System.out.println("MESSAGE Error is not displayed");
		} else {
			System.out.println("MESSAGE ERROR is still displaying");

		}
	}
	
	/*Verifies error is displayed for forname*/

	public void verifyForenameErrorMessage() throws InterruptedException {
		String nameErr = "Forename is required";
		WebElement forenameError = driver.findElement(By.xpath(FORE_NAME_ERR));
		String actNameError = forenameError.getText();

		if (forenameError.isDisplayed()) {
			Assert.assertEquals(nameErr, actNameError);
			System.out.println("Forename Error message is verified");
		} else {
			System.out.println("Forename Error message is not displayed");
		}

	}
	
	/*Verifies error is displayed for email*/
	
	public void verifyEmailErrorMessage() throws InterruptedException {

		String mailErr = "Email is required";
		WebElement emailError = driver.findElement(By.xpath(EMAIL_ERR));

		String actMailError = emailError.getText();
		if (emailError.isDisplayed()) {
			Assert.assertEquals(mailErr, actMailError);

			System.out.println("Email Error message is verified");
		} else {
			System.out.println("Email Error message is not displayed");
		}
	}

	/*Verifies error is displayed for message*/

	public void verifyMsgErrorMessage() throws InterruptedException {

		String msgErr = "Message is required";
		WebElement messageError = driver.findElement(By.xpath(MESSAGE_ERR));
		String actMSgError = messageError.getText();
		if (messageError.isDisplayed()) {
			Assert.assertEquals(msgErr, actMSgError);
			System.out.println("Message Error is verified");
		} else {
			System.out.println("Message Error is not displayed");
		}
	}
	
	/*To click the submit button*/
	
	public void submit() throws InterruptedException {

		driver.findElement(By.xpath("//a[contains(text(),'Submit')]")).click();
		Thread.sleep(5000);
	}

	/*Verifies success message is displayed after submitting*/

	public void verifySuccessMessage() {
		WebElement SuccessMsg = driver.findElement(By.xpath(SUCCESS_MSG));
		if (SuccessMsg.isDisplayed()) {
			System.out.println("Successful Submission is validated");
		} else {
			System.out.println("Feedback Submission is unsuccessful");

		}
	}
}
