package com.zonesoft.addressbook.e2e_validation.scenarios.person;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.zonesoft.addressbook.e2e_validation.pages.IndexPage;
import com.zonesoft.addressbook.e2e_validation.pages.person.PersonUpdatePage;
import com.zonesoft.addressbook.e2e_validation.pages.person.PersonsListingPage;
import com.zonesoft.addressbook.e2e_validation.validators.IndexPageValidator;
import com.zonesoft.addressbook.e2e_validation.validators.person.ListingPageValidator;
import com.zonesoft.addressbook.e2e_validation.validators.person.UpdatePageValidator;

class TestScenario_004_AccessAddNewPersonPage{
	private static final String EXPECTED_UPDATE_PAGE_TITLE = "Persons";
	private static final String EXPECTED_CRUD_TYPE = "ADD";
	private static final String EXPECTED_PERSON_ID = "-1";
	private static final String EXPECTED_FIRSTNAME = "";
	private static final String EXPECTED_LASTNAME = "";
	private static final String EXPECTED_DOB = "";

	@Test
	void runScenario() {
		IndexPage indexPage = start_withIndexPage();
		PersonsListingPage personsListingPage = go_fromIndexPage_toListingPage_clickingPersonsLink(indexPage);
		PersonUpdatePage personUpdatePage = go_fromListingPage_toUpdatePage_clickingAddButton(personsListingPage);
		personsListingPage = go_fromUpdatePage_toListingPage_clickingCancelButton(personUpdatePage);
		indexPage = go_fromListingPage_toIndexPage_clickingHomeButton(personsListingPage);
		indexPage.quit();
	}

	private IndexPage start_withIndexPage() {
		IndexPage indexPage = new IndexPage().open();
		IndexPageValidator.validate(indexPage);
		return indexPage;
	}
	
	private IndexPage go_fromListingPage_toIndexPage_clickingHomeButton(PersonsListingPage personsListingPage) {
		IndexPage indexPage = personsListingPage.homeButtonClick();
		IndexPageValidator.validate(indexPage);
		return indexPage;
	}

	private PersonUpdatePage go_fromListingPage_toUpdatePage_clickingAddButton(PersonsListingPage personsListingPage) {
		PersonUpdatePage personUpdatePage = personsListingPage.addButtonClick();
		Map<String, String> expectedVariables = new HashMap<String, String>();
		expectedVariables.put(UpdatePageValidator.PAGE_TITLE, EXPECTED_UPDATE_PAGE_TITLE);
		expectedVariables.put(UpdatePageValidator.CRUD_TYPE, EXPECTED_CRUD_TYPE);
		expectedVariables.put(UpdatePageValidator.PERSON_ID, EXPECTED_PERSON_ID);
		expectedVariables.put(UpdatePageValidator.FIRSTNAME, EXPECTED_FIRSTNAME);
		expectedVariables.put(UpdatePageValidator.LASTNAME, EXPECTED_LASTNAME);
		expectedVariables.put(UpdatePageValidator.DOB, EXPECTED_DOB);
		UpdatePageValidator.validate(personUpdatePage, expectedVariables);
		return personUpdatePage;
	}

	private PersonsListingPage go_fromIndexPage_toListingPage_clickingPersonsLink(IndexPage indexPage) {
		PersonsListingPage personsListingPage = indexPage.personsLinkClick();
		ListingPageValidator.validate(personsListingPage);
		return personsListingPage;
	}
	
	private PersonsListingPage go_fromUpdatePage_toListingPage_clickingCancelButton(PersonUpdatePage personUpdatePage) {
		PersonsListingPage personsListingPage =  personUpdatePage.cancelButtonClick();
		ListingPageValidator.validate(personsListingPage);
		return personsListingPage;
	}

}
