package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {
	private WebDriver driver;
	WebDriverWait wait;

	By searchResultsHeaderForIFRSIV = By.xpath("//h1[@class='hero-static__title']/span");
	WebElement searchBar = driver.findElement(By.xpath("//input[@name='k']"));
	List<WebElement> searchResults = driver.findElements(By.xpath("//a[@class='s-results__tag']"));

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	}

	public By getSearchResultsHeaderForIFRSIV() {
		return searchResultsHeaderForIFRSIV;
	}

	public String getSearchResultsHeaderForIFRSIVText() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(getSearchResultsHeaderForIFRSIV()));
		return driver.findElement(By.xpath("//h1[@class='hero-static__title']/span")).getText();
	}

	public List<WebElement> getSearchhResults() {
		return searchResults;
	}
}
