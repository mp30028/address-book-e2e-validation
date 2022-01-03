package com.zonesoft.addressbook.e2e_validation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zonesoft.addressbook.e2e_validation.pages.greeting.HelloPage;

public class IndexPage {

	private static final String HELLO_LINK_TEXT = "Go to hello page";
	private static final String PERSONS_LINK_TEXT = "Persons";
	
	private final WebDriver driver;
	
	public IndexPage(WebDriver driver) {	
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions options = new ChromeOptions();
//		this.driver = new ChromeDriver(options);
		this.driver = driver;
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
	
//	public PersonsPage personsLinkClick() {
//		WebElement link = driver.findElement(By.linkText(PERSONS_LINK_TEXT));
//		link.click();
//		return new PersonsPage(driver);
//	}	
	
}
