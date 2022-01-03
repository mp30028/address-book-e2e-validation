package com.zonesoft.addressbook.e2e_validation.scenarios.greeting;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import com.zonesoft.addressbook.e2e_validation.pages.IndexPage;
import com.zonesoft.addressbook.e2e_validation.pages.greeting.HelloPage;
import com.zonesoft.addressbook.e2e_validation.properties.E2eValidationProperties;
import com.zonesoft.addressbook.e2e_validation.scenarios.AbstractLandingPage;

class TestGreetingScenario extends AbstractLandingPage {

	
	private static final int EXPECTED_NUMBER_OF_MESSAGES = 2;
	private static final String EXPECTED_GREETING_MESSAGE = "Hello, Hello User!";
	private static final String EXPECTED_TIME_MESSAGE_STARTS_WITH = "Today is ";
	private static final int EXPECTED_TIME_MESSAGE_LENGTH = 39;
	private static final int GREETING_MESSAGE_INDEX = 0;
	private static final int TIME_MESSAGE_INDEX = 1;
	
	private static final String EXPECTED_STARTING_PAGE_LINK_TEXT = "Go to starting page";
	private static final String EXPECTED_STARTING_PAGE_HREF = "/index.html";
	
	
	private static E2eValidationProperties properties = new E2eValidationProperties(); 
	
	@Test
	void runScenario() {
		IndexPage indexPage = navigate_toIndexPage();
		HelloPage helloPage = navigate_fromIndexPage_toHelloPage(indexPage);
		indexPage = navigate_fromHelloPage_toIndexPage(helloPage);
	}

	private HelloPage navigate_fromIndexPage_toHelloPage(IndexPage indexPage) {
		HelloPage helloPage = indexPage.helloLinkClick();
		validateHelloPage_displayedMessages(helloPage);
		validateHelloPage_startingPageLink(helloPage);
		return helloPage;
	}

	private void validateHelloPage_startingPageLink(HelloPage helloPage) {
		assertEquals(EXPECTED_STARTING_PAGE_LINK_TEXT, helloPage.startingPageLinkText());
		assertEquals(properties.getBaseUrl() + EXPECTED_STARTING_PAGE_HREF, helloPage.startingPageLinkHref());
	}

	private void validateHelloPage_displayedMessages(HelloPage helloPage) {
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
	
	private IndexPage navigate_fromHelloPage_toIndexPage(HelloPage helloPage) {
		IndexPage indexPage = helloPage.startingPageLinkClick();
		validateIndexPage(indexPage);
		return indexPage;
	}


}
