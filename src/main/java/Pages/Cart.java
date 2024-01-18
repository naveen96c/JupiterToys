package Pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.Testbase;

public class Cart extends Testbase {
//	Shop shop;

	public static String element_common = "/html[1]/body[1]/div[2]/div[1]/form[1]/table[1]/tbody[1]/";
	List<WebElement> row = driver.findElements(By.xpath(element_common + "tr"));
	int row_Count = row.size();

	List<WebElement> column = driver.findElements(By.xpath(element_common + "tr[1]/td"));
	int column_Count = column.size();

	/* Fetches prices and qty for each product and verifies the subtotal */

	public void verifySubtotal() {

		for (int i = 1; i <= row_Count; i++) {
			int j = 2;
			String price = driver.findElement(By.xpath(element_common + "tr[" + i + "]/td[" + j + "]")).getText();
			String priceValue = price.replaceAll("[^\\d.]", "");
			float floatPrice = Float.parseFloat(priceValue);

			WebElement qty = driver
					.findElement(By.xpath(element_common + "tr[" + i + "]/td[" + (j + 1) + "]/input[1]"));
			String qtyValue = qty.getAttribute("Value");
			int floatQty = Integer.parseInt(qtyValue);
			float sum = floatPrice * floatQty;

			String subtotal = driver.findElement(By.xpath(element_common + "tr[" + i + "]/td[" + (j + 2) + "]"))
					.getText();
			String subtotalValue = subtotal.replaceAll("[^\\d.]", "");
			float Sub_total = Float.parseFloat(subtotalValue);

			if (Sub_total == sum) {
				Assert.assertEquals(Sub_total, sum);
				System.out.println("the Subtotal is verified");
			} else {
				System.out.println("the Subtotal is not verified");
			}

		}

	}

	/* Fetches the Total and subtotal value and verifies both are Equal */

	public void verifytotalandsubtotal() {

		String total_Value = driver
				.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/form[1]/table[1]/tfoot[1]/tr[1]/td[1]/strong[1]"))
				.getText();
		String tot_Val = total_Value.replace("Total: ", "").trim();

		float total = Float.parseFloat(tot_Val);
		float sum_count_suntotal = 0;
		for (int i = 1; i <= row_Count; i++) {

			int j = column_Count - 1;
			String subtotal = driver.findElement(By.xpath(element_common + "tr[" + i + "]/td[" + (j) + "]")).getText();
			String subtotalValue = subtotal.replaceAll("[^\\d.]", "");
			float Sub_total = Float.parseFloat(subtotalValue);
			sum_count_suntotal += Sub_total;

		}
		if (total == sum_count_suntotal) {
			Assert.assertEquals(total, sum_count_suntotal);
			System.out.println("The total and sum of sub total value is equal");
		} else {
			System.out.println("not equal");
		}

	}

	/* Fetches product name and price for items in cart page */

	public Map<String, String> verifyPriceForEachProduct() {

		Map<String, String> productInfo = new HashMap<>();
		for (int i = 1; i <= row_Count; i++) {
			int j = 1;
			String product_Name = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[" + j + "]")).getText();
			String product_Price = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[" + (j + 1) + "]")).getText();
			productInfo.put(product_Name, product_Price);

		}
		return productInfo;
	}

}
