package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private WebDriver driver = null;
	WebDriverWait wait;

	WebElement acceptCookiesButton = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
	WebElement searchBar = driver.findElement(By.xpath("//input[@name='k']"));

	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	}

	public void clickOnAcceptCookiesButton() {
		acceptCookiesButton.click();
	}

	public void search(String stringToSearch) {
		searchBar.sendKeys(stringToSearch);
		searchBar.sendKeys(Keys.ENTER);
	}

	public void clickOnMenuButton() throws InterruptedException {
		WebElement menuButton = driver.findElement(By.xpath("//button[@data-trigger='mega-menu']"));
		wait.until(ExpectedConditions.elementToBeClickable(menuButton));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", menuButton);
		Thread.sleep(1000);
	}

	public void clickOnContacts() {
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//a[contains(text(),'contact')]"))));

		WebElement menuContact = driver.findElement(By.xpath("//a[contains(text(),'contact')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", menuContact);
		menuContact.click();
	}

}
