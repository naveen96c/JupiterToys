package testCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Contact;
import Pages.Home;
import Pages.Shop;
import base.Testbase;

public class TestCase2 extends Testbase {

	Contact contact;
	Shop shop;
	Home home;

	/*Constructor to call the methods from base class*/
	public TestCase2() {
		super();
	}

	/*gets browser details and launches url */
	@BeforeMethod
	public void setup() {
		initialization();
		home = new Home();
	}

	/*submit the feedback with mandatory details and executing 5 times to ensure 100% pass rate */
	@Test(invocationCount=5)
	public void SubmitFeedback() throws InterruptedException {
		contact = home.gotoContact();
		Thread.sleep(2000);
		contact.enterMandatoryDetails();
		contact.submit();
		contact.verifySuccessMessage();
	}
	@AfterMethod
	public void end(){
		driver.quit();
	}
}
