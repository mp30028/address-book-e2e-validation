package com.zonesoft.addressbook.e2e_validation.interfaces.implementations;

import org.openqa.selenium.WebElement;

import com.zonesoft.addressbook.e2e_validation.interfaces.IHtmlInput;

public class HtmlInput implements IHtmlInput {
	
	private  final WebElement inputElement;
	
	public HtmlInput(WebElement inputElement) {
		this.inputElement = inputElement;
	}
	
	@Override
	public String type() {
		return inputElement.getAttribute("type");
	}

	@Override
	public String value() {
		return inputElement.getAttribute("value");
	}

	@Override
	public String name() {
		return inputElement.getAttribute("name");
	}

}
