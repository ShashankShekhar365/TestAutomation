package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;

	@BeforeMethod
	public void setUp() throws IOException {
		if (driver == null) {
			fr = new FileReader(
					System.getProperty("user.dir") + "//src//test//resources//configfiles//config.properties");
			prop.load(fr);
		}

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup(); // base
			driver = new ChromeDriver(); // base
			driver.get(prop.getProperty("testurl")); // properties
			driver.manage().window().maximize();
		}

		else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup(); // base
			driver = new ChromeDriver(); // base
			driver.get(prop.getProperty("testurl")); // properties
			driver.manage().window().maximize();
		}

		else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup(); // base
			driver = new ChromeDriver(); // base
			driver.get(prop.getProperty("testurl")); // properties
			driver.manage().window().maximize();
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		System.out.println("TearDown successfully");
	}

}
