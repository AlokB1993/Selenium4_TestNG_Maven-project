package com.testScenarios;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageObjects.MakeMyTripPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScenarios_MMT {

WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		driver= WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
	}
	
	@Test
	public void Test2() throws InterruptedException {
		
		MakeMyTripPage MMT=new MakeMyTripPage(driver);
		
		// When started developing the code there was a frame coming on top of the browser launch, that has been handled here
		MMT.closeBanner();
		
		//Select from city
		MMT.selectFromCity("Ahemdabad");
		
		//Select to city
		MMT.selectToCity("Delhi");
		
		//Select date
		MMT.selectdate("21 Jul");
		
		//wait has been implemented to notice the changes
		Thread.sleep(10000);
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
