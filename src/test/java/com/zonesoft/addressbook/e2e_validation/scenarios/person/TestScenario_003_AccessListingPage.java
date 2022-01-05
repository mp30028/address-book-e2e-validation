package com.zonesoft.addressbook.e2e_validation.scenarios.person;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.zonesoft.addressbook.e2e_validation.pages.IndexPage;
import com.zonesoft.addressbook.e2e_validation.pages.person.PersonsListingPage;
import com.zonesoft.addressbook.e2e_validation.scenarios.TestScenario_001_AccessApplicationLandingPage;

class TestScenario_003_AccessListingPage extends TestScenario_001_AccessApplicationLandingPage{
	
	private static final String SCENARIO_DESCRIPTION = 
		"Navigate to Persons Listing Page from Landing Page\r\n"
				+ "1. Open Landing Page using base url (static page - index.html)\r\n"
				+ "2. On Landing Page click 'Persons' link to navigate to Persons Listing Page (template - /persons/list.html)\r\n"
				+ "3. On Persons Listing Page click 'Home' button to return to Landing Page \r\n"
				+ "4. Quit and close Landing Page";
			
	@Test
	@Override
	@DisplayName(SCENARIO_DESCRIPTION)
	protected void runScenario() {
		IndexPage indexPage = start_withIndexPage();
		PersonsListingPage personsListingPage = go_fromIndexPage_toListingPage_clickingPersonsLink(indexPage);
		indexPage = go_fromListingPage_toIndexPage_clickingHomeButton(personsListingPage);
		indexPage.quit();
	}
	
	protected PersonsListingPage go_fromIndexPage_toListingPage_clickingPersonsLink(IndexPage indexPage) {
		PersonsListingPage personsListingPage = indexPage.personsLinkClick();
		ListingPageValidator.validate(personsListingPage);
		return personsListingPage;
	}

	protected IndexPage go_fromListingPage_toIndexPage_clickingHomeButton(PersonsListingPage personsListingPage) {
		IndexPage indexPage = personsListingPage.homeButtonClick();
		IndexPageValidator.validate(indexPage);
		return indexPage;
	}
	
	protected static class ListingPageValidator {
		private static final String EXPECTED_LISTING_PAGE_TITLE = "Persons";

		
		
		private static final int EXPECTED_COLUMN_HEADINGS_COUNT = 4;
		private static final String EXPECTED_COLUMN_1_HEADING = "Person ID";
		private static final String EXPECTED_COLUMN_2_HEADING = "Lastname";
		private static final String EXPECTED_COLUMN_3_HEADING = "Firstname";
		private static final String EXPECTED_COLUMN_4_HEADING = "Birth-Date";
		
		private static final int EXPECTED_BUTTON_COUNT = 4;
		private static final String EXPECTED_BUTTON_1_LABEL = "Add";
		private static final String EXPECTED_BUTTON_2_LABEL = "Edit";
		private static final String EXPECTED_BUTTON_3_LABEL = "Delete";
		private static final String EXPECTED_BUTTON_4_LABEL = "Home";
		

		
		
		public static void validate(PersonsListingPage personsListingPage) {
			validatePageTitle(personsListingPage);
			validateListingTable(personsListingPage);
		}
		
		
		private static void validatePageTitle(PersonsListingPage personsListingPage) {
			assertEquals(EXPECTED_LISTING_PAGE_TITLE, personsListingPage.pageTitle());
		}
		
		private static void validateListingTable(PersonsListingPage personsListingPage) {
			validateColumnHeadings(personsListingPage);
			validateButtons(personsListingPage);
		}
		
		private static void validateColumnHeadings(PersonsListingPage personsListingPage) {
			List<String> headings = personsListingPage.listingTableHeadings();
			assertEquals(EXPECTED_COLUMN_HEADINGS_COUNT, headings.size());
			assertEquals(headings.get(0), EXPECTED_COLUMN_1_HEADING);
			assertEquals(headings.get(1), EXPECTED_COLUMN_2_HEADING);
			assertEquals(headings.get(2), EXPECTED_COLUMN_3_HEADING);
			assertEquals(headings.get(3), EXPECTED_COLUMN_4_HEADING);
		}
		
		private static void validateButtons(PersonsListingPage personsListingPage) {
			List<String> buttonLabels = personsListingPage.listingTableButtonLabels();
			assertEquals(EXPECTED_BUTTON_COUNT, buttonLabels.size());
			assertEquals(buttonLabels.get(0), EXPECTED_BUTTON_1_LABEL);
			assertEquals(buttonLabels.get(1), EXPECTED_BUTTON_2_LABEL);
			assertEquals(buttonLabels.get(2), EXPECTED_BUTTON_3_LABEL);
			assertEquals(buttonLabels.get(3), EXPECTED_BUTTON_4_LABEL);
			
		}
	}
}
