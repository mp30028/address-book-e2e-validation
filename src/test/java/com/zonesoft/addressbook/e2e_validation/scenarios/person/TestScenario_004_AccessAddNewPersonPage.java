package com.zonesoft.addressbook.e2e_validation.scenarios.person;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.zonesoft.addressbook.e2e_validation.interfaces.IHtmlInput;
import com.zonesoft.addressbook.e2e_validation.pages.IndexPage;
import com.zonesoft.addressbook.e2e_validation.pages.person.PersonUpdatePage;
import com.zonesoft.addressbook.e2e_validation.pages.person.PersonsListingPage;

class TestScenario_004_AccessAddNewPersonPage extends TestScenario_003_AccessListingPage{
	
	private static final String SCENARIO_DESCRIPTION = 
			"From Landing Page Navigate to Add New Person Page then Cancel and return\r\n"
			+ "1. Start with Landing Page (static page - index.html)\r\n"
			+ "2. On Landing Page - Click Persons link to go to Persons Listing Page (template - list.html)\r\n"
			+ "3. On Persons Listing Page - Click Add Button - to go to Add New Person Page (template - update.html)\r\n"
			+ "4. On Add New Person Page - Click Cancel Button - to return to Persons Listing Page\r\n"
			+ "5. On Persons Listing Page - Click Home Button - to return to Landing Page\r\n"
			+ "6. Close and quit";
	
	private static final String EXPECTED_UPDATE_PAGE_TITLE = "Persons";
	private static final String EXPECTED_CRUD_TYPE = "ADD";
	private static final String EXPECTED_PERSON_ID = "-1";
	private static final String EXPECTED_FIRSTNAME = "";
	private static final String EXPECTED_LASTNAME = "";
	private static final String EXPECTED_DOB = "";

	@Test
	@Override
	@DisplayName(SCENARIO_DESCRIPTION)
	protected void runScenario() {
		IndexPage indexPage = start_withIndexPage();
		PersonsListingPage personsListingPage = go_fromIndexPage_toListingPage_clickingPersonsLink(indexPage);
		PersonUpdatePage personUpdatePage = go_fromListingPage_toUpdatePage_clickingAddButton(personsListingPage);
		personsListingPage = go_fromUpdatePage_toListingPage_clickingCancelButton(personUpdatePage);
		indexPage = go_fromListingPage_toIndexPage_clickingHomeButton(personsListingPage);
		indexPage.quit();
	}

	protected PersonUpdatePage go_fromListingPage_toUpdatePage_clickingAddButton(PersonsListingPage personsListingPage) {
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

	protected PersonsListingPage go_fromUpdatePage_toListingPage_clickingCancelButton(PersonUpdatePage personUpdatePage) {
		PersonsListingPage personsListingPage =  personUpdatePage.cancelButtonClick();
		ListingPageValidator.validate(personsListingPage);
		return personsListingPage;
	}

	protected static class UpdatePageValidator {
		
		public static final String CRUD_TYPE = "CRUD_TYPE";
		public static final String PAGE_TITLE = "PAGE_TITLE";
		public static final String PERSON_ID = "PERSON_ID";
		public static final String FIRSTNAME = "FIRSTNAME";
		public static final String LASTNAME = "LASTNAME";
		public static final String DOB = "DOB";
		
		private static final String EXPECTED_PERSON_ID_INPUT_TYPE = "hidden";
		private static final String EXPECTED_PERSON_ID_INPUT_NAME = "id";

		private static final String EXPECTED_DOB_INPUT_TYPE = "text";
		private static final String EXPECTED_DOB_INPUT_NAME = "dateOfBirth";

		private static final String EXPECTED_FIRSTNAME_INPUT_TYPE = "text";
		private static final String EXPECTED_FIRSTNAME_INPUT_NAME ="firstname";

		private static final String EXPECTED_LASTNAME_INPUT_TYPE = "text";
		private static final String EXPECTED_LASTNAME_INPUT_NAME = "lastname";

		private static final String EXPECTED_CRUD_TYPE_INPUT_TYPE = "hidden";
		private static final String EXPECTED_CRUD_TYPE_INPUT_NAME = "crudType";
		
		protected static void validate(PersonUpdatePage personUpdatePage, Map<String, String> expectedVariables) {
			assertEquals(expectedVariables.get(PAGE_TITLE), personUpdatePage.pageTitle());
			validatePersonIdInput(personUpdatePage.personIdInput(), Long.parseLong(expectedVariables.get(PERSON_ID)));
			validateCrudTypeInput(personUpdatePage.crudTypeInput(), expectedVariables.get(CRUD_TYPE));
			validateLastnameInput(personUpdatePage.lastnameInput(), expectedVariables.get(LASTNAME));
			validateFirstnameInput(personUpdatePage.firstnameInput(), expectedVariables.get(FIRSTNAME));
			validateDateOfBirthInput(personUpdatePage.dateOfBirthInput(), expectedVariables.get(DOB));
		}

		private static void validateDateOfBirthInput(IHtmlInput input, String expectedDob) {
			assertEquals(expectedDob, input.value());
			assertEquals(EXPECTED_DOB_INPUT_TYPE, input.type());
			assertEquals(EXPECTED_DOB_INPUT_NAME, input.name());
		}

		private static void validateFirstnameInput(IHtmlInput input, String expectedFirstname) {
			assertEquals(expectedFirstname, input.value());
			assertEquals(EXPECTED_FIRSTNAME_INPUT_TYPE, input.type());
			assertEquals(EXPECTED_FIRSTNAME_INPUT_NAME, input.name());
		}

		private static void validateLastnameInput(IHtmlInput input, String expectedLastname) {
			assertEquals(expectedLastname, input.value());
			assertEquals(EXPECTED_LASTNAME_INPUT_TYPE, input.type());
			assertEquals(EXPECTED_LASTNAME_INPUT_NAME, input.name());
		}

		private static void validatePersonIdInput(IHtmlInput input, long expectedPersonId) {
			assertEquals(expectedPersonId, Long.parseLong(input.value()));
			assertEquals(EXPECTED_PERSON_ID_INPUT_TYPE, input.type());
			assertEquals(EXPECTED_PERSON_ID_INPUT_NAME, input.name());
		}

		private static void validateCrudTypeInput(IHtmlInput input, String expectedCrudType) {
			assertEquals(expectedCrudType, input.value());
			assertEquals(EXPECTED_CRUD_TYPE_INPUT_TYPE, input.type());
			assertEquals(EXPECTED_CRUD_TYPE_INPUT_NAME, input.name());
		}
	}

	
}
