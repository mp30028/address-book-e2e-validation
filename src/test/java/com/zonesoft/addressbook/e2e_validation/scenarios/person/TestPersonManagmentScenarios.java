package com.zonesoft.addressbook.e2e_validation.scenarios.person;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.zonesoft.addressbook.e2e_validation.pages.IndexPage;
import com.zonesoft.addressbook.e2e_validation.pages.greeting.HelloPage;
import com.zonesoft.addressbook.e2e_validation.properties.E2eValidationProperties;
import com.zonesoft.addressbook.e2e_validation.scenarios.AbstractLandingPage;

import io.github.bonigarcia.wdm.WebDriverManager;

class TestPersonManagmentScenarios extends AbstractLandingPage {


	private static WebDriver driver;
	

	@Test
	void runScenario() {
		IndexPage indexPage = navigate_toIndexPage();
	
	}

	




}
