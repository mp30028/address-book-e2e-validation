package com.zonesoft.addressbook.e2e_validation;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class NavigateToIndexUrlTest {

	
	@Test
	void testNavigation() {
		String indexUrl = "http://localhost:8080/address-book/index.html";
		String linkText = "Go to hello page";
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		driver.get(indexUrl);
		WebElement link = driver.findElement(By.linkText(linkText));
		assertNotNull(link);
//		link.click();
//		searchBox.sendKeys("Packt Publishing");
//		searchBox.submit();
	}
	
}
