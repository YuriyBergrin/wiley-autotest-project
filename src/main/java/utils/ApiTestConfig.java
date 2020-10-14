package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;

/**
 * config for api tests
 */
public class ApiTestConfig {
	/**
	 * Wiley
	 */
	protected RequestSpecification requestSpecificationForWiley = new RequestSpecBuilder().
			setBaseUri(DataManager.getValue("wiley_base_url")).
			setBasePath(DataManager.getValue("wiley_path_url")).
			build().param("term", "Java");
	/**
	 * http bin
	 */

	protected RequestSpecification requestSpecificationForHtttpBin = new RequestSpecBuilder().
			setBaseUri(DataManager.getValue("httpbin_base_url")).
			setBasePath(DataManager.getValue("httpbin_endpoint")).
			addHeader("Content-Type", "application/json").
			build();

	protected ResponseSpecification responseSpecificationForForHtttpBin = new ResponseSpecBuilder().
			expectStatusCode(200).
			build();

	protected ResponseSpecification responseSpecificationForForHtttpBinNegative = new ResponseSpecBuilder().
			expectStatusCode(500).
			build();
	/**
	 * image test
	 */
	protected RequestSpecification requestSpecificationForHtttpBinImage = new RequestSpecBuilder().
			setBaseUri(DataManager.getValue("httpbin_base_url")).
			addHeader("Content-Type", "application/json").
			build();
}
