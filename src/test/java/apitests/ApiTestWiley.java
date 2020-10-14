package apitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import utils.ApiTestConfig;
import utils.DataManager;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Slf4j
public class ApiTestWiley extends ApiTestConfig {
	@Test
	public void getJavaSearchTest() {
		Response response = given().
				spec(requestSpecificationForWiley).log().uri().
				when().get(DataManager.getValue("wiley_endpoint"));
		log.info("RESPONSE: " + response.asString());

		/**
		 * get arrays from responses
		 */
		List<String> suggestions = response.
				path("suggestions.findAll{it.term}.term");
		log.info("suggestions: " + suggestions.toString());

		List<String> pages = response.
				path("pages.findAll{it.title}.title");
		log.info("pages: " + pages.toString());

		/**
		 * Assertions
		 */
		assertEquals(200, response.getStatusCode());

		for (String term : suggestions) {
			assertTrue(term.contains("java"));
		}

		for (String title : pages) {
			assertTrue(title.contains("Wiley"));
		}
	}
}
