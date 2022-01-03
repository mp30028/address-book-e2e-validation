package com.zonesoft.addressbook.e2e_validation.pages.person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonsListingPage {
	private final WebDriver driver;
	
	private static final String LISTING_TABLE_PATH = "/html/body/form/table";
	
	public PersonsListingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String pageTitle() {
		return driver.getTitle();
	}
	
	public List<String> listingTableHeadings(){
		List<String> headings = null;
		WebElement headerRowElement = getListingTableHeaderRowElement();
		List<WebElement> headerCells = headerRowElement.findElements(By.tagName("th"));
		if (Objects.nonNull(headerCells)) headings = new ArrayList<String>(); 
		for (WebElement headerCell : headerCells) {
			headings.add(headerCell.getText());
		}
		return headings;
	}

	public List<String> listingTableButtonLabels(){
		List<String> buttonLabels = null;
		WebElement buttonRowElement = getListingTableButtonRowElement();
		List<WebElement> buttonElements = buttonRowElement.findElements(By.tagName("button"));
		if (Objects.nonNull(buttonElements)) buttonLabels = new ArrayList<String>(); 
		for (WebElement buttonElement : buttonElements) {
			buttonLabels.add(buttonElement.getText());
		}
		return buttonLabels;
	}
	
	private WebElement getListingTableButtonRowElement() {
		List<WebElement> tableRows =  getListingTableElement().findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
		int numberOfRows = tableRows.size();
		int buttonRowOffsettFromEndOfTable = -2;
		return tableRows.get(numberOfRows + buttonRowOffsettFromEndOfTable +1);
	}
	
	private WebElement getListingTableHeaderRowElement() {
		return getListingTableElement().findElement(By.tagName("thead")).findElement(By.tagName("tr"));
	}
	
	private WebElement getListingTableElement() {
		WebElement listingTableElement = driver.findElement(By.xpath(LISTING_TABLE_PATH ));
		return listingTableElement;
	}
	
}
