package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.framework.BaseTest;

public class BritInsuranceSearchTest extends BaseTest {

	@Test
	public void britInsuranceSearchTest() throws InterruptedException {

		driver.get("https://www.britinsurance.com/");
		System.out.println("1. Go to https://www.britinsurance.com/ ");
		driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();

		// CLICKS ON BANNER TO WORKING - TRIED MULTIPLE SOLUTIONS
		// ---------------------------------------------------------------------------------------
		// ---------------------------------------------------------------------------------------

//		System.out.println("Accepted cookies");

		// Thread.sleep(100000);

		// driver.findElement(By.cssSelector(".component--header__search
		// span")).click();

		WebElement element = driver.findElement(By.xpath("//div[@class='component--header__search']/button/span"));
//		System.out.println("element found");

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", element);
//		System.out.println("js click");

		// Scroll to the element using JavaScript
		// WebElement searchIcon =
		// driver.findElement(By.xpath("//div[@class='component--header__search']/button/span"));
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);", searchIcon);
		// Click the element
		// searchIcon.click();
		// System.out.println("searchIcon is clicked");

//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		element.click();
//		System.out.println("enter key");
//
//		// WebElement element = driver.findElement(By.id("elementId"));
//		// element.click();
//
//		Actions actions = new Actions(driver);
//		actions.click(element).perform();
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
//		wait.until(ExpectedConditions
//				.elementToBeClickable(driver.findElement(By.xpath("//div[@class='component--header__search']"))))
//				.click();
//
//		Actions build = new Actions(driver); // heare you state ActionBuider
//		build.moveToElement(element).click(element);
//		build.perform(); // Here you perform hover mouse over the needed elemnt to triger
//
//		System.out.println("element clicked move to element");
//
//		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
//		int frameCount = frames.size();
//
//		System.out.println("Number of frames on the page: " + frameCount);
//
//		List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
//		WebElement targetElement = driver.findElement(By.xpath("//div[@class='component--header__search']")); // Replace
//																												// with
//																												// your
//																												// target
//																												// element's
//																												// locator
//
//		for (WebElement iframe : iframes) {
//			System.out.println("inside iframes loop");
//			driver.switchTo().frame(iframe);
//			System.out.println("switched to iframe " + iframe);
//			try {
//				System.out.println("inside try");
//				targetElement = driver.findElement(By.xpath("//div[@class='component--header__search']"));
//				if (targetElement != null) {
//					// Element found within this iframe
//					System.out.println("Element found in iframe: " + iframe.getAttribute("src"));
//					break; // No need to continue searching
//				}
//			} catch (NoSuchElementException e) {
//				// Element not found in this iframe
//			}
//
//			driver.switchTo().defaultContent();
//			System.out.println("switched to default content.");
//		}
//
//		if (targetElement == null) {
//			System.out.println("Element not found in any iframes.");
//		}
		// ---------------------------------------------------------------------------------------
		// ---------------------------------------------------------------------------------------

		driver.findElement(By.xpath("//input[@name='k']")).sendKeys("IFRS 17");
		driver.findElement(By.xpath("//input[@name='k']")).sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='hero-static__title']/span")));
		AssertJUnit.assertEquals(driver.findElement(By.xpath("//h1[@class='hero-static__title']/span")).getText(), "IFRS 17",
				"Search results are displayed for IFRS 17");
		System.out.println("2. Search for term 'IFRS 17' in the search bar top right ");

		// Step 3: Assert on the three result titles
		int expectedNumberOfResults = 3;
		WebElement[] resultTitles = driver.findElements(By.xpath("//a[@class='s-results__tag']"))
				.toArray(new WebElement[0]);
		AssertJUnit.assertEquals(resultTitles.length, expectedNumberOfResults);
		String[] expectedTitles = { "Interim results for the six months ended 30 June 2022", "Gavin Wilkinson",
				"John King" };
		for (int i = 0; i < expectedNumberOfResults; i++) {
			AssertJUnit.assertEquals(resultTitles[i].getText(), expectedTitles[i]);
		}
		System.out.println(
				"3. Assert on the three result returned, confirm three results and assert on each results title.  ");
	}

}
