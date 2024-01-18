package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Testbase;

public class Home extends Testbase {

	//reading home page web elements using page factory
	@FindBy(id= "nav-shop")
	WebElement shop;
	
	@FindBy(id= "nav-contact")
	WebElement contact;
	
	public Home() {
		PageFactory.initElements(driver, this);
	}
	
	public Shop gotoShop() {
		shop.click();
		return new Shop();
	}
	
	public Contact gotoContact() {
		contact.click();
		return new Contact();
	}
}
