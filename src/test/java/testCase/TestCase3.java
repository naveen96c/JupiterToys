package testCase;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Cart;
import Pages.Home;
import Pages.Shop;
import base.Testbase;

public class TestCase3 extends Testbase {
	Shop shop;
	Home home;
	Cart cart;

	/*Constructor to call the methods from base class*/
	public TestCase3() {
		super();
	}

	/*gets browser details and launches url */
	@BeforeMethod
	public void setup() {
		initialization();
		home = new Home();
	}

	/*Add items to cart and verify total,Sub-total and price for each product */
	@Test
	public void buyItems() throws InterruptedException {
		shop = home.gotoShop();
		Thread.sleep(3000);
		shop.buyStuffedFrog();// adds 2 stuffed frog to cart
		shop.buyFluffyBunny(); // adds 5 fluffy bunny to cart
		shop.buyValentineBear(); // adds 2 valentine bear to cart
		Map<String, String> actual_Items = shop.itemList();//fetching product name and price for all items in shop page
		cart = shop.gotoCart();
		cart.verifySubtotal(); //verifying Sub-total for each product
		cart.verifytotalandsubtotal(); //verifying total and sub-total price
		Map<String, String> cart_Items = cart.verifyPriceForEachProduct();//fetching product name and price for in cart page

		boolean mapsAreEqual = compareMaps(actual_Items, cart_Items); //Compares product name and price in shop page and cart page are same

		if (mapsAreEqual) {
			System.out.println("The Price of each product is verified");
		} else {
			System.out.println("The Price of each product is different");
		}
	}

	private static boolean compareMaps(Map<String, String> actual_Items, Map<String, String> cart_Items) {
		return actual_Items.entrySet().containsAll(cart_Items.entrySet());
	}

	@AfterMethod
	public void end() {
		driver.quit();
	}
}
