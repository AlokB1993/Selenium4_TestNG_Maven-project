package com.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeMyTripPage {

	WebDriver driver;

	public MakeMyTripPage(WebDriver driver) {
		this.driver = driver;
	}

	By fromCity = By.xpath("//input[@type='text' and @placeholder='From']");

	By toCity = By.xpath("//input[@type='text' and @placeholder='To']");

	By bannerClose = By.xpath("//*[@id='webklipper-publisher-widget-container-notification-close-div']/i");

	By monthHeader = By.xpath("//div[@class='DayPicker-Caption']");

	By days = By.xpath("//div[@class='DayPicker-Day']");

	By nextMonth = By.xpath("//span[@aria-label='Next Month']");

	public void closeBanner() throws InterruptedException {
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
//		
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(bannerClose)));
		
		try {
			driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement c = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/a"));
			js.executeScript("arguments[0].click()", c);
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			driver.findElement(By.xpath("//Span[@class='langCardClose']")).click();
		}
	}

	public void selectFromCity(String fromCity) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		Thread.sleep(1000);
		driver.findElement(this.fromCity).sendKeys(fromCity);
		Thread.sleep(1000);
		driver.findElement(this.fromCity).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		driver.findElement(this.fromCity).sendKeys(Keys.ENTER);
	}

	public void selectToCity(String toCity) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(this.toCity).sendKeys(toCity);
		Thread.sleep(1000);
		driver.findElement(this.toCity).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		driver.findElement(this.toCity).sendKeys(Keys.ENTER);

	}

	public void selectdate(String ddMMM) throws InterruptedException {
		Thread.sleep(1000);
		String[] dateAndMonth=ddMMM.split(" ");
		String date=dateAndMonth[0];
		String Month=dateAndMonth[1].trim();

		// Write a while to loop the date and keep checking until you find your month
		int i = 1;
		while (i < 12) {
			String x = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[" + 1 + "]")).getText();
			String x1 = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[" + 2 + "]")).getText();
			if (!x.contains(Month) && !x1.contains(Month)) {
				driver.findElement(nextMonth).click();
				break;
			}
			i++;
		}
		List<WebElement> days1 = driver.findElements(days);
		for (WebElement a : days1) {
			String x3 = a.getAttribute("aria-label");
			if (x3.contains(date) && x3.contains(Month)) {
				Thread.sleep(2000);
				a.click();
				break;
		}
	}


}
}