package com.zonesoft.addressbook.e2e_validation.pages.person;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zonesoft.addressbook.e2e_validation.interfaces.IHtmlInput;
import com.zonesoft.addressbook.e2e_validation.interfaces.implementations.HtmlInput;

public class PersonUpdatePage {
	
	private static final String CRUD_TYPE_INPUT_ID = "crudType";
	private static final String PERSON_ID_INPUT_ID = "id";
	private static final String FIRSTNAME_INPUT_ID = "firstname";
	private static final String LASTNAME_INPUT_ID = "lastname";
	private static final String DATE_OF_BIRTH_INPUT_ID = "dateOfBirth";
	private static final String CANCEL_BUTTON_ID = "requestCancel";
	
	
	private final WebDriver driver;
	
	public PersonUpdatePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String pageTitle() {
		return driver.getTitle();
	}
	
	public IHtmlInput personIdInput() {
		return new HtmlInput(driver.findElement(By.id(PERSON_ID_INPUT_ID)));
	}
	
	public IHtmlInput crudTypeInput() {
		return new HtmlInput(driver.findElement(By.id(CRUD_TYPE_INPUT_ID)));
	}
	
	public IHtmlInput firstnameInput() {
		return new HtmlInput(driver.findElement(By.id(FIRSTNAME_INPUT_ID)));
	}
	
	public IHtmlInput lastnameInput() {
		return new HtmlInput(driver.findElement(By.id(LASTNAME_INPUT_ID)));
	}
	
	public IHtmlInput dateOfBirthInput() {
		return new HtmlInput(driver.findElement(By.id(DATE_OF_BIRTH_INPUT_ID)));
	}
	
	public PersonsListingPage cancelButtonClick() {
		driver.findElement(By.id(CANCEL_BUTTON_ID)).click();
		return new PersonsListingPage(driver);
	}
	
}
