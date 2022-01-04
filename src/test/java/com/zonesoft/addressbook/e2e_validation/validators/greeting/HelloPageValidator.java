package com.zonesoft.addressbook.e2e_validation.validators.greeting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import com.zonesoft.addressbook.e2e_validation.pages.greeting.HelloPage;
import com.zonesoft.addressbook.e2e_validation.properties.E2eValidationProperties;

public class HelloPageValidator {
	private static final E2eValidationProperties properties = new E2eValidationProperties();
	private static final int EXPECTED_NUMBER_OF_MESSAGES = 2;
	private static final String EXPECTED_GREETING_MESSAGE = "Hello, Hello User!";
	private static final String EXPECTED_TIME_MESSAGE_STARTS_WITH = "Today is ";
	private static final int EXPECTED_TIME_MESSAGE_LENGTH = 39;
	private static final int GREETING_MESSAGE_INDEX = 0;
	private static final int TIME_MESSAGE_INDEX = 1;
	
	private static final String EXPECTED_STARTING_PAGE_LINK_TEXT = "Go to starting page";
	private static final String EXPECTED_STARTING_PAGE_HREF = "/index.html";
	
	public static void validate(final HelloPage helloPage) {
		validateHelloPage_displayedMessages(helloPage);
		validateHelloPage_startingPageLink(helloPage);
	}
	
	private static void validateHelloPage_startingPageLink(HelloPage helloPage) {
		assertEquals(EXPECTED_STARTING_PAGE_LINK_TEXT, helloPage.startingPageLinkText());
		assertEquals(properties.getBaseUrl() + EXPECTED_STARTING_PAGE_HREF, helloPage.startingPageLinkHref());
	}

	private static void validateHelloPage_displayedMessages(HelloPage helloPage) {
		// Get the messages displayed
		List<String> messages = helloPage.messagesDisplayedText();
		assertNotNull(messages);
		assertEquals(EXPECTED_NUMBER_OF_MESSAGES, messages.size());
		
		// Check Greeting Message
		assertEquals(EXPECTED_GREETING_MESSAGE, messages.get(GREETING_MESSAGE_INDEX));
		
		// Check Time Message
		assertTrue(messages.get(TIME_MESSAGE_INDEX).startsWith(EXPECTED_TIME_MESSAGE_STARTS_WITH));
		assertEquals(EXPECTED_TIME_MESSAGE_LENGTH,  messages.get(TIME_MESSAGE_INDEX).length());
	}
	
}
