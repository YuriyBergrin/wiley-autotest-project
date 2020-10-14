package apitests;

import io.restassured.RestAssured;
import io.restassured.filter.log.UrlDecoder;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utils.ApiTestConfig;
import utils.DataManager;
import utils.DownLoadManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HttpbinImageTest extends ApiTestConfig {

	@Test
	public void imageTest() {
		Response response = given().
				spec(requestSpecificationForHtttpBinImage).log().uri().
				when().get(DataManager.getValue("httpbin_endpoint_image") + "png");
		/**
		 * assertions
		 */
		assertEquals(200, response.getStatusCode());
		assertTrue(response.getContentType().contentEquals("image/png"));
	}

	/**
	 * may use to put image into report probably
	 * image will be in the downloads folder of project root
	 */
	@Test
	public void canDownloadImage() throws IOException {
		String urlToDownload =
				DataManager.getValue("httpbin_base_url") +
						DataManager.getValue("httpbin_endpoint_image") +
						"png";
		assertTrue(new DownLoadManager().isImageDownloaded(urlToDownload));
	}
}
