package com.zonesoft.addressbook.e2e_validation.scenarios.person;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import com.zonesoft.addressbook.e2e_validation.pages.IndexPage;
import com.zonesoft.addressbook.e2e_validation.pages.person.PersonsListingPage;
import com.zonesoft.addressbook.e2e_validation.scenarios.AbstractLandingPage;

class TestPersonManagmentScenarios extends AbstractLandingPage {
	
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

	@Test
	void runScenario() {
		IndexPage indexPage = navigate_toIndexPage();
		PersonsListingPage personsListingPage = navigate_fromIndexPage_toPersonsListingPage(indexPage);
	
	}


	private PersonsListingPage navigate_fromIndexPage_toPersonsListingPage(IndexPage indexPage) {
		PersonsListingPage personsListingPage = indexPage.personsLinkClick();
		validatePersonsListingPage_title(personsListingPage);
		validatePersonsListingPage_listingTable(personsListingPage);
		return personsListingPage;
	}


	private void validatePersonsListingPage_title(PersonsListingPage personsListingPage) {
		assertEquals(EXPECTED_LISTING_PAGE_TITLE, personsListingPage.pageTitle());
	}
	
	private void validatePersonsListingPage_listingTable(PersonsListingPage personsListingPage) {
		List<String> headings = personsListingPage.listingTableHeadings();
		assertEquals(EXPECTED_COLUMN_HEADINGS_COUNT, headings.size());
		assertEquals(headings.get(0), EXPECTED_COLUMN_1_HEADING);
		assertEquals(headings.get(1), EXPECTED_COLUMN_2_HEADING);
		assertEquals(headings.get(2), EXPECTED_COLUMN_3_HEADING);
		assertEquals(headings.get(3), EXPECTED_COLUMN_4_HEADING);
		
		List<String> buttonLabels = personsListingPage.listingTableButtonLabels();
		assertEquals(EXPECTED_BUTTON_COUNT, buttonLabels.size());
		assertEquals(buttonLabels.get(0), EXPECTED_BUTTON_1_LABEL);
		assertEquals(buttonLabels.get(1), EXPECTED_BUTTON_2_LABEL);
		assertEquals(buttonLabels.get(2), EXPECTED_BUTTON_3_LABEL);
		assertEquals(buttonLabels.get(3), EXPECTED_BUTTON_4_LABEL);
	}

}
