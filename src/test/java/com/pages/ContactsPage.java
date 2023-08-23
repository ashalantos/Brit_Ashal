package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactsPage {
	private WebDriver driver;
	WebDriverWait wait;

	WebElement bermudaLocationCity = driver.findElement(
			By.xpath("//h2[text()='Bermuda Office']/ancestor::div[@class='component--container']/div[2]//p"));

	WebElement bermudaLocationAddress = driver.findElement(
			By.xpath("//h2[text()='Bermuda Office']/ancestor::div[@class='component--container']/div[2]//address"));

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	}

	public String getBermudaLocationCity() {
		return bermudaLocationCity.getText();
	}

	public String getBermudaLocationAddress() {
		return bermudaLocationAddress.getText();
	}

}
