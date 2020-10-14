package utils;

import io.restassured.response.Response;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * for download files
 */
public class DownLoadManager {
	public static void downloadUrlAsFile(final Map<String, String> cookies, final Map<String, String> headers,
								   final String urlToDownload, final File outputPath, final String filename) throws IOException {

		File outputFile = new File(outputPath.getPath(), filename);

		final Response response = given().headers(headers).cookies(cookies).when().get(urlToDownload).andReturn();

		// check if the URL actually exists
		if (response.getStatusCode() == 200) {

			// if it already exists you might choose to return and not overwrite it
			if (outputFile.exists()) {
				outputFile.delete();
			}

			// get the contents of the file
			byte[] fileContents = response.getBody().asByteArray();

			OutputStream outStream = null;

			try {

				outStream = new FileOutputStream(outputFile);
				outStream.write(fileContents);

			} catch (Exception e) {

			} finally {

				if (outStream != null) {
					outStream.close();
				}
			}
		}
	}

	public static void setUp(String downloadFileName) {
		//create new folder for download image
		String downloadFolder = "downloads";
		File outputPath = new File(downloadFolder);
		outputPath.mkdirs();

		Map<String, String> cookies = new HashMap();
		Map<String, String> headers = new HashMap();

		File checkDownloaded = new File(outputPath.getPath(), downloadFileName);
		if (checkDownloaded.exists()) {
			checkDownloaded.delete();
		}
	}
}
