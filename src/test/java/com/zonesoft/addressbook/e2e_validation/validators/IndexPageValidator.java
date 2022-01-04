package com.zonesoft.addressbook.e2e_validation.validators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.zonesoft.addressbook.e2e_validation.pages.IndexPage;

public class IndexPageValidator {
	
	private static final String EXPECTED_HELLO_LINK_TEXT = "Go to hello page";
	private static final String EXPECTED_PERSONS_LINK_TEXT = "Persons";
	
	public static void validate(final IndexPage indexPage) {
		assertEquals(EXPECTED_HELLO_LINK_TEXT, indexPage.helloLinkText());
		assertEquals(EXPECTED_PERSONS_LINK_TEXT, indexPage.personsLinkText());
	}
}
