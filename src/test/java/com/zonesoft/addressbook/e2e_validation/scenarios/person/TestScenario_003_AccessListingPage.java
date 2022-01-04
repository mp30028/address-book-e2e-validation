package com.zonesoft.addressbook.e2e_validation.scenarios.person;

import org.junit.jupiter.api.Test;

import com.zonesoft.addressbook.e2e_validation.pages.IndexPage;
import com.zonesoft.addressbook.e2e_validation.pages.person.PersonsListingPage;
import com.zonesoft.addressbook.e2e_validation.validators.IndexPageValidator;
import com.zonesoft.addressbook.e2e_validation.validators.person.ListingPageValidator;

class TestScenario_003_AccessListingPage{
	
	@Test
	void runScenario() {
		IndexPage indexPage = start_withIndexPage();
		PersonsListingPage personsListingPage = go_fromIndexPage_toListingPage_clickingPersonsLink(indexPage);
		indexPage = go_fromListingPage_toIndexPage_clickingHomeButton(personsListingPage);
		indexPage.quit();
	}
	
	private IndexPage start_withIndexPage() {
		IndexPage indexPage = new IndexPage().open();
		IndexPageValidator.validate(indexPage);
		return indexPage;
	}

	private PersonsListingPage go_fromIndexPage_toListingPage_clickingPersonsLink(IndexPage indexPage) {
		PersonsListingPage personsListingPage = indexPage.personsLinkClick();
		ListingPageValidator.validate(personsListingPage);
		return personsListingPage;
	}

	private IndexPage go_fromListingPage_toIndexPage_clickingHomeButton(PersonsListingPage personsListingPage) {
		IndexPage indexPage = personsListingPage.homeButtonClick();
		IndexPageValidator.validate(indexPage);
		return indexPage;
	}
}
