package com.zonesoft.addressbook.e2e_validation.validators.person;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;


import com.zonesoft.addressbook.e2e_validation.pages.person.PersonsListingPage;

public class ListingPageValidator {
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
