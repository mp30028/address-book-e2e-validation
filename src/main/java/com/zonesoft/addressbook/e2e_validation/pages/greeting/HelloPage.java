package com.zonesoft.addressbook.e2e_validation.pages.greeting;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zonesoft.addressbook.e2e_validation.pages.IndexPage;

public class HelloPage {
	
	private final WebDriver driver;
	
	public HelloPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public List<String> messagesDisplayedText() {
		List<WebElement> paragraphs =  driver.findElements(By.tagName("p"));
		List<String> messages = null;
		if (Objects.nonNull(paragraphs)) messages = new ArrayList<String>(); 
		for (WebElement paragraph: paragraphs) {
			messages.add(paragraph.getText());
		}
		return messages;
	}
	
	public String startingPageLinkText() {
		WebElement startingPageLink = driver.findElement(By.tagName("a"));
		return startingPageLink.getText();
	}
	
	public String startingPageLinkHref() {
		WebElement startingPageLink = driver.findElement(By.tagName("a"));
		return startingPageLink.getAttribute("href");
	}
	
	public IndexPage startingPageLinkClick() {
		WebElement startingPageLink = driver.findElement(By.tagName("a"));
		startingPageLink.click();
		return new IndexPage(driver);
	}
}
