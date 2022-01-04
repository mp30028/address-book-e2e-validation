package com.zonesoft.addressbook.e2e_validation.validators.person;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import com.zonesoft.addressbook.e2e_validation.interfaces.IHtmlInput;
import com.zonesoft.addressbook.e2e_validation.pages.person.PersonUpdatePage;

public class UpdatePageValidator {
	
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
	
	public static void validate(PersonUpdatePage personUpdatePage, Map<String, String> expectedVariables) {
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
