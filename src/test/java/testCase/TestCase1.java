package testCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.Contact;
import Pages.Home;
import base.Testbase;

public class TestCase1 extends Testbase {
	Contact contact;
	Home home;
	
/*Constructor to call the methods from base class*/
	public TestCase1() {
		super();
	}
/*gets browser details and launches url */
	@BeforeMethod
	public void setup() {
		initialization();
		home = new Home();
	}
/*Testcase1 = validates errors for mandatory fields during submit*/
	@Test
	public void validateErrors() throws InterruptedException {
		contact = home.gotoContact();
		Thread.sleep(3000);
		contact.submit();
		contact.verifyForenameErrorMessage();//to verify the error message is displayed for forename field
		contact.verifyEmailErrorMessage();//to verify the error message is displayed for email field
		contact.verifyMsgErrorMessage();//to verify the error message is displayed for Message field
		contact.enterMandatoryDetails(); //forename,email and message details are entered
		contact.checkForenameError(); //checks forename error message is not present
		contact.checkEmailError();//checks email error message is not present
		contact.checkMessageError();//checks message field error message is not present

	}

	@AfterMethod
	public void end() {
		driver.quit();
	}
}
