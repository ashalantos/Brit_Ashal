package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.framework.BaseTest;

public class BritInsuranceContactTest extends BaseTest {

	@Test
	public void britInsuranceContactTest() throws InterruptedException {

		// Step 1: Go to https://www.britinsurance.com/
		driver.get("https://www.britinsurance.com/");
		System.out.println("1. Go to https://www.britinsurance.com/ ");
		driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
		WebElement menuButton = driver.findElement(By.xpath("//button[@data-trigger='mega-menu']"));
		wait.until(ExpectedConditions.elementToBeClickable(menuButton));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", menuButton);
		Thread.sleep(1000);

		// Step 2: Navigate to the contact page
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//a[contains(text(),'contact')]"))));
		WebElement menuContact = driver.findElement(By.xpath("//a[contains(text(),'contact')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", menuContact);
		menuContact.click();
		System.out.println("2. Navigate to the contact page using the menus ");

		// Step 3: Extract the Bermuda office address from the Bermuda office section
		// and validate it
		String bermudaLocationCity = driver
				.findElement(By
						.xpath("//h2[text()='Bermuda Office']/ancestor::div[@class='component--container']/div[2]//p"))
				.getText();
		String bermudaLocationAddress = driver
				.findElement(By.xpath(
						"//h2[text()='Bermuda Office']/ancestor::div[@class='component--container']/div[2]//address"))
				.getText();
		System.out.println(bermudaLocationCity);
		System.out.println(bermudaLocationAddress);
		String expectedBermudaLocationCity = "Pembroke";
		String expectedBermudaAddress = "Ground Floor, Chesney House\n" + "The Waterfront, 96 Pitts Bay Road,\n"
				+ "Pembroke, Hamilton HM 08, Bermuda";
		AssertJUnit.assertEquals(bermudaLocationCity.trim(), expectedBermudaLocationCity);
		AssertJUnit.assertEquals(bermudaLocationAddress, expectedBermudaAddress);
		System.out.println("3. Extract the Bermuda office address from the Bermuda office section and validate it ");

	}

}
