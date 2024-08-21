package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class MyFirstTest extends BaseTest {

	@Test(dataProvider = "testdata")
	public static void LoginTest(String username, String password) throws InterruptedException {
		driver.findElement(By.linkText("Sign in")).click(); // locators --properties
		Thread.sleep(2000);
		driver.findElement(By.id("login_id")).sendKeys(username);
		driver.findElement(By.xpath("//span[normalize-space () = 'Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@id='nextbtn']")).click();
		Thread.sleep(2000);
		System.out.println("Completed successfully");
	}

	@DataProvider(name = "testdata")
	public Object[][] tData() {
		return new Object[][] { { "rc@gmail.com", "testautn@1546456" }, { "rcvtutail.com", "testauto23" },
				{ "rcvtutomail.com", "test automa67567@123" }, { "s1hashank.s.112@gmail.com", "Manali1357@" } };
	}
}
