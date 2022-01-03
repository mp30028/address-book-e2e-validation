package com.zonesoft.addressbook.e2e_validation.scenarios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.zonesoft.addressbook.e2e_validation.pages.IndexPage;
import com.zonesoft.addressbook.e2e_validation.properties.E2eValidationProperties;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class AbstractLandingPage {

	private static final String EXPECTED_HELLO_LINK_TEXT = "Go to hello page";
	private static final String EXPECTED_PERSONS_LINK_TEXT = "Persons";
	
	private IndexPage indexPage;
	
	private static E2eValidationProperties properties = new E2eValidationProperties(); 
	private static WebDriver driver;
	

	
	@BeforeAll
	static void initialiseAtStart() {
		assertNotNull(properties);
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		AbstractLandingPage.driver = new ChromeDriver(options);
		assertNotNull(driver);
		String baseUrl = properties.getBaseUrl(); 
		assertNotNull(baseUrl);
		AbstractLandingPage.driver.get(properties.getBaseUrl());
	}
	
	public IndexPage navigate_toIndexPage() {
		indexPage = new IndexPage(driver);
		validateIndexPage(indexPage);
		return indexPage;
	}
	
	public void validateIndexPage(IndexPage indexPage) {
		assertEquals(EXPECTED_HELLO_LINK_TEXT, indexPage.helloLinkText());
		assertEquals(EXPECTED_PERSONS_LINK_TEXT, indexPage.personsLinkText());
	}






}
