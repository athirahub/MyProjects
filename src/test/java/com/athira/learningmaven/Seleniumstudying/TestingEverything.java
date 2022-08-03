package com.athira.learningmaven.Seleniumstudying;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestingEverything {
	WebDriver driver;
	@BeforeMethod
	public void openBrowser() {

		
		System.setProperty("webdriver.edge.driver", "C:\\Driver\\Edge Driver\\msedgedriver.exe");
		driver=new EdgeDriver();

		driver.get("https://ca.hotels.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void test1() {
		String titlePage=driver.getTitle();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
		System.out.println("Title is :"+titlePage);
//		Assert.assertEquals(titlePage, "Hotels.com - Deals & Discounts for Hotel Reservations from Luxury Hotels to Budget Accommodations","Title is incorrect");
		WebElement nfg=driver.findElement(By.cssSelector("div.uitk-field.has-floatedLabel-label.has-icon.has-no-placeholder button.uitk-fake-input.uitk-form-field-trigger:first-of-type"));
		nfg.isEnabled();
		nfg.sendKeys("Toronto");
		nfg=driver.findElement(By.cssSelector("#submit_button svg.uitk-icon.uitk-icon-leading"));
		nfg.click();
		System.out.println("Is selected:"+nfg.isSelected());

	}

	@AfterMethod
	public void teardown() {
		driver.close();

	}
}
