package com.zonesoft.addressbook.e2e_validation.scenarios;

import org.junit.jupiter.api.Test;

import com.zonesoft.addressbook.e2e_validation.pages.IndexPage;
import com.zonesoft.addressbook.e2e_validation.validators.IndexPageValidator;

class TestScenario_001_AccessApplicationLandingPage {
	
	private IndexPage indexPage;
	

	@Test
	void runScenario() {
		IndexPage indexPage = start_withIndexPage();
		indexPage.quit();
	}
	
	private IndexPage start_withIndexPage() {
		indexPage = new IndexPage();
		indexPage.open();
		IndexPageValidator.validate(indexPage);
		return indexPage;
	}
}
