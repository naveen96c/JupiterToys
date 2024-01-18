package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import util.TestUtil;

public class Testbase {
	public static WebDriver driver;
	public static Properties prop;
	public static String dir = System.getProperty("user.dir");

	// reading property file
	public Testbase() {
		FileInputStream fis;
		try {
			prop = new Properties();
			fis = new FileInputStream(dir + "\\src\\main\\java\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("deprecation")
	public static void initialization() {

		String driverPath = dir + "\\src\\main\\java\\driver\\chromedriver.exe"; // reading chrome driver path
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			driver = new FirefoxDriver();
		} else if (browserName.equals("Safari")) {
			driver = new SafariDriver();
		} else if (browserName.equals("IE")) {
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("no browser value given");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
