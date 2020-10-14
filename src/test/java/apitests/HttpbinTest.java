package apitests;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utils.ApiTestConfig;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class HttpbinTest extends ApiTestConfig {
	/**
	 * positive
	 */
	@Test
	public void postDelay() {
		given().
				spec(requestSpecificationForHtttpBin)
				.when().post("3").
				then().spec(responseSpecificationForForHtttpBin).log().body();
	}

	@Test
	public void postDelayTime() {
		Response response1 = given().
				spec(requestSpecificationForHtttpBin)
				.when().post("1");

		Response response2 = given().
				spec(requestSpecificationForHtttpBin)
				.when().post("10");
		assertTrue(response1.getTime() / 1000 > 1 && response1.getTime() / 1000 < 5);
		assertTrue(response2.getTime() / 1000 > 10);
	}

	/**
	 * negative
	 */
	@Test
	public void postDelayNegative() {
		given().
				spec(requestSpecificationForHtttpBin)
				.when().post("o").
				then().spec(responseSpecificationForForHtttpBinNegative).log().body();
	}
}
