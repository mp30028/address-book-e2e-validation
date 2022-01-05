package com.zonesoft.addressbook.e2e_validation.scenarios.greeting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import com.zonesoft.addressbook.e2e_validation.pages.IndexPage;
import com.zonesoft.addressbook.e2e_validation.pages.greeting.HelloPage;
import com.zonesoft.addressbook.e2e_validation.properties.E2eValidationProperties;
import com.zonesoft.addressbook.e2e_validation.scenarios.TestScenario_001_AccessApplicationLandingPage;

@Nested
class TestScenario_002_CheckoutWithGreetingPage extends TestScenario_001_AccessApplicationLandingPage{

	private static final String SCENARIO_DESCRIPTION = 
		"Simple test to checkout availablity and functioning of Application\r\n"
		+ "1. Open Landing Page using base url (static page - index.html)\r\n"
		+ "2. On Landing Page click 'Go to hello page' link to navigate to Greeting Page (template - /greetings/greeting.html)\r\n"
		+ "3. On Greeting Page click 'Go to starting page' link to return to Landing Page\r\n"
		+ "4. Quit and close Landing Page";
	
//	private static final HelloPageValidator helloPageValidator = new HelloPageValidator();
	
	@Test
	@Override
	@DisplayName(SCENARIO_DESCRIPTION)
	protected void runScenario() {
		IndexPage indexPage = start_withIndexPage();
		HelloPage helloPage = go_fromIndexPage_toHelloPage_clickingHelloLink(indexPage);
		indexPage = go_fromHelloPage_toIndexPage_clickingStartingPageLink(helloPage);
		indexPage.quit();
	}
	
	
	@DisplayName("Validate Greetings Page")
	protected HelloPage go_fromIndexPage_toHelloPage_clickingHelloLink(IndexPage indexPage) {
		HelloPage helloPage = indexPage.helloLinkClick();
		HelloPageValidator.validate(helloPage);
		return helloPage;
	}
	
	protected IndexPage go_fromHelloPage_toIndexPage_clickingStartingPageLink(HelloPage helloPage) {
		IndexPage indexPage = helloPage.startingPageLinkClick();
		IndexPageValidator.validate(indexPage);
		return indexPage;
	}

	static class HelloPageValidator {
		private static final E2eValidationProperties properties = new E2eValidationProperties();
		private static final int EXPECTED_NUMBER_OF_MESSAGES = 2;
		private static final String EXPECTED_GREETING_MESSAGE = "Hello, Hello User!";
		private static final String EXPECTED_TIME_MESSAGE_STARTS_WITH = "Today is ";
		private static final int EXPECTED_TIME_MESSAGE_LENGTH = 36;
		private static final int GREETING_MESSAGE_INDEX = 0;
		private static final int TIME_MESSAGE_INDEX = 1;
		
		private static final String EXPECTED_STARTING_PAGE_LINK_TEXT = "Go to starting page";
		private static final String EXPECTED_STARTING_PAGE_HREF = "/index.html";
		
		static void validate(final HelloPage helloPage) {
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
			assertNotNull(messages, "No messages displayed");
			assertEquals(EXPECTED_NUMBER_OF_MESSAGES, messages.size());
			
			// Check Greeting Message
			assertEquals(EXPECTED_GREETING_MESSAGE, messages.get(GREETING_MESSAGE_INDEX));
			
			// Check Time Message
			assertTrue(messages.get(TIME_MESSAGE_INDEX).startsWith(EXPECTED_TIME_MESSAGE_STARTS_WITH));
			assertEquals(EXPECTED_TIME_MESSAGE_LENGTH,  messages.get(TIME_MESSAGE_INDEX).length());
		}
		
	}
}
