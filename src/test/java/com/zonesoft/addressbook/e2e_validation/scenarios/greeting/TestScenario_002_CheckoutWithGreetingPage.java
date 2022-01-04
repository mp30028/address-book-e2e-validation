package com.zonesoft.addressbook.e2e_validation.scenarios.greeting;

import org.junit.jupiter.api.Test;
import com.zonesoft.addressbook.e2e_validation.pages.IndexPage;
import com.zonesoft.addressbook.e2e_validation.pages.greeting.HelloPage;
import com.zonesoft.addressbook.e2e_validation.validators.IndexPageValidator;
import com.zonesoft.addressbook.e2e_validation.validators.greeting.HelloPageValidator;

class TestScenario_002_CheckoutWithGreetingPage {

	@Test
	void runScenario() {
		IndexPage indexPage = start_withIndexPage();
		HelloPage helloPage = go_fromIndexPage_toHelloPage_clickingHelloLink(indexPage);
		indexPage = go_fromHelloPage_toIndexPage_clickingStartingPageLink(helloPage);
		indexPage.quit();
	}

	private IndexPage start_withIndexPage() {
		IndexPage indexPage = new IndexPage().open();
		IndexPageValidator.validate(indexPage);
		return indexPage;
	}

	private HelloPage go_fromIndexPage_toHelloPage_clickingHelloLink(IndexPage indexPage) {
		HelloPage helloPage = indexPage.helloLinkClick();
		HelloPageValidator.validate(helloPage);
		return helloPage;
	}
	
	private IndexPage go_fromHelloPage_toIndexPage_clickingStartingPageLink(HelloPage helloPage) {
		IndexPage indexPage = helloPage.startingPageLinkClick();
		IndexPageValidator.validate(indexPage);
		return indexPage;
	}


}
