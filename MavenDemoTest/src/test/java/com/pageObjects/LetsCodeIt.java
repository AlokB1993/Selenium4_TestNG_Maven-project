package com.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LetsCodeIt {
	WebDriver driver;
	
	public LetsCodeIt(WebDriver driver) {
		this.driver = driver;
	}

	By allHyperLinks= By.tagName("a");
	
	By carBrands= By.id("carselect");
	
	By checkHonda=By.id("hondacheck");
	
	By checkBMW=By.id("bmwcheck");
	
	By checkBenz=By.id("benzcheck");
	
	public String getPageTitle() {
		 String aPageTitle= driver.getTitle();
		 return aPageTitle;
	}
	
	public List<String> getAllHyperLinks(){
		
		List<WebElement> allHyperLinks = driver.findElements(By.tagName("a"));
		List<String> LinkNames=new ArrayList<String>();
		for(WebElement a : allHyperLinks) {
			LinkNames.add(a.getText());
		}
		
		return LinkNames;
	}
	
	public void SelectCar(String CarBrand) {
		
		Select carSelect= new Select(driver.findElement(carBrands));
		switch (CarBrand) {
		case "Honda":
			carSelect.selectByVisibleText("Honda");
			break;
		case "BMW":
			carSelect.selectByVisibleText("BMW");
			break;
		case "Benz":
			carSelect.selectByVisibleText("Benz");
			break;
		default:
			System.out.println("Please select a valid car.");
			break;
		}
	}
	
	public void checkAllCars() {
		driver.findElement(checkHonda).click();
		driver.findElement(checkBMW).click();
		driver.findElement(checkBenz).click();
	}
}
	