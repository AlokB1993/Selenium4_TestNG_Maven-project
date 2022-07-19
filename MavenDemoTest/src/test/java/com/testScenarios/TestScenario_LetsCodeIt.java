package com.testScenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageObjects.LetsCodeIt;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScenario_LetsCodeIt {

	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		driver= WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get("https://courses.letskodeit.com/practice");
	}
	
	@Test
	public void Test1() throws InterruptedException {
		LetsCodeIt LCI= new LetsCodeIt(driver);
		
		//Fetch the title of the page

		try {
		System.out.println("The page title is: "+LCI.getPageTitle());
		
		//Collect all the hyperlinks in the page
		System.out.println("All hyper links are : ");
		for(String a : LCI.getAllHyperLinks()) {
			System.out.print(a + ",");
		}
		
		//Select a car brand from the drop down.

		LCI.SelectCar("Honda");
		
		//Click on the Honda, Benz and BMW check button.
		
		LCI.checkAllCars();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		Thread.sleep(10000);
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
}
