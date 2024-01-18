package Pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.Testbase;

public class Shop extends Testbase {

	public static String STUFFED_FROG = "//body/div[2]/div[1]/ul[1]/li[2]/div[1]/p[1]/a[1]";
	public static String FLUFFY_BUNNY = "//body/div[2]/div[1]/ul[1]/li[4]/div[1]/p[1]/a[1]";
	public static String VALENTINE_BEAR = "//body/div[2]/div[1]/ul[1]/li[7]/div[1]/p[1]/a[1]";
	public static String cart = "//body/div[1]/div[1]/div[1]/div[1]/ul[2]/li[4]/a[1]";
	public static String ITEMS_LIST = "/html[1]/body[1]/div[2]/div[1]/ul[1]/li";

	/*Clicks Stuffed frog buy button for 2 times*/

	public void buyStuffedFrog() {
		for (int i = 0; i < 2; i++) {
			driver.findElement(By.xpath(STUFFED_FROG)).click();
		}
	}

	/*Clicks Fluffy bunny buy button for 5 times*/

	public void buyFluffyBunny() {
		for (int i = 0; i < 5; i++) {
			driver.findElement(By.xpath(FLUFFY_BUNNY)).click();
		}
	}

	/*Clicks Valentine bear buy button for 3 times*/

	public void buyValentineBear() {
		for (int i = 0; i < 3; i++) {
			driver.findElement(By.xpath(VALENTINE_BEAR)).click();
		}
	}

	public Cart gotoCart() throws InterruptedException {
		driver.findElement(By.xpath(cart)).click();
		Thread.sleep(2000);
		return new Cart();
	}

	/*Fetches product name and price for all items in shop page*/

	public Map<String, String> itemList() {
		
		Map<String, String> shop_productInfo = new HashMap<>();

		List<WebElement> item_list = driver.findElements(By.xpath(ITEMS_LIST));
		int listCount = item_list.size();
		for (int i = 1; i <= listCount; i++) {
			String product_Title = driver.findElement(By.xpath(ITEMS_LIST + "[" + i + "]/div[1]/h4[1]")).getText();

			String product_Price = driver.findElement(By.xpath(ITEMS_LIST + "[" + i + "]/div[1]/p[1]/span[1]"))
					.getText();
			shop_productInfo.put(product_Title, product_Price);

		}
		return shop_productInfo;
	}

}