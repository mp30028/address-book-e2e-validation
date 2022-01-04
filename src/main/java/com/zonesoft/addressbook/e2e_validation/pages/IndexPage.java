package com.zonesoft.addressbook.e2e_validation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.zonesoft.addressbook.e2e_validation.pages.greeting.HelloPage;
import com.zonesoft.addressbook.e2e_validation.pages.person.PersonsListingPage;
import com.zonesoft.addressbook.e2e_validation.properties.E2eValidationProperties;
import io.github.bonigarcia.wdm.WebDriverManager;

public class IndexPage {

	private static final String HELLO_LINK_TEXT = "Go to hello page";
	private static final String PERSONS_LINK_TEXT = "Persons";
	
	private final E2eValidationProperties properties;
	private final WebDriver driver;
	
	public IndexPage() {	
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		this.driver = new ChromeDriver(options);
		this.properties = new E2eValidationProperties();
	}
	
	public IndexPage(WebDriver driver) {	
		this.driver = driver;
		this.properties = new E2eValidationProperties();
	}
	
	public IndexPage open() {
		this.driver.get(properties.getBaseUrl());
		return this;
	}
	
	
	public String helloLinkText() {
		WebElement helloLink = driver.findElement(By.linkText(HELLO_LINK_TEXT));
		return helloLink.getText();
	}
	
	
	public String personsLinkText() {
		WebElement helloLink = driver.findElement(By.linkText(PERSONS_LINK_TEXT));
		return helloLink.getText();
	}
	
	public HelloPage helloLinkClick() {
		WebElement link = driver.findElement(By.linkText(HELLO_LINK_TEXT));
		link.click();
		return new HelloPage(driver);
	}
	
	public PersonsListingPage personsLinkClick() {
		WebElement link = driver.findElement(By.linkText(PERSONS_LINK_TEXT));
		link.click();
		return new PersonsListingPage(driver);
	}
	
	public void quit() {
		driver.quit();
	}
	
}
