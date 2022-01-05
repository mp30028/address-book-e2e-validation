package com.zonesoft.addressbook.e2e_validation.scenarios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.zonesoft.addressbook.e2e_validation.pages.IndexPage;

public class TestScenario_001_AccessApplicationLandingPage {
	
	private static final String SCENARIO_DESCRIPTION = 
			"Open Landing Page then quit\r\n"
			+ "1. Open Landing using base url (static page - index.html)\r\n"
			+ "2. Quit and close opened page\r\n";
	
	private IndexPage indexPage;
	

	@Test
	@DisplayName(SCENARIO_DESCRIPTION)
	protected void runScenario() {
		IndexPage indexPage = start_withIndexPage();
		indexPage.quit();
	}
	
	protected IndexPage start_withIndexPage() {
		indexPage = new IndexPage();
		indexPage.open();
		IndexPageValidator.validate(indexPage);
		return indexPage;
	}
	
	protected static class IndexPageValidator {
		
		private static final String EXPECTED_HELLO_LINK_TEXT = "Go to hello page";
		private static final String EXPECTED_PERSONS_LINK_TEXT = "Persons";
		
		public static void validate(final IndexPage indexPage) {
			assertEquals(EXPECTED_HELLO_LINK_TEXT, indexPage.helloLinkText());
			assertEquals(EXPECTED_PERSONS_LINK_TEXT, indexPage.personsLinkText());
		}
	}

}
