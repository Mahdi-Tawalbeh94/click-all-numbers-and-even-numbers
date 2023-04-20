package appiunm_ff;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MyTestCases {
	DesiredCapabilities caps = new DesiredCapabilities();
	AndroidDriver driver;

	@BeforeTest
	public void myBeforeTest() {

		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Mahdi1");
		File calculator = new File("src/MyApplications/calculator.apk");
		caps.setCapability(MobileCapabilityType.APP, calculator.getAbsolutePath());
//		caps.setCapability("chromedriverExecutable", "C:\\Users\\DELL\\Downloads\\driver\\chromedriver.exe");
//		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
	}

//	@Test()
//	public void openTheApp() throws MalformedURLException {
//		 driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
//		 
//		
//	}

	@Test()
	public void clickOnAllDigit() throws MalformedURLException {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		List<WebElement> Buttons = driver.findElements(By.className("android.widget.ImageButton"));
		System.out.println(Buttons.size());

		// to click all digits
//		 for (int i = 0; i < Buttons.size(); i++) {
//			 if (Buttons.get(i).getAttribute("resourceId").contains("digit")) {
//				 Buttons.get(i).click();
//				 
//				 
//				
//			}
//		}

//		 SoftAssert myAssert =new SoftAssert();
//		 String exp="7894561230";
//		String act= driver.findElement(By.id("com.google.android.calculator:id/formula")).getText();
//		
//		myAssert.assertEquals(act, exp);
//		myAssert.assertAll();

		// to click even numbers
		for (int i = 0; i < Buttons.size(); i++) {
			if (Buttons.get(i).getAttribute("content-desc").contains("8")
					|| Buttons.get(i).getAttribute("content-desc").contains("4")
					|| Buttons.get(i).getAttribute("content-desc").contains("6")
					||Buttons.get(i).getAttribute("content-desc").contains("2")) {

				Buttons.get(i).click();

			}
		}
		String exp="8462";
		String act=driver.findElement(By.id("com.google.android.calculator:id/formula")).getText();
		SoftAssert myAssert =new SoftAssert();
		myAssert.assertEquals(act, exp);

	}

//	@Test()
//	public void openTheBrwser() throws MalformedURLException {
//		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
//
//		
//		driver.get("https://www.google.com");
//		
//	}

	@AfterTest
	public void myAfterTest() {
	}

}
